package com.faith.app.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.common.APIResponse;
import com.faith.app.entity.User;

public interface IUserORepository extends CrudRepository<User, Integer>{
	
	@Query("from User where userName=?1 and passWord=?2")
	public User findUserByUserNameAndPassword(String userName,String password);
	
	@Query("from User where email=?1")
	public User mailVerify(String email);
	
	@Modifying
	@Query("update User set otp=?1 where email=?2")
	public void insertOtp(int otp,String email);
	
	@Query("from User where otp=?1 and userId=?2")
	public User verifyOtp(int otp,int userId);
	
	@Modifying
	@Query("update User set passWord=?1 where userId=?2")
	public void updatePassword(String passWord,int userId);
	
	@Query("SELECT d.doctorName FROM Doctor d JOIN d.user u WHERE u.userId = ?1")
	public String getNameOfDoctor(int userId);
	
	@Query("SELECT s.staffName FROM Staff s JOIN s.user u WHERE u.userId = ?1")
	public String getNameOfStaff(int userId);

	
}
