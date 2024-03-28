package com.ait.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name =  "citizen_app")
public class CitizenApp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "app_number")
	private Integer appNumber;
	
	@Column(name = "full_name")
	private String fullName;
	
	private Long ssn;
	
	private LocalDate dob;
	
	private String gender;
	
	@Column(name = "plan_id")
	private Integer planId;    //which plan citizen has applied for
	
	@Column(name = "citizen_id")
	private Integer citizenId;  //which citizen has created the app
	
	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDate updatedDate;
	
}
