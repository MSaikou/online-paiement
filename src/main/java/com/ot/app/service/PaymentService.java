package com.ot.app.service;

import com.ot.app.model.Transaction;
import com.ot.app.model.User;
import com.ot.app.repository.PaymentRepository;
import com.ot.app.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;


    public PaymentService(UserRepository userRepository, PaymentRepository paymentRepository) {
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
    }

    public Transaction makePayment(Long senderId, Long receiverId, double amount) {

        User sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Expediteur non trouver"));
        User receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Destinataire non trouver"));

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Solde insuffisant");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        userRepository.save(sender);
        userRepository.save(receiver);

        Transaction transaction = new Transaction();
        transaction.setSenderId(senderId);
        transaction.setReceiverId(receiverId);
        transaction.setAmount(amount);
        transaction.setTransactionDateTime(LocalDateTime.now());

        return paymentRepository.save(transaction);
    }

}
