package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Doctor;

public interface IRecDoctorRepo extends CrudRepository<Doctor, Integer>{
	
	

}
