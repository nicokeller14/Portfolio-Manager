package com.example.bookexample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Portfolio")
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolioId;

    @Column
    private String openingDate;

    @Column
    private String portfolioName;

    @Column
    private String investmentStrategy;

    @Column
    private float investmentAmount;

    @Column
    private String investmentCurrency;

    // Fix the mappedBy attribute to point to the correct property in the Stock entity
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "portfolio_stock",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_ticker")
    )
    private List<Stock> stocks;

    @ManyToOne
    @JoinColumn(name = "investorId", nullable = false)
    private Investor investor;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private Set<StockTrade> stockTransactions;

}
