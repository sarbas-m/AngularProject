package com.faith.app.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class Medicine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer medicineId;
	private String medicineNumber;
	private String medicineName;
	private Integer quantity;
	private Double price;
	private String medicineIsActive;
	@PrePersist
	@PreUpdate
	public void prepersist() {
		if(medicineIsActive == null)   
			medicineIsActive = "true";
	}
	@OneToMany(mappedBy="medicine")
	private List<MedicinePrescription> medicinePrescription;
	
	private Integer companyId;
	@ManyToOne
	@JoinColumn(name="companyId",insertable=false,updatable=false)
	private MedicineCompany medicineCompany;
	
	@OneToMany(mappedBy="medicine")
	private List<MedicineOrder> medicineOrder;
	public Integer getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineNumber() {
		return medicineNumber;
	}

	public void setMedicineNumber(String medicineNumber) {
		this.medicineNumber = medicineNumber;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMedicineIsActive() {
		return medicineIsActive;
	}

	public void setMedicineIsActive(String medicineIsActive) {
		this.medicineIsActive = medicineIsActive;
	}

	public List<MedicinePrescription> getMedicinePrescription() {
		return medicinePrescription;
	}

	public void setMedicinePrescription(List<MedicinePrescription> medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public MedicineCompany getMedicineCompany() {
		return medicineCompany;
	}

	public void setMedicineCompany(MedicineCompany medicineCompany) {
		this.medicineCompany = medicineCompany;
	}

	public List<MedicineOrder> getMedicineOrder() {
		return medicineOrder;
	}

	public void setMedicineOrder(List<MedicineOrder> medicineOrder) {
		this.medicineOrder = medicineOrder;
	}

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medicine(Integer medicineId, String medicineNumber, String medicineName, Integer quantity, Double price,
			String medicineIsActive, List<MedicinePrescription> medicinePrescription, Integer companyId,
			MedicineCompany medicineCompany, List<MedicineOrder> medicineOrder) {
		super();
		this.medicineId = medicineId;
		this.medicineNumber = medicineNumber;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.price = price;
		this.medicineIsActive = medicineIsActive;
		this.medicinePrescription = medicinePrescription;
		this.companyId = companyId;
		this.medicineCompany = medicineCompany;
		this.medicineOrder = medicineOrder;
	}

	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineNumber=" + medicineNumber + ", medicineName="
				+ medicineName + ", quantity=" + quantity + ", price=" + price + ", medicineIsActive="
				+ medicineIsActive + ", companyId=" + companyId + "]";
	}
	
	


}