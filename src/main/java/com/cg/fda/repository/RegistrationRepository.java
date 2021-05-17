package com.cg.fda.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fda.domain.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,String> {
    

	
}