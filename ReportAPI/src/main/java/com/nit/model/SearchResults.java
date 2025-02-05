package com.nit.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResults {
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
}
