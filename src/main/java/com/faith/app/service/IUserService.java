package com.faith.app.service;

import org.springframework.http.ResponseEntity;

import com.faith.app.common.APIResponse;
import com.faith.app.entity.User;

public interface IUserService {
	//custom method
	//public User findUserByNameAndPassword(String userName ,String password);

	public APIResponse findUserByNameAndPassword(String userName ,String password);
	
	public APIResponse mailVerify(String email);
	
	public void insertOtp(int otp,String email);
	
	public APIResponse passWordChange(int otp,String passWord,int userId);

}
