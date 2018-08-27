package components.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import components.JsonToDTOConverter;
import components.dtos.business.CategoryDTO;
import components.dtos.filter.CommentFilterDTO;
import components.dtos.filter.NotificationFilterDTO;
import components.services.interfaces.CategoryService;
import components.services.interfaces.RestaurantService;
import model.business.Category;
import model.business.Restaurant;
import model.filter.CommentFilter;
import model.filter.NotificationFilter;



@Controller
@RequestMapping(value = "/restaurant/")
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
	
	@GetMapping(value = "/{restaurantId}")
	public ModelAndView getRestaurantProfile(@PathVariable Long restaurantId) {
		Restaurant restaurant = restaurantService.getRestuarantByID(restaurantId);
		ModelAndView model = new ModelAndView();
		model.setViewName("restaurantProfile");
		model.addObject("restaurant", restaurant);
		return model;
	}
	
	
	@RequestMapping(value = "/getCommentFilters")
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
	
}