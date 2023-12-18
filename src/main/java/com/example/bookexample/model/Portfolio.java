package com.example.bookexample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolioId;

    private String openingDate;
    private String portfolioName;
    private String investmentStrategy;
    private float investmentAmount;
    private String investmentCurrency;

    @ManyToOne
    @JoinColumn(name = "investor_id", nullable = false)
    private Investor investor;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Portfolio_Stock",
            joinColumns = { @JoinColumn(name = "portfolio_id") },
            inverseJoinColumns = { @JoinColumn(name = "stock_id") }
    )
    private Set<Stock> stocks;

    @ManyToOne
    @JoinColumn(name = "trader_id", nullable = false)
    private StockTrader stockTrader;
}
