package com.nit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetails {
	@Id
	@GeneratedValue
	private Integer courseId;
	private String courseName;
	private String Location;
	private String courseCategory;
	private String facultyName;
	private Double fee;
	private String adminName;
	private Long adminContact;
	private String triningMode;
	private LocalDateTime startDate;
	private String courseStatus;
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime creationDate;
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime updationDate;
	private String createdBy;
	private String updatedBy;

}
