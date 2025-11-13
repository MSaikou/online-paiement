package com.op.app.controller;

import com.op.app.dto.UserDto;
import com.op.app.model.User;
import com.op.app.service.implementation.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
@Tag(name = "Utilisateurs", description = "Api de gestion des Uitilisateurs")
public class UserController {

    private final UserService userService;

    @Operation(operationId = "createUserId", description = "Créer un nouvel utilisateur")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Utilisateur creer", content = @Content(schema = @Schema(implementation = User.class)))})
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDto) {
        User user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @Operation(operationId = "getBalanceId", description = "Récuperation du solde d'un utilisateur")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Information récupérer avec succès.", content = @Content(schema = @Schema(implementation = Double.class)))})
    @GetMapping("/{userId}/balances")
    public double getBalance(@PathVariable Long userId) {
        return userService.getBalance(userId);
    }
}
