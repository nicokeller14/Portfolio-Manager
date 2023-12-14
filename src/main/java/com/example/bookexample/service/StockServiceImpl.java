package com.example.bookexample.service;

import com.example.bookexample.model.Stock;
import com.example.bookexample.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Service("BookService")
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    ArrayList<Stock> stockList = new ArrayList<>();
    @Override
    public ArrayList<Stock> findAllStocks() {

        ArrayList<Stock> stockListRepo = (ArrayList<Stock>) stockRepository.findAll();
        if (stockListRepo.isEmpty())
            return stockList;
        else
            return stockListRepo;
    }
    @Override
    public Stock findStockByTickerSymbol(String stockTicker) {

        return stockRepository.findByTickerSymbol(stockTicker);

    }
    @Override
    public void addStock(Stock s) {
        stockList.add(s);
        stockRepository.save(s);
    }
    @Override
    public void deleteAllStocks() {
        stockList.clear();
        stockRepository.deleteAll();
    }
    @Override
    public void deleteStock(Stock s) {
        Stock deleteStock = null;
        for (Stock stock : stockList) {
            if (stock.getTickerSymbol() == s.getTickerSymbol()) {
                deleteStock = s;
            }
        }

        if (deleteStock != null) {
            stockList.remove(deleteStock);
            stockRepository.delete(deleteStock);

        }
    }

    @Override
    public void deleteStockByTickerSymbol(String tickerSymbol) {
        Stock deleteStock = null;
        for (Stock s : stockList) {
            if (s.getTickerSymbol() == tickerSymbol) {
                deleteStock = s;
            }
        }

        if (deleteStock != null) {
            stockList.remove(deleteStock);
            stockRepository.delete(deleteStock);

        }
    }

    @Override
    public void updateStock(Stock s) {
        for (Stock stock : stockList) {
            if (stock.getTickerSymbol() == s.getTickerSymbol()) {
                stock.setCompanyName(s.getCompanyName());
                stock.setQuantity(s.getQuantity());
                stock.setPurchasePrice(s.getPurchasePrice());
                stock.setPurchaseDate(s.getPurchaseDate());
                stock.setCurrentPrice(s.getCurrentPrice());
                stock.setSector(s.getSector());
                stock.setPortfolios(s.getPortfolios());
                stockRepository.save(stock);
            }
        }
    }
}

