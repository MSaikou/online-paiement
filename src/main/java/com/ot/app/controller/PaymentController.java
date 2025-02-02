package com.ot.app.controller;

import com.ot.app.model.Transaction;
import com.ot.app.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Transaction makePayment(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam double amount){
        return paymentService.makePayment(senderId, receiverId, amount);
    }
}
