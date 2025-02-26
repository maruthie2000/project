package com.nit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Travel")
public class TravelPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;

	private String planeName;

	private String planDescription;

	private Double planMinBudget;

	private Integer planCategoryId;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp // creates date and time automatically
	
	private LocalDateTime createdDate;

	@Column(name = "UPDATED_DATE", updatable = true, insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;

	@Column(name = "CREATED_BY", length = 20)
	private String createdBy;

	@Column(name = "UPDATED_BY", length = 20)
	private String updatedBy;

	@Column(name = "ACTIVE_SW", length = 15)
	private String activeSW = "active";
}
