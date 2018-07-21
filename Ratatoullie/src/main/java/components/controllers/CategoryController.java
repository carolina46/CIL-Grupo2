package components.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import components.services.interfaces.CategoryService;
import model.business.Category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping(value = "/category/")
public class CategoryController{
	 
	@Autowired
	private CategoryService categoryService;
		
	@RequestMapping(value = "/categoryForm", method = RequestMethod.GET)
	public ModelAndView getCategoryForm() {
		return new ModelAndView("categoryForm", "name", new Category());
	}
	
	@RequestMapping(value = "/categoryForm", method = RequestMethod.POST)
	public ModelAndView postCategoryForm( @ModelAttribute("category") Category category, BindingResult result) {
		categoryService.saveCategory(category);
		return new ModelAndView("index");
		
	}
	
	@RequestMapping(value = "/listCategory")
	public ModelAndView listCategories() {
		List<Category> list= categoryService.getAllCategorys();
		ModelAndView modelo= new ModelAndView("listCategories");
		modelo.addObject("categories", list);
	    return modelo;
	}
	
  }
