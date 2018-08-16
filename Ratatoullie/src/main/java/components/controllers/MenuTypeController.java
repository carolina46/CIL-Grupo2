package components.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

import components.JsonToDTOConverter;
import components.dtos.business.MenuTypeDTO;
import components.services.interfaces.MenuTypeService;
import model.business.MenuType;



@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/menuType/")
public class MenuTypeController {

	@Autowired
	private MenuTypeService menuTypeService;
	@Autowired
    private ModelMapper modelMapper;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> listMenuTypes() {
		//I get the list of MenuType from the BD.
		List<MenuType> listOfMenuType = menuTypeService.getAllMenuTypes();
		
		//Converts the List<MenuType> to List<MenuTypeDTO>
		java.lang.reflect.Type targetListType = new TypeToken<List<MenuTypeDTO>>() {}.getType();
	    List<MenuTypeDTO> listOfMenuTypeDTOs = modelMapper.map(listOfMenuType, targetListType);
		
	    //Converts the list of MenuTypeDTO to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(listOfMenuTypeDTOs);
    	        
        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public @ResponseBody ResponseEntity<String> saveMenuType( @RequestBody String object) {
		//Converts the JSON to MenuTypeDTO
		MenuTypeDTO menuTypeDTO = new Gson().fromJson(object, MenuTypeDTO.class);
		
		//Converts the MenuTypeDTO to MenuType
		MenuType menuType = modelMapper.map(menuTypeDTO, MenuType.class);
		
		//Save the menuType in the DB
		menuTypeService.saveMenuType(menuType);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public @ResponseBody ResponseEntity<String> updateMenuType( @RequestBody String object) {
		//Converts the JSON to MenuTypeDTO
		MenuTypeDTO menuTypeDTO = new Gson().fromJson(object, MenuTypeDTO.class);
		
		//Converts the MenuTypeDTO to MenuType
		MenuType menuType = modelMapper.map(menuTypeDTO, MenuType.class);
		
		//Update the menuType in the DB
		menuTypeService.updateMenuType(menuType);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public @ResponseBody ResponseEntity<String> deleteMenuType( @RequestBody String object) {
		//Converts the JSON to MenuTypeDTO
		MenuTypeDTO menuTypeDTO = new Gson().fromJson(object, MenuTypeDTO.class);
		
		//Converts the MenuTypeDTO to MenuType
		MenuType menuType = modelMapper.map(menuTypeDTO, MenuType.class);
		
		//Save the menuType in the DB
		menuTypeService.removeMenuType(menuType);
		
		return new ResponseEntity<String>("", HttpStatus.OK);
	}
	
	
}
