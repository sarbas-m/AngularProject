package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.Department;

public interface IRecDepartmentRepo extends CrudRepository<Department, Integer>{

}
