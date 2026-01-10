package com.op.app.service.implementation;

import com.op.app.exception.SoldeInsuffisantException;
import com.op.app.model.Transaction;
import com.op.app.repository.PaymentRepository;
import com.op.app.repository.UserRepository;
import com.op.app.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;


    public PaymentServiceImpl(UserRepository userRepository, PaymentRepository paymentRepository) {
        this.userRepository = userRepository;
        this.paymentRepository = paymentRepository;
    }

    public Transaction makePayment(Long senderId, Long receiverId, double amount) {

        var sender = userRepository.findById(senderId).orElseThrow(() -> new RuntimeException("Expediteur non trouver"));
        var receiver = userRepository.findById(receiverId).orElseThrow(() -> new RuntimeException("Destinataire non trouver"));

        if (sender.getBalance() < amount) {
            throw new SoldeInsuffisantException("Solde insuffisant");
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
