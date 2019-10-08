package com.project.MentorOnDemand.MentorDetails;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


public interface MentorDetailsRepository extends CrudRepository<MentorDetails, String> {

	@Query(value = "SELECT userName from MentorDetails")
    ArrayList<String> findAllUserNames();

}
