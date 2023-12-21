package com.example.bookexample.repository;

import com.example.bookexample.model.Investor;
import com.example.bookexample.model.StockTrade;
import org.springframework.data.repository.CrudRepository;

public interface StockTradeRepository extends CrudRepository<StockTrade, Long> {
    Investor findByTraderId(long id);

}
