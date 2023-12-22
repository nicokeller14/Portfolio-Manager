package com.example.bookexample.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Stock {

    @Id
    @NotNull
    private String tickerSymbol;

    @Column
    private String companyName;

    @Column
    private double currentPrice;

    @Column
    private String sector;

    private long purchaseDate;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private Set<StockTrade> stockTransactions;
}
