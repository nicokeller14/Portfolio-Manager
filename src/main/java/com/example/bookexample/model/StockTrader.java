package com.example.bookexample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class StockTrader {

    @Id
    @GeneratedValue
    private long traderId;

    private String traderName;
    private String experienceLevel;
    private String tradingStrategy;

    @OneToMany(mappedBy = "stockTrader", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Portfolio> managedPortfolios;

}
