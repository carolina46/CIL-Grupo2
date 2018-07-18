package components.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import components.services.interfaces.CategoryService;
import components.services.interfaces.RestaurantService;
import model.business.Category;
import model.business.Restaurant;



@Controller
@RequestMapping(value = "/restaurant/")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/restaurantForm")
	public ModelAndView showRestaurantForm() {
		
		Category category=new Category("Fast Food");
		categoryService.saveCategory(category);
		
		
		ModelAndView model = new ModelAndView();
		model.setViewName("restaurantForm");
		return model;
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
	
	

	
	
	
}