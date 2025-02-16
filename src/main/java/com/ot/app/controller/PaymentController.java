package com.ot.app.controller;

import com.ot.app.model.Transaction;
import com.ot.app.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@Tag(name = "Transaction", description = "Api de paiement")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(operationId = "transactionId", description = "Permet de faire un paiement.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Paiement effectuer", content = @Content(schema = @Schema(implementation = Transaction.class)))})
    @PostMapping
    public ResponseEntity<Transaction> makePayment(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam double amount) {
        return new ResponseEntity<>(paymentService.makePayment(senderId, receiverId, amount), HttpStatus.ACCEPTED);
    }
}
