package com.catalogmanagementsystem.services;

import com.catalogmanagementsystem.entities.Card;

public interface CardService {
	Card addCard(Long userId, Card card);
    
}

