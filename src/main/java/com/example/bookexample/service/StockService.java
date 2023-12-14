package com.example.bookexample.service;

import com.example.bookexample.model.Stock;

import java.util.ArrayList;

public interface StockService {
    ArrayList<Stock> findAllStocks();
    Stock findStockByTickerSymbol (String tickerSymbol);
    void addStock(Stock S);
    void updateStock (Stock S);
    void deleteStock(Stock S);
    void deleteStockByTickerSymbol(String tickerSymbol);
    void deleteAllStocks();
}
