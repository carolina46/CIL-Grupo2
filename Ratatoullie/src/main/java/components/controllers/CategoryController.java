package components.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import components.JsonToDTOConverter;
import components.dtos.business.CategoryDTO;
import components.services.interfaces.CategoryService;
import model.business.Category;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/category/")
public class CategoryController{
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping(value = "/categoryForm", method = RequestMethod.GET)
	public ModelAndView getCategoryForm() {
		return new ModelAndView("categoryForm", "name", new Category());
	}
		
	@RequestMapping(value="/categoryForm", headers="Accept=*/*", method = RequestMethod.POST, produces="application/json; charset=UTF-8")
	public @ResponseBody ResponseEntity<String> postCategoryForm(@RequestBody String object){
		//Convert the JSON objetct to the actual Category
		Category category = (Category)JsonToDTOConverter.convertJsonToDTO(object, Category.class);
		
		Long savedOid = categoryService.saveCategory(category);
		
		if(savedOid != 0l) { //oid is not zero, it was saved without errors
			category.setOid(savedOid);
			
			//Converts the actual saved Category to its DTO
			CategoryDTO savedDTOCategory = modelMapper.map(category, CategoryDTO.class);
			
			//Converts the DTO to JSON
			String savedJSONCategory = JsonToDTOConverter.convertToJason(savedDTOCategory);
			System.out.println("JSON a devolver = "+ savedJSONCategory);
			//Return the saved Category in JSON format
			return new ResponseEntity<String>(savedJSONCategory, HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/listCategory")
	public ResponseEntity<String> listCategories() {
		List<CategoryDTO> listDTO = new ArrayList<CategoryDTO>();
		List<Category> list = categoryService.getAllCategorys();
		
		//Iterates the list of Category to make a list of CategoryDTO
		for (Category c : list) {
			CategoryDTO categoryDTO = modelMapper.map(c, CategoryDTO.class);
			listDTO.add(categoryDTO);	
		}
		
		//Converts the list of CategoryDTO to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(listDTO);
    	System.out.println(jsonResult);
        //List<CategoryDTO> listDTO2 = (List<CategoryDTO>) JsonToDTOConverter.convertListJsonToDTO(jsonResult);
		
    	//ModelAndView modelo= new ModelAndView("listCategories");
		//modelo.addObject("categories", listDTO2);
	   // return modelo;
        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
  }
