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
    private String tradeSymbol;
}
