package components.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/restaurant")
public class RestaurantController {
	
	@GetMapping
	//(value = "/restaurant/{restaurantId}")
	public ModelAndView getRestaurantProfile(@PathVariable Long restaurantId) {
		ModelAndView modelAndView=new ModelAndView("restaurantProfile"); 
		return modelAndView;
	}
	
	@GetMapping(value = "/")
	public ModelAndView getIndex(@PathVariable Long restaurantId) {
		ModelAndView modelAndView=new ModelAndView("index.jsp"); 
		return modelAndView;
	}

	
}