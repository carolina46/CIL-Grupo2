package components.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import components.JsonToDTOConverter;
import components.dtos.CategoryDTO;
import components.services.interfaces.CategoryService;
import model.business.Category;

import java.util.ArrayList;
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
	public ModelAndView postCategoryForm( @ModelAttribute("category") CategoryDTO categoryDTO, BindingResult result) {
		Category category = convertToEntity(categoryDTO);
		categoryService.saveCategory(category);
		return new ModelAndView("index");
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/listCategory")
	public ModelAndView listCategories() {
		List<CategoryDTO> listDTO = new ArrayList<CategoryDTO>();
		List<Category> list = categoryService.getAllCategorys();
		
		//Iterates the list of Category to make a list of CategoryDTO
		for (Category c : list) {
			CategoryDTO categoryDTO = convertToDTO(c);
			listDTO.add(categoryDTO);	
		}
		
		//Converts the list of CategoryDTO to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(listDTO);
    	
        List<CategoryDTO> listDTO2 = (List<CategoryDTO>) JsonToDTOConverter.convertListJsonToDTO(jsonResult);
		
    	ModelAndView modelo= new ModelAndView("listCategories");
		modelo.addObject("categories", listDTO2);
	    return modelo;
	}
	
	public Category convertToEntity(CategoryDTO categoryDTO) {
		//Converts the DTO to the actual object
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category.setOid(categoryDTO.getOid());
		return category;		
	}
	
	public CategoryDTO convertToDTO(Category category) {
		//Converts the Object to its DTO
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setName(category.getName());
		categoryDTO.setOid(category.getOid());	
		return categoryDTO;
	
}
  }
