package com.faith.app.service;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.app.common.APIResponse;
import com.faith.app.demo.EmailSenderService;
import com.faith.app.entity.User;
import com.faith.app.repo.IUserORepository;
import com.faith.app.util.JwtUtil;
@Service
public class UserServiceImplimentation implements IUserService {

	@Autowired 
	private IUserORepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private EmailSenderService service;
	

	@Override
	public APIResponse findUserByNameAndPassword(String userName, String password) {
		APIResponse apiResponse=new APIResponse();
		//verify user exist or not 
		User user=userRepository.findUserByUserNameAndPassword(userName, password);
		if(user==null) {
			apiResponse.setData("user login failed");
					return apiResponse;
		}
		//creadentials are valid generate a tocken 
		String tocken=jwtUtil.generateJwt(user);
		
		//storing more details and tocken 
		Map<String ,Object> data =new HashMap<String ,Object >();
		data.put("AccessTocken", tocken);
		data.put("roleId", user.getRoleId());
		data.put("userId", user.getUserId());
		data.put("username", user.getUserName());
		apiResponse.setStatus(200);
		apiResponse.setData(data);
		return apiResponse;
	}


	@Override
	@Transactional
	public APIResponse mailVerify(String email) {
		
		APIResponse apiResponse=new APIResponse();
		
		User user=userRepository.mailVerify(email);
		
		if(user==null) {
			apiResponse.setData("mail not found");
					return apiResponse;
		}
		
        Random random = new Random();
        int min = 100000; // Minimum 6-digit number
        int max = 999999; // Maximum 6-digit number
        int otp = random.nextInt(max - min + 1) + min;
        
        insertOtp(otp,user.getEmail());
        
        String mail=user.getEmail();
        String sub= "Forgot Password OTP";
        String doctorName="";
        if(user.getRoleId()==1) {
        	doctorName=userRepository.getNameOfDoctor(user.getUserId());
        }
        else {
        	doctorName=userRepository.getNameOfStaff(user.getUserId());
        }
        String body="Dear "+doctorName+",\r\n" + 
        		"\r\n" + 
        		"You have requested to reset your password. Please use the following OTP to proceed with the password reset process:"+
                 "\n\nOTP = "+otp+""+
        		"\n\nIf you did not request a password reset, we strongly advise you to contact our administrator immediately"+
                 "\nto investigate this matter further and secure your account. You can reach our administrator at 8943906568"+
        		"\nPlease refrain from clicking any links or providing any personal information until this issue has been resolved.\r\n" + 
        		"\r\n" + 
        		"Thank you for your prompt attention to this matter.\r\n" + 
        		"\r\n" + 
        		"Sincerely,\r\n" + 
        		"Admin,"+
        		"Med Star Hospital";
       service.sendSimpleEmail(mail, body, sub);
        
		Map<String ,Object> data =new HashMap<String ,Object >();
		data.put("userId", user.getUserId());
		apiResponse.setData("check you mail  for otp");
		apiResponse.setData(data);
		apiResponse.setStatus(200);
		
	
		return apiResponse;	}


	@Transactional
	public void insertOtp(int otp, String email) {
		
		userRepository.insertOtp(otp, email);
	}


	@Override
	@Transactional
	public APIResponse passWordChange(int otp, String passWord, int userId) {
		APIResponse apiResponse=new APIResponse();
		User user=userRepository.verifyOtp(otp, userId);
		if(user==null) {
			apiResponse.setData("password change failed");
					return apiResponse;
		}
		userRepository.updatePassword(passWord,userId);
		apiResponse.setData("password changed successfully");
		apiResponse.setStatus(200);
		

		return apiResponse;
	}


	
}
