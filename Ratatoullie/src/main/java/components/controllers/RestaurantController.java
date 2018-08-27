package components.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import components.JsonToDTOConverter;
import components.dtos.filter.ComensalCommentFilterDTO;
import components.dtos.filter.ComensalNotificationFilterDTO;
import components.dtos.filter.CommentFilterDTO;
import components.dtos.filter.DenyCommentFilterDTO;
import components.dtos.filter.DenyNotificationFilterDTO;
import components.dtos.filter.GourmetCommentFilterDTO;
import components.dtos.filter.GourmetNotificationFilterDTO;
import components.dtos.filter.NotificationFilterDTO;
import components.dtos.filter.VisitorCommentFilterDTO;
import components.dtos.filter.VisitorNotificationFilterDTO;
import components.services.interfaces.CategoryService;
import components.services.interfaces.RestaurantService;
import model.business.Category;
import model.business.Restaurant;



@Controller
@RequestMapping(value = "/restaurant/")
@CrossOrigin(origins = "http://localhost:4200", maxAge =13600)
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private CategoryService categoryService;
	
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
	
	@GetMapping(value = "/{restaurantId}")
	public ModelAndView getRestaurantProfile(@PathVariable Long restaurantId) {
		Restaurant restaurant = restaurantService.getRestuarantByID(restaurantId);
		ModelAndView model = new ModelAndView();
		model.setViewName("restaurantProfile");
		model.addObject("restaurant", restaurant);
		return model;
	}
	
	
	@RequestMapping(value = "/getCommentFilters", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> getCommentFilters() {
		//I get a list of all CommentFilterDTO and return in JSON format
		ArrayList<CommentFilterDTO> filtersDTO = new ArrayList<CommentFilterDTO>();  
		
		DenyCommentFilterDTO f1 = new DenyCommentFilterDTO();
		VisitorCommentFilterDTO f2 = new VisitorCommentFilterDTO();
		ComensalCommentFilterDTO f3 = new ComensalCommentFilterDTO();
		GourmetCommentFilterDTO f4 = new GourmetCommentFilterDTO();
		filtersDTO.add(f1);
		filtersDTO.add(f2);
		filtersDTO.add(f3);
		filtersDTO.add(f4);
		
		//Converts the list of CommentFilter to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(filtersDTO);
    	
        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getNotificationFilters", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> getNotificationFilters() {
		//I get a list of all NotificationFilterDTO and return in JSON format
		ArrayList<NotificationFilterDTO> filtersDTO = new ArrayList<NotificationFilterDTO>();  
				
		DenyNotificationFilterDTO f1 = new DenyNotificationFilterDTO();
		VisitorNotificationFilterDTO f2 = new VisitorNotificationFilterDTO();
		ComensalNotificationFilterDTO f3 = new ComensalNotificationFilterDTO();
		GourmetNotificationFilterDTO f4 = new GourmetNotificationFilterDTO();
		filtersDTO.add(f1);
		filtersDTO.add(f2);
		filtersDTO.add(f3);
		filtersDTO.add(f4);
				
		//Converts the list of CommentFilter to JSON string
		String jsonResult = JsonToDTOConverter.convertToJason(filtersDTO);
		    	
		return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
}