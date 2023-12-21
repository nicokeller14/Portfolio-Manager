package com.example.bookexample.service;

import com.example.bookexample.model.StockTrade;
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
    public StockTrade findStockTraderById(long traderId) {
        Optional<StockTrade> stockTrader = stockTraderRepository.findById(traderId);
        return stockTrader.orElseThrow(() -> new RuntimeException("StockTrader not found"));
    }

    @Override
    public List<StockTrade> findAllStockTraders() {
        return (List<StockTrade>) stockTraderRepository.findAll();
    }

    @Override
    public void addStockTrader(StockTrade stockTrader) {
        stockTraderRepository.save(stockTrader);
    }

    @Override
    public void updateStockTrader(StockTrade stockTrader) {
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
