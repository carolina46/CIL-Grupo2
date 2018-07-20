package components.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import components.services.interfaces.CategoryService;
import model.business.Category;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		List<Category> list = categoryService.getAllCategorys();
		
		ModelAndView model = new ModelAndView("categoryForm");
		model.addObject("list",list);
	    return model;
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
