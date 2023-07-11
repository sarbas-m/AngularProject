package com.faith.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.app.entity.Patient;
import com.faith.app.repo.IRecPatientRepository;

@Service
public class PatientServiceImplementation implements IRecPatientService{

	
	@Autowired
	private IRecPatientRepository patientrepo;
	
	@Override
	public List<Patient> getListPatient() {
		// TODO Auto-generated method stub
		return (List<Patient>) patientrepo.getListPatient();
	}

	@Override
	public void addThePatient(Patient patients) {
		// TODO Auto-generated method stub
		System.out.println(patients.getPatientId());
		if(patients.getPatientId()==0) {
			patientrepo.save(patients);
		}
		else {
			String reg=patientrepo.getRegistrationNumber(patients.getPatientId());
			patients.setRegistrationNumber(reg);
			patientrepo.save(patients);
		}
		/*boolean check=true;
		patientrepo.save(patients);
		if(patients.getPatientId()==0) {

		    int patientId=patientrepo.getPrimaryKey();		
		     String registrationNumber="CMS"+(100+patientId);
		
		patients.setRegistrationNumber(registrationNumber);
		patientrepo.save(patients);
		check=false;
		}
		if(check) {
			
			String registrationNumber="CMS"+(100+patients.getPatientId());
			patients.setRegistrationNumber(registrationNumber);
			patientrepo.save(patients);
			
		}*/
		
	}

	@Override
	public Patient getPatientByTheId(int id) {
		// TODO Auto-generated method stub
		return patientrepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"+id));
	}

	@Override
	public void disAblePatient(Patient patient) {
		// TODO Auto-generated method stub
		
		patient.setPatientIsActive("false");
		patientrepo.save(patient);
		
	}

	@Override
	public int getPrimaryKey() {
		
		
		return patientrepo.getPrimaryKey();
	}

	@Override
	public String getRegistrationNumber(int patientId) {
		
		
		return patientrepo.getRegistrationNumber(patientId);
	} 

	

	
}
