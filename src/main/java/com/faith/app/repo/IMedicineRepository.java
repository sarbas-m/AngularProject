package com.faith.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faith.app.entity.Medicine;


@Repository
public interface IMedicineRepository extends CrudRepository<Medicine, Integer> {
	
	@Query("from Medicine where medicineIsActive='true'")
	public List<Medicine> getMedicineList();
	
	
	@Query("select m.medicineNumber from Medicine m where m.medicineId=?1")
	public String getMedicineNumber(int medicineId);

}
