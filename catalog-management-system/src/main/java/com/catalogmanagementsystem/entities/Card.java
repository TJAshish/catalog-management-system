package com.catalogmanagementsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Card {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long cardId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotEmpty
    private String cardNumber;

    @NotEmpty
    private String expiryDate;

    @NotEmpty
    private String cardholderName;

    
    private String billingAddress;


}
