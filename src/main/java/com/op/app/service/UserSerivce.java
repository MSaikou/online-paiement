package com.op.app.service;

import com.op.app.dto.UserDto;
import com.op.app.model.User;

public interface UserSerivce {

    /**
     * Methode de creation d'utilisateur
     * @param userDto
     * @return l'utilisateur créer
     */
    User createUser(UserDto userDto);

    /**
     * Methode qui retourne le solde dans le compte d'un utilisateur
     * @param idUser
     * @return le solde
     */
    double getBalance(Long idUser);

}
