package com.someco.helloworld.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.someco.helloworld.exception.HelloWorldException;
import com.someco.helloworld.model.User;
import com.someco.helloworld.model.UserDocuments;
import com.someco.helloworld.model.UserProfile;
import com.someco.helloworld.service.UserDocumentService;
import com.someco.helloworld.service.UserService;

@Controller
public class HelloWorldController {

	@Autowired
	UserDocumentService userDocumentService;

	@Autowired
	UserService userService;
	
	@RequestMapping("/hello")
	public String hello(Model model) throws Exception {
		model.addAttribute("greeting", "Hello Spring MVC");
		/*
		 * if(true) throw new Exception("Sample exception !!");
		 */
		return "hello";
	}

	@RequestMapping("/staticResources")
	public String staticResources(Model model) {
		model.addAttribute("staticResource", "static resource");
		return "staticResources";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			User user = ((User) principal);
			userName = user.getFirstName() + " " + user.getLastName();

		} else {
			userName = principal.toString();
		}
		// return userName;

		model.addAttribute("user", userName);
		return "home";
	}
	
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws HelloWorldException {
		modelMap.addAttribute("file", file);
		
		try {
			UserDocuments userDocuments = new UserDocuments();
			userDocuments.setDocumentName(file.getOriginalFilename());
			userDocuments.setDocumentMimetype(file.getContentType());
			userDocuments.setDocumentData(file.getBytes());
			userDocuments.setUser(userService.findByUserName(getPrincipal()));
			userDocumentService.saveUserDocument(userDocuments);
		} catch (IOException ioException) {
			throw new HelloWorldException(ioException.getMessage());
		}
		return "fileUploadView";
	}
	
	
	/**
	 * TODO move it to base controller class
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof User) {
            userName = ((User)principal).getUserName();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
