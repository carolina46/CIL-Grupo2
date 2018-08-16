package components.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import components.services.interfaces.UserService;


@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(value = "/users/")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
    private ModelMapper modelMapper;
	
	


}
