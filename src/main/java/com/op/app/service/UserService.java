package com.op.app.service;

import com.op.app.dto.UserDto;
import com.op.app.model.User;

public interface UserService {

    /**
     * Methode de creation d'utilisateur
     * @param userDto utilisateur à créer
     * @return l'utilisateur créer
     */
    User createUser(UserDto userDto);

    /**
     * Methode qui retourne le solde dans le compte d'un utilisateur
     * @param idUser identifiant de l'utilisateur
     * @return le solde
     */
    double getBalance(Long idUser);

}
