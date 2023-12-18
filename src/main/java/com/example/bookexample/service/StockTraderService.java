package com.example.bookexample.service;

import com.example.bookexample.model.StockTrader;

import java.util.List;

public interface StockTraderService {
    StockTrader findStockTraderById(long traderId);
    List<StockTrader> findAllStockTraders();
    void addStockTrader(StockTrader stockTrader);
    void updateStockTrader(StockTrader stockTrader);
    void deleteStockTraderById(long traderId);
}
