package com.example.bookexample.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "StockTransaction")
@Table(name = "stockTransaction")
public class StockTrade {

    @Id
    @GeneratedValue
    private long transactionId;

    @Column
    private double stockPrice;

    @Column
    private int transactionAmount;

    @Column
    private Date date; // may need to change this to a string, check later

    @ManyToOne
    @JoinColumn(name = "portfolioId", nullable = false)
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "tickerSymbol", nullable = false)
    private Stock stock;
}
