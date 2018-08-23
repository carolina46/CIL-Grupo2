package components.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.gson.Gson;
import components.JsonToDTOConverter;
import components.dtos.users.NormalClientDTO;
import components.dtos.users.ResponsibleDTO;
import components.dtos.users.UserLoginDTO;
import components.dtos.users.UserSessionDTO;
import components.services.interfaces.UserService;
import model.business.Location;
import model.users.NormalClient;
import model.users.Responsible;
import model.users.User;



@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
    private ModelMapper modelMapper;
	
	
	//Find out if the user exist
	@RequestMapping(value = "checkUser/{user}", method = RequestMethod.GET, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public ResponseEntity<Boolean> checkUser( @PathVariable String user) {
		if (user == null || user.length() == 0)
			return new ResponseEntity<Boolean>(true, HttpStatus.INTERNAL_SERVER_ERROR);
		else
			if( this.userService.getUserByUser(user) == null)
				return new ResponseEntity<Boolean>(false, HttpStatus.OK);
			else return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	//Save a responsible user
	@RequestMapping(value = "/saveResponsible", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public ResponseEntity<Boolean>  saveResponsible( @RequestBody String object) {
		//Converts the JSON to ResponsibleDTO
		ResponsibleDTO responsibleDTO = new Gson().fromJson(object, ResponsibleDTO.class);
		
		//Converts the ResponsibleDTO to Responsible
		Responsible responsible = modelMapper.map(responsibleDTO, Responsible.class);
		
		//Create a Responsible
		responsible = new Responsible(responsible.getFullName(),
									  responsible.getUser(),
									  responsible.getPassword(),
									  new Location (0.0, 0.0));
		
		//Save the Responsible in the DB
		Long savedOid = this.userService.saveUser(responsible);
		
		if(savedOid != 0l) { //oid is not zero, it was saved without errors
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Save a normal user
	@RequestMapping(value = "/saveNormal", method = RequestMethod.POST, headers="Accept=*/*", produces="application/json; charset=UTF-8")
	public ResponseEntity<Boolean>  saveNormal( @RequestBody String object) {
			//Converts the JSON to NormalClientDTO
			NormalClientDTO normalDTO = new Gson().fromJson(object, NormalClientDTO.class);
			
			//Converts the NormalClientDTO to NormalClient
			NormalClient normalClient = modelMapper.map(normalDTO, NormalClient.class);

			//Create a normal client
			normalClient = new NormalClient(normalClient.getFullName(),
											normalClient.getUser(),
											normalClient.getPassword(),
											new Location (0.0, 0.0));
			
			//Save the NormalClient in the DB
			Long savedOid = this.userService.saveUser(normalClient);
			
			if(savedOid != 0l) { //oid is not zero, it was saved without errors
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
			else{
				return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	//control a user's login
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<String> login(@RequestBody String object) {
		//Converts the JSON to userLoginDTO
		UserLoginDTO userLoginDTO = new Gson().fromJson(object, UserLoginDTO.class);
		
		//I get the user if the password and the user are correct
		User user = this.userService.login(userLoginDTO.getPassword(), userLoginDTO.getUser()) ;
				
		if(user == null) return new ResponseEntity<String>("", HttpStatus.OK);
		else {
			//Converts the user to UserSessionDTO
			UserSessionDTO userSessionDTO = new UserSessionDTO(user);
			
			//Converts the UserSessionDTO to json
			String jsonResult = JsonToDTOConverter.convertToJason(userSessionDTO); 

			return new ResponseEntity<String>(jsonResult, HttpStatus.OK);
		}
		
		
		
	}
	
	
	
	
	


}
