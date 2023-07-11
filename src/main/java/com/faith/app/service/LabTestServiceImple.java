package com.faith.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.app.entity.Test;
import com.faith.app.repo.ILabTestRepository;

import java.util.List;

@Service
public class LabTestServiceImple implements ILabTestService {

    @Autowired
    private ILabTestRepository labtestrepo;

    @Override
    public void saveTest(Test labtest) {
    	System.out.println("testId"+labtest.getTestId());
    	if(labtest.getTestId()==null) {
    		System.out.println("hi");
    		labtestrepo.save(labtest);
    	}
    	
    	else {
    		String testNumber=labtestrepo.getTestNumber(labtest.getTestId());
    		labtest.setTestNumber(testNumber);
    		labtestrepo.save(labtest);
    	}
    }

    @Override
    public List<Test> getListTest() {
        return (List<Test>) labtestrepo.findAll();
    }
    
    
    @Override
	public void deleteTest(Test test) {
     test.setIsActive("false");
     labtestrepo.save(test);
     
	}

  
	@Override
	public Test getTest(Integer id) {
		// TODO Auto-generated method stub
		return  labtestrepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found for id" + id));
	}

	@Override
	public List<Test> getTestByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void disableTest(int testId) {
		
		labtestrepo.disableTest(testId);
	}

	@Override
	public List<Test> getTestList() {
		// TODO Auto-generated method stub
		return labtestrepo.getTestList();
	}

	@Override
	public String getTestNumber(int testId) {
		
		return labtestrepo.getTestNumber(testId);
	}

	@Override
	public List<Test> getTestListForId(int testId) {
		// TODO Auto-generated method stub
		return labtestrepo.getTestListForId(testId);
	}

	
	
}
