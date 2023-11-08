package com.catalogmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogmanagementsystem.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	Optional<Card> findById(Long userId);
    
}

