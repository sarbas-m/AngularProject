package com.faith.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.faith.app.entity.MedicineBill;


public interface IMedBillRepository extends CrudRepository<MedicineBill , Integer> {

}
