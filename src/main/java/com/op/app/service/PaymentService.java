package com.op.app.service;

import com.op.app.model.Transaction;

public interface PaymentService {

    /**
     * Methode qui permet de faire un paiement d'un compte à un autre
     * @param senderId identifiant du payeur
     * @param receiverId identifiant du receveur
     * @param amount montant de la transaction
     * @return la transaction
     */
    Transaction makePayment(Long senderId, Long receiverId, double amount);
}
