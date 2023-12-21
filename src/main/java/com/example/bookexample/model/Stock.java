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

    @Column
    private String companyName;

    @Column
    private double currentPrice;

    @Column
    private String sector;

    @ManyToMany(mappedBy = "stocks")
    private Set<Portfolio> portfolios;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private Set<StockTrade> stockTransactions;
}
