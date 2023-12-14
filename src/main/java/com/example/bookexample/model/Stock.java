package com.example.bookexample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private String tickerSymbol;

    private String companyName;
    private int quantity;
    private double purchasePrice;
    private String purchaseDate;
    private double currentPrice;
    private String sector;

    @ManyToMany(mappedBy = "stocks")
    private Set<Portfolio> portfolios;
}
