package com.ot.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public class UserDto {
    @NotBlank(message = "Le nom est obligatoire")
    private String name;
    @Min(value = 0, message = "Le solde ne peut pas être negatif")
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
