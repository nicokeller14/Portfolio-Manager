package com.example.bookexample.repository;

import com.example.bookexample.model.Investor;
import com.example.bookexample.model.StockTrader;
import org.springframework.data.repository.CrudRepository;

public interface StockTraderRepository extends CrudRepository<StockTrader, Long> {
    Investor findByTraderId(long id);

}
