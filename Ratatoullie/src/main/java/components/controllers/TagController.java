package components.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import components.JsonToDTOConverter;
import components.dtos.business.TagDTO;
import components.services.interfaces.TagService;
import model.business.Tag;


@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 100000)
@RequestMapping(value = "/tag/")
public class TagController {
	
	@Autowired
	private TagService tagService;
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<String> listTags() {
		//I get the list of Tags from the BD.
		List<Tag> listOfTags = tagService.getAllTags();
		
		//Converts the List<Tag> to List<TagDTO>
		java.lang.reflect.Type targetListTags = new TypeToken<List<TagDTO>>() {}.getType();
	    List<TagDTO> listOfTagDTOs = modelMapper.map(listOfTags, targetListTags);
		
	    //Converts the list of TagDTO to JSON string
        String jsonResult = JsonToDTOConverter.convertToJason(listOfTagDTOs);
    	        
        return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
	}

}
