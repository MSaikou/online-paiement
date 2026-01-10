package com.op.app.repository;

import com.op.app.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Transaction, Long> {
}
