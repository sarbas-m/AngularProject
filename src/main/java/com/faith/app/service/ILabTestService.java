package com.faith.app.service;

import java.util.List;
import com.faith.app.entity.Test;

public interface ILabTestService {
	//add
    public void saveTest(Test labtest);
    //list
    public List<Test> getListTest();
    //update
    public Test getTest(Integer id);
    //delete
    public  void deleteTest(Test test);
    //find by test name
    public List<Test>getTestByName(String name);
    
    public void disableTest(int testId);
    
    public List<Test> getTestList();
    
    public String getTestNumber(int testId);
    
    public List<Test> getTestListForId(int testId);
    
}
