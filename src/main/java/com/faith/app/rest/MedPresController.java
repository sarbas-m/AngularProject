package com.faith.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faith.app.entity.MedicinePrescription;
import com.faith.app.service.IMedPresService;


@CrossOrigin  //inorder to avoid port number conflict
@RestController  //@Controller +@Configuration
@RequestMapping("/api")
public class MedPresController {

		@Autowired
		private IMedPresService medPresService;
		
		
		@GetMapping("press")
		public List<MedicinePrescription>getMedPres(){
			System.out.println("hihh");
			return medPresService.getMedPrescription();
		}
		
		@GetMapping("press/{appointmentId}")
		public List<MedicinePrescription> getMedicinePresHistory(@PathVariable int appointmentId){
         System.out.println("hi"+appointmentId);
		return medPresService.getPresHistory(appointmentId);
		}
		
		@DeleteMapping("press/{appointmentId}")
		public void disableMedPrescription(@PathVariable int appointmentId) {
			medPresService.disableMedPrescription(appointmentId);
			
		}
		
}
