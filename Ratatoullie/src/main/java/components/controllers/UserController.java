package components.controllers;

import java.lang.reflect.Modifier;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import components.JsonToDTOConverter;
import components.dtos.business.MenuTypeDTO;
import components.dtos.business.NewRestaurantDTO;
import components.dtos.business.RestaurantDTO;
import components.dtos.users.NormalClientDTO;
import components.dtos.users.ResponsibleDTO;
import components.dtos.users.UserLoginDTO;
import components.dtos.users.UserSessionDTO;
import components.services.interfaces.CategoryService;
import components.services.interfaces.UserService;
import model.business.Category;
import model.business.Location;
import model.business.MenuType;
import model.business.Restaurant;
import model.filter.ComensalCommentFilter;
import model.filter.CompositeCommentFilter;
import model.filter.DenyCommentFilter;
import model.filter.GourmetCommentFilter;
import model.filter.VisitorCommentFilter;
import model.users.NormalClient;
import model.users.Responsible;
import model.users.User;



@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
    private ModelMapper modelMapper;
	
	
	//Find out if the user exist
	@RequestMapping(value = "checkUser/{user}", method = RequestMethod.GET, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public ResponseEntity<Boolean> checkUser( @PathVariable String user) {
		if (user == null || user.length() == 0)
			return new ResponseEntity<Boolean>(true, HttpStatus.INTERNAL_SERVER_ERROR);
		else
			if( this.userService.getUserByUser(user) == null)
				return new ResponseEntity<Boolean>(false, HttpStatus.OK);
			else return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	//Save a responsible user
	@RequestMapping(value = "/saveResponsible", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public ResponseEntity<Boolean>  saveResponsible( @RequestBody String object) {
		//Converts the JSON to ResponsibleDTO
		ResponsibleDTO responsibleDTO = new Gson().fromJson(object, ResponsibleDTO.class);
		
		//Converts the ResponsibleDTO to Responsible
		Responsible responsible = modelMapper.map(responsibleDTO, Responsible.class);
		
		//Create a Responsible
		responsible = new Responsible(responsible.getFullName(),
									  responsible.getUser(),
									  responsible.getPassword(),
									  new Location (0.0, 0.0));
		
		//Save the Responsible in the DB
		Long savedOid = this.userService.saveUser(responsible);
		
		if(savedOid != 0l) { //oid is not zero, it was saved without errors
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Save a normal user
	@RequestMapping(value = "/saveNormal", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public ResponseEntity<Boolean>  saveNormal( @RequestBody String object) {
			//Converts the JSON to NormalClientDTO
			NormalClientDTO normalDTO = new Gson().fromJson(object, NormalClientDTO.class);
			
			//Converts the NormalClientDTO to NormalClient
			NormalClient normalClient = modelMapper.map(normalDTO, NormalClient.class);

			//Create a normal client
			normalClient = new NormalClient(normalClient.getFullName(),
											normalClient.getUser(),
											normalClient.getPassword(),
											new Location (0.0, 0.0));
			
			//Save the NormalClient in the DB
			Long savedOid = this.userService.saveUser(normalClient);
			
			if(savedOid != 0l) { //oid is not zero, it was saved without errors
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	//control a user's login
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<String> login(@RequestBody String object) {
		//Converts the JSON to userLoginDTO
		UserLoginDTO userLoginDTO = new Gson().fromJson(object, UserLoginDTO.class);
		
		//I get the user if the password and the user are correct
		User user = this.userService.login(userLoginDTO.getPassword(), userLoginDTO.getUser()) ;
				
		if(user == null) return new ResponseEntity<String>("", HttpStatus.OK);
		else {
			//Converts the user to UserSessionDTO
			UserSessionDTO userSessionDTO = new UserSessionDTO(user);
			
			//Converts the UserSessionDTO to json
			String jsonResult = JsonToDTOConverter.convertToJason(userSessionDTO); 

			return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
		}
		
		
		
	}
	
	
	//Add a new restaurant to the Responsible
	@PostMapping(value = "responsible/addRestaurant")
	public ResponseEntity<Boolean> addRestaurant(@RequestBody String object) {
		//Converts the JSON to NewRestaurantDTO
		NewRestaurantDTO newRestaurantDTO = new Gson().fromJson(object, NewRestaurantDTO.class);
		
		//Looking for the user in the bd
		Responsible aResponsible = (Responsible) this.userService.getUserByID(newRestaurantDTO.getResponsible());
		
		//Looking for the category in the bd
		Category category = categoryService.getCategoryByID(newRestaurantDTO.getCategory());
		
		//create the Location
		Location location = new Location(newRestaurantDTO.getLatitude(), newRestaurantDTO.getLongitude());
		
		//Create the new restaurant
		Restaurant restaurant = new Restaurant(newRestaurantDTO.getName(), category, location);
		
		//Create the commentfilter
		CompositeCommentFilter composite = new CompositeCommentFilter();
	    if(newRestaurantDTO.getVisitor()) composite.addFilter(new VisitorCommentFilter());
	    if(newRestaurantDTO.getComensal()) composite.addFilter(new ComensalCommentFilter());
	    if(newRestaurantDTO.getGourmet()) composite.addFilter(new GourmetCommentFilter());
	    if(composite.getConfigurationFilters().size() == 0) restaurant.setCommentFilter(new DenyCommentFilter());
	    else
	      if(composite.getConfigurationFilters().size() > 1) restaurant.setCommentFilter(composite);
	      else restaurant.setCommentFilter( composite.getConfigurationFilters().get(0));
				
		//Add the restaurant to the responsible and save.
		aResponsible.addRestaurant(restaurant);
		if(this.userService.updateUser(aResponsible))
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		else
				return new ResponseEntity<Boolean>(false, HttpStatus.OK);

	}
	
	
	//Return a user's restaurants
	@RequestMapping(value = "myRestaurants/{user}", method = RequestMethod.GET, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public ResponseEntity<String> getMyRestaurants( @PathVariable Long user) {
			List<Restaurant> listOfRestaurants = this.userService.getUserRestaurants(user);
			//Converts the List<Restaurant> to List<RestaurantDTO>
			//java.lang.reflect.Type targetListType = new TypeToken<List<RestaurantDTO>>() {}.getType();
		   // List<RestaurantDTO> listOfRestaurantDTOs = modelMapper.map(listOfRestaurants, targetListType);
			
		    //Converts the list of MenuTypeDTO to JSON string
	        String jsonResult = JsonToDTOConverter.convertToJason(listOfRestaurants);
	    	        
	        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
				
	}
	
	
	


}
