package components.controllers;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import components.JsonToDTOConverter;
import components.daos.interfaces.MenuDAO;
import components.dtos.business.MenuTypeDTO;
import components.dtos.business.RestaurantDTO;
import components.dtos.filter.CommentFilterDTO;
import components.dtos.filter.NotificationFilterDTO;
import components.services.interfaces.CategoryService;
import components.services.interfaces.RestaurantService;
import model.business.Category;
import model.business.Menu;
import model.business.MenuType;
import model.business.Restaurant;
import model.filter.CommentFilter;
import model.filter.NotificationFilter;



@Controller
@RequestMapping(value = "/restaurant/")
@CrossOrigin(origins = "http://localhost:4200", maxAge =13600)
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
    private ModelMapper modelMapper;
	
	
	
	@RequestMapping(value = "/restaurantForm", method = RequestMethod.GET)
	public ModelAndView getRestaurantForm() {
		ModelAndView model = new ModelAndView("restaurantForm","restaurant",new Restaurant());
		List<Category> list = categoryService.getAllCategorys();
		model.addObject("categories", list);
		return model;
	}
	
	@RequestMapping(value = "/restaurantForm", method = RequestMethod.POST)
	public ModelAndView postRestaurantForm(@ModelAttribute("restaurant") Restaurant restaurant, BindingResult result) {
		restaurantService.saveRestaurant(restaurant);
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/listRestaurants")
	public ModelAndView listRestaurants(){
		List<Restaurant> list = restaurantService.getAllRestaurants();
		ModelAndView model = new ModelAndView("listRestaurants");
		model.addObject("restaurants", list);
		return model;
	}
	
	//---------------------------------------------------------------------------------
	//RECOVER FROM THE BD THE RESTAURANT WITH A CERTAIN ID
	@GetMapping(value = "get/{restaurantId}")
	public ResponseEntity<String> getRestaurant(@PathVariable Long restaurantId) {
		//I get the restaurant from the BD.
		Restaurant restaurant = restaurantService.getRestuarantByID(restaurantId);
		//Converts the Restaurant to RestaurantDTO
		RestaurantDTO restaurantDTO = modelMapper.map(restaurant, RestaurantDTO.class);
		//Converts the RestaurantDTO to JSON string
		String jsonResult = JsonToDTOConverter.convertToJason(restaurantDTO);
		   	        
		return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	
	//---------------------------------------------------------------------------------
	//ADD A NEW MENU TO THE RESTAURANT WITH A DETEMINATE ID
	@PostMapping(value = "/saveMenu")
	public @ResponseBody void saveMenu( @RequestBody String object) {
		//Converts the JSON to RestaurantDTO
		RestaurantDTO restaurantDTO = new Gson().fromJson(object, RestaurantDTO.class);
		
		//Converts the RestaurantDTO to Restaurant
		Restaurant restaurant = modelMapper.map(restaurantDTO, Restaurant.class);
		
        //create a new menu
		Menu menuIn, menuNew;
        menuIn = restaurant.getMenus().get(0);
        menuNew = new Menu(menuIn.getMenuType(), menuIn.getName());
        menuNew.setTags(menuIn.getTags());
        
        //Get the restaurant from the BD.
        restaurant = restaurantService.getRestuarantByID(restaurant.getOid());
		
        //Add the new menu to the restaurant 
        restaurant.addMenu(menuNew);
        restaurantService.updateRestaurant(restaurant);
    }
	
	//---------------------------------------------------------------------------------
	//GET THE MENU LIST OF THE RESTAURANT WITH CERTAIN ID
	
	
	
	
	
	
	
	@RequestMapping(value = "/getCommentFilters", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> getCommentFilters() {
		List<CommentFilterDTO> listDTO = new ArrayList<CommentFilterDTO>();
		List<CommentFilter> list = restaurantService.getCommentFilters();
		
		//Iterates the list of CommentFilter to make a list of CommentFilterDTO
		for (CommentFilter cf : list) {
			CommentFilterDTO commentFilterDTO = modelMapper.map(cf, CommentFilterDTO.class);
			listDTO.add(commentFilterDTO);	
		}
		
		//Converts the list of CommentFilter to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(listDTO);
    	
        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getNotificationFilters", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> getNotificationFilters() {
		List<NotificationFilterDTO> listDTO = new ArrayList<NotificationFilterDTO>();
		List<NotificationFilter> list = restaurantService.getNotificationFilters();
		
		//Iterates the list of NotificationFilter to make a list of NotificationFilterDTO
		for (NotificationFilter cf : list) {
			NotificationFilterDTO notificationFilterDTO = modelMapper.map(cf, NotificationFilterDTO.class);
			listDTO.add(notificationFilterDTO);	
		}
		
		//Converts the list of NotificationFilter to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(listDTO);
    	
        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
}