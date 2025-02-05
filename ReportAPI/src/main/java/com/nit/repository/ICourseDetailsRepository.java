package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.CourseDetails;

@Repository
public interface ICourseDetailsRepository extends JpaRepository<CourseDetails, Integer> {
	
}
