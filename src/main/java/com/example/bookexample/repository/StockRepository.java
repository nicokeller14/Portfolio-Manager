package com.example.bookexample.repository;

import com.example.bookexample.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, String> {
    Stock findByName(String name);
    Stock findByTickerSymbol(String tickerSymbol);

}
