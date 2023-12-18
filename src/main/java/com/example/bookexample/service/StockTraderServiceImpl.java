package com.example.bookexample.service;

import com.example.bookexample.model.StockTrader;
import com.example.bookexample.repository.StockTraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockTraderServiceImpl implements StockTraderService {

    private final StockTraderRepository stockTraderRepository;

    @Autowired
    public StockTraderServiceImpl(StockTraderRepository stockTraderRepository) {
        this.stockTraderRepository = stockTraderRepository;
    }

    @Override
    public StockTrader findStockTraderById(long traderId) {
        Optional<StockTrader> stockTrader = stockTraderRepository.findById(traderId);
        return stockTrader.orElseThrow(() -> new RuntimeException("StockTrader not found"));
    }

    @Override
    public List<StockTrader> findAllStockTraders() {
        return (List<StockTrader>) stockTraderRepository.findAll();
    }

    @Override
    public void addStockTrader(StockTrader stockTrader) {
        stockTraderRepository.save(stockTrader);
    }

    @Override
    public void updateStockTrader(StockTrader stockTrader) {
        if (!stockTraderRepository.existsById(stockTrader.getTraderId())) {
            throw new RuntimeException("StockTrader not found");
        }
        stockTraderRepository.save(stockTrader);
    }

    @Override
    public void deleteStockTraderById(long traderId) {
        stockTraderRepository.deleteById(traderId);
    }
}
