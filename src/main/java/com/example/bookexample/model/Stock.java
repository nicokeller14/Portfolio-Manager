package com.example.bookexample.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Stock {

    @Id
    private String tickerSymbol;

    @Column
    private String companyName;

    @Column
    private double currentPrice;

    @Column
    private String sector;

    private long purchaseDate;

    private long purchasePrice;

    // Fix the mappedBy attribute to point to the correct property in the Portfolio entity
    @ManyToMany(mappedBy = "stocks", cascade = CascadeType.ALL)
    private List<Portfolio> portfolios;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private Set<StockTrade> stockTransactions;
}
