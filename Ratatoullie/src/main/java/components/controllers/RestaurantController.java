package components.controllers;

import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.gson.Gson;
import components.JsonToDTOConverter;
import components.dtos.business.MenuDTO;
import components.dtos.business.NewMenuDTO;
import components.dtos.filter.ComensalCommentFilterDTO;
import components.dtos.filter.ComensalNotificationFilterDTO;
import components.dtos.filter.CommentFilterDTO;
import components.dtos.filter.GourmetCommentFilterDTO;
import components.dtos.filter.GourmetNotificationFilterDTO;
import components.dtos.filter.NotificationFilterDTO;
import components.dtos.filter.VisitorCommentFilterDTO;
import components.dtos.filter.VisitorNotificationFilterDTO;
import components.services.interfaces.MenuTypeService;
import components.services.interfaces.RestaurantService;
import model.business.Menu;
import model.business.MenuType;
import model.business.Restaurant;



@Controller
@RequestMapping(value = "/restaurant/")
@CrossOrigin(origins = "http://localhost:4200", maxAge =100000)
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private MenuTypeService menuTypeService;
	@Autowired
    private ModelMapper modelMapper;
	
	//---------------------------------------------------------------------------------
	//RECOVER FROM THE BD THE RESTAURANT WITH A CERTAIN ID
	@GetMapping(value = "get/{restaurantId}")
	public ResponseEntity<String> getRestaurant(@PathVariable Long restaurantId) {
		//I get the restaurant from the BD.
		Restaurant restaurant = restaurantService.getRestuarantByID(restaurantId);
		//Converts the RestaurantDTO to JSON string
		String jsonResult = JsonToDTOConverter.convertToJason(restaurant);
		return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	
	//---------------------------------------------------------------------------------
	//ADD A NEW MENU TO THE RESTAURANT WITH A DETEMINATE ID
	@PostMapping(value = "/saveMenu")
	public ResponseEntity<Boolean>  saveMenu( @RequestBody String object) {
		//Converts the JSON to NewMenuDTO
		NewMenuDTO newMenuDTO = new Gson().fromJson(object, NewMenuDTO.class);
		//I get the menuType from the BD.
		MenuType menuType = menuTypeService.getMenuTypeByID(newMenuDTO.getType());
		//create a new menu
		Menu menuNew = new Menu(menuType, newMenuDTO.getName());
		menuNew.setTags(newMenuDTO.getTags());
        //I get the restaurant from the BD.
        Restaurant restaurant = restaurantService.getRestuarantByID(newMenuDTO.getRestaurant());
		//Add the new menu to the restaurant 
        restaurant.addMenu(menuNew);
        if( restaurantService.updateRestaurant(restaurant))
        	return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        else
        	return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }
	
	
	
	//---------------------------------------------------------------------------------
	//ADD A NEW DISH TO THE MENU
	@PostMapping(value = "/saveDish")
	public ResponseEntity<Boolean>  saveDish( @RequestBody String object) {
		//Converts the JSON to MenuDTO
		MenuDTO menuDTO = new Gson().fromJson(object, MenuDTO.class);
		//Converts the MenuDTO to Menu
		Menu menu = modelMapper.map(menuDTO, Menu.class);
		//create a new menu
		if( restaurantService.updateMenu(menu))
	        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	    else
	        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/getCommentFilters", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> getCommentFilters() {
		//I get a list of all CommentFilterDTO and return in JSON format
		ArrayList<CommentFilterDTO> filtersDTO = new ArrayList<CommentFilterDTO>();  
		
		VisitorCommentFilterDTO f1 = new VisitorCommentFilterDTO();
		ComensalCommentFilterDTO f2 = new ComensalCommentFilterDTO();
		GourmetCommentFilterDTO f3 = new GourmetCommentFilterDTO();
		filtersDTO.add(f1);
		filtersDTO.add(f2);
		filtersDTO.add(f3);
		
		//Converts the list of CommentFilter to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(filtersDTO);
    	
        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getNotificationFilters", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> getNotificationFilters() {
		//I get a list of all NotificationFilterDTO and return in JSON format
		ArrayList<NotificationFilterDTO> filtersDTO = new ArrayList<NotificationFilterDTO>();  
				
		VisitorNotificationFilterDTO f1 = new VisitorNotificationFilterDTO();
		ComensalNotificationFilterDTO f2 = new ComensalNotificationFilterDTO();
		GourmetNotificationFilterDTO f3 = new GourmetNotificationFilterDTO();
		filtersDTO.add(f1);
		filtersDTO.add(f2);
		filtersDTO.add(f3);
				
		//Converts the list of CommentFilter to JSON string
		String jsonResult = JsonToDTOConverter.convertToJason(filtersDTO);
		    	
		return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
}