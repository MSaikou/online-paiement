package com.ot.app.repository;

import com.ot.app.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Transaction, Long> {
}
