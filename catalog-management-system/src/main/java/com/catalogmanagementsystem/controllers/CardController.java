package com.catalogmanagementsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogmanagementsystem.entities.Card;
import com.catalogmanagementsystem.services.CardService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users/{userId}/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> addCard(@PathVariable Long userId,@Valid @RequestBody Card card) {
        Card addedCard = cardService.addCard(userId, card);
        return ResponseEntity.ok(addedCard);
    }

}
