package com.catalogmanagementsystem.serviceImpl;


import com.catalogmanagementsystem.entities.Card;
import com.catalogmanagementsystem.exceptions.UserNotFoundException;
import com.catalogmanagementsystem.repository.CardRepository;
import com.catalogmanagementsystem.repository.UserRepository;
import com.catalogmanagementsystem.services.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
    private CardRepository cardRepository;
	
	@Autowired
    private UserRepository userRepository;

	@Override
    public Card addCard(Long userId, Card card) {
        // Check if the user exists
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }
//        card.setUser(userRepository.findById(userId)); // Set the user for the card
        return cardRepository.save(card);
    }
}

