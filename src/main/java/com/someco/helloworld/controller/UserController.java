package com.someco.helloworld.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.someco.helloworld.exception.HelloWorldException;
import com.someco.helloworld.model.Company;
import com.someco.helloworld.model.User;
import com.someco.helloworld.model.UserProfile;
import com.someco.helloworld.model.UserProfileType;
import com.someco.helloworld.service.CompanyService;
import com.someco.helloworld.service.UserProfileService;
import com.someco.helloworld.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	CompanyService companyService;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@Autowired
	UserProfileService userProfileService;

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String register(Model model) throws Exception {
		return "registration";
	}

	@RequestMapping(value = { "/registration1" }, method = RequestMethod.GET)
	public String register_1(Model model) throws Exception {
		return "registration1";
	}
	
	@RequestMapping(value = { "/userprofile" }, method = RequestMethod.GET)
	public String register_2(Model model) throws Exception {
		return "userProfile";
	}
	
	@RequestMapping(value = { "/getuserdetails" }, method = RequestMethod.GET)
	public String register_3(Model model) throws Exception {
		return "getuserdetails";
	}
	
	@RequestMapping(value = { "/companydetails" }, method = RequestMethod.GET)
	public String register_4(Model model) throws Exception {
		return "companydetails";
	}



	/*
	 * public void setUserService(UserService userService) { this.userService =
	 * userService; }
	 */

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests. If users is already logged-in and
	 * tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			return "home";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "login";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * This method returns true if users is already authenticated [logged-in], else
	 * false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ResponseEntity<User>  newUser(User user) throws HelloWorldException {
		if (user.getUserName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getMaritalStatus().isEmpty()) {
			throw new HelloWorldException("Please provide required user details");
		}
		try {
			UserProfile userProfile = userProfileService.findById(1);
			Set<UserProfile> userProfiles = new HashSet<>();
			userProfiles.add(userProfile);
			user.setUserProfiles(userProfiles);
			userService.saveUser(user);
		} catch (Exception ex) {
			throw new HelloWorldException(ex.getMessage());
		}
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value = "/newCompany", method = RequestMethod.POST)
	public ResponseEntity<Company>  newCompany(Company company)  {
			List<User> user = userService.findAll();
			Set<User> userDetails = new HashSet<>();
			userDetails.addAll(user);
			company.setUser(userDetails);
			companyService.saveCompany(company);
			System.out.println(company);
		return ResponseEntity.ok(company);
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo() {
		return "userInfo";
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public  ResponseEntity<String>  deleteUser(@RequestParam String username) {
	 userService.deleteUser(username);
	 return ResponseEntity.ok("Deleted Successfully");
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<User> updateUser( @RequestParam String username, @RequestParam String firstname ,@RequestParam String lastname, @RequestParam String maritalstatus ,@RequestParam long contactnumber,@RequestParam int age, @RequestParam String email,@RequestParam String projectname,@RequestParam int salary , @RequestParam int experience) {
		 User user = userService.findByUserName(username);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setMaritalStatus(maritalstatus);
		user.setContactNumber(contactnumber);
		user.setProjectName(projectname);
		user.setSalary(salary);
		user.setExperience(experience);
		user.setAge(age);
		user.setEmail(email);
		userService.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
	public  @ResponseBody ResponseEntity<List<User>>  getAllUser( ) {
		 List<User> user = userService.findAll();
		 // System.out.println(user);
         return  ResponseEntity.ok(user);
	}
	
	@RequestMapping(value = "/getAllCompany", method = RequestMethod.GET)
	public  @ResponseBody ResponseEntity<List<Company>>  getAllCompany( ) {
		 List<Company> company = companyService.findAll();
		 //System.out.println(company);
         return  ResponseEntity.ok(company);
	}
	
	@RequestMapping(value = "/getByCompany", method = RequestMethod.GET)
	public  @ResponseBody ResponseEntity<Company>  getByCompany(@RequestParam String companyName ) {
		 Company company = companyService.findByCompany(companyName);
		// System.out.println(company);
         return  ResponseEntity.ok(company);
	}
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<User> userDetails(@ModelAttribute("username")String username, Model model) {
    User user = userService.findByUserName(username);
    //model.addAttribute("userdetail", user);
	return ResponseEntity.ok(user);
	}



	@RequestMapping(value = "/getAllUsersByRole", method = RequestMethod.GET)
	public void getAllUsersByRole() throws HelloWorldException {
		try {
			UserProfile userProfile = userProfileService.findByType(UserProfileType.ADMIN);
			userProfile.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
