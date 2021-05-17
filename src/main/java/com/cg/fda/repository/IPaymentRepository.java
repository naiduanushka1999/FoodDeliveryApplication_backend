package com.cg.fda.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.fda.domain.Payment;

@Repository
public interface IPaymentRepository extends CrudRepository<Payment,Integer> {
	Payment findByPaymentId(int paymentId);
	

}
