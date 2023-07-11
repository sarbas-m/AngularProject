package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.Test;

@Repository
public interface ILabTestRepository  extends CrudRepository<Test, Integer> {
	
	@Query("from Test where testName like %?1%")
	public List<Test> findByTestName(String name);
	
	@Modifying
	@Query("update Test set isActive='false' where testId=?1")
	public void disableTest(int testId);
	
	@Query("from Test where isActive='true'")
	public List<Test> getTestList();
	
	@Query("from Test where testId=?1")
	public List<Test> getTest(int testId);
	
	@Query("select  t.testNumber from Test t where t.testId=?1" )
	public String getTestNumber(int testId);
	
	@Query("from Test where testId=?1")
	public List<Test> getTestListForId(int testId);

}
