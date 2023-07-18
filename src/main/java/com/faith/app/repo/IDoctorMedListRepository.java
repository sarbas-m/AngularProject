package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Medicine;

public interface IDoctorMedListRepository extends CrudRepository<Medicine,Integer> {
	
	@Query("from Medicine where medicineIsActive='true'")
	public List<Medicine> getMedList();

}
