package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Test;

public interface IDoctorTestListRepository extends CrudRepository<Test,Integer> {

	@Query("from Test where isActive='true'")
	public List<Test> getTestList();
}
