package com.cg.fda.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fda.domain.AdminLogin;
import com.cg.fda.domain.Registration;


/*
 * This LoginRepostry method for checking validate users
 */
@Repository
public interface LoginRepository extends JpaRepository<Registration, String>
{ 
	/*
	 * This method for checking whether userId present in database or not
	 */
	
@Query("select t from Registration t where t.userId=:userId")
Registration findByID(@Param("userId") String userId);


@Query("select b from AdminLogin b where b.username=:username")
AdminLogin findByAdminUsername(String username);




}
