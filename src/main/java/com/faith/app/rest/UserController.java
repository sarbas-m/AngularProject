package com.faith.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.common.APIResponse;
import com.faith.app.service.IUserService;

@CrossOrigin            // to avoid the conflict btwn the tomcat and angular port numbers
@RestController        // it is the compination of @Controller and @Configuration
@RequestMapping("/api")
public class UserController {
	
	@Autowired 
	private IUserService userService;
	

	@GetMapping("/userCheck/{userName}&{password}")
	public ResponseEntity<APIResponse> findUserByNameandPassword(@PathVariable String userName ,@PathVariable String password ) {
		System.out.println("hisa");
		
		APIResponse apiResponse=userService.findUserByNameAndPassword(userName, password);
		
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	
	@GetMapping("/usersMail/{email}")
	public ResponseEntity<APIResponse> mailVerify(@PathVariable String email) {
		System.out.println(email);
		
		APIResponse apiResponse=userService.mailVerify(email);
		
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
	
	@GetMapping("/userChange/{otp}&{passWord}&{userId}")
	public ResponseEntity<APIResponse> passWordChange(@PathVariable int otp,@PathVariable String passWord,@PathVariable int userId) {
		System.out.println("hi");
		APIResponse apiResponse=userService.passWordChange(otp, passWord, userId);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
	}
}
