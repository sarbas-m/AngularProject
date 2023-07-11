package com.faith.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.faith.app.entity.Test;
import com.faith.app.service.ILabTestService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LabTestController {

    @Autowired
    private ILabTestService labtestservice;

    @GetMapping("/labtests")
    public List<Test> getAllLabTests() {
        return labtestservice.getTestList();
    }
    @GetMapping("/labtests/{testId}")
    public Test getLabTests(@PathVariable int testId) {
    	System.out.println(testId);
    	System.out.println("sadasd"+labtestservice.getTest(testId));
        return labtestservice.getTest(testId);
    }
    @GetMapping("/labtestsId/{testId}")
    public List<Test> getLabTestsList(@PathVariable int testId) {
    	System.out.println(testId);
    	System.out.println("hi"+labtestservice.getTestListForId(testId));
        return labtestservice.getTestListForId(testId);
    }

    @PostMapping("/labtests")
    public Test addLabTest(@RequestBody Test labtest) {
    	System.out.println("dsds"+labtest);
        labtestservice.saveTest(labtest);
        return labtest;
    }

  //update Tests
    @PutMapping("/test")
    public void updateTests(@RequestBody Test labtest) {
    	labtestservice.saveTest(labtest);
    }

    //delete test
    @DeleteMapping("/test/{id}")
    public void deleteTest(@PathVariable Integer id) {
    labtestservice.disableTest(id);

    }

    //search test by name
    @GetMapping("/Test/search/{name}")
    public List<Test>getAllTestByName(@PathVariable String name){
    return labtestservice.getTestByName(name);
    }
}
