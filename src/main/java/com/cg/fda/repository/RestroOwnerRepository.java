package com.cg.fda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.fda.domain.RestroOwner;

public interface RestroOwnerRepository extends JpaRepository<RestroOwner,String>{

	 @Query("select a from RestroOwner a where a.ownerId=:ownerId")
	    RestroOwner findByOwnerId(String ownerId);
	 
	 @Query("select t from RestroOwner t where t.ownerId=:ownerId")
	 RestroOwner findByID(@Param("ownerId") String ownerId);
}
