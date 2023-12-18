package com.example.bookexample.presentation;

import com.example.bookexample.model.StockTrader;
import com.example.bookexample.service.StockTraderService;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

public class StockTraderCrudListener implements CrudListener<StockTrader> {

    private final StockTraderService stockTraderService;

    public StockTraderCrudListener(StockTraderService stockTraderService) {
        this.stockTraderService = stockTraderService;
    }

    @Override
    public Collection<StockTrader> findAll() {
        return stockTraderService.findAllStockTraders();
    }

    @Override
    public StockTrader add(StockTrader stockTrader) {
        stockTraderService.addStockTrader(stockTrader);
        return stockTrader;
    }

    @Override
    public StockTrader update(StockTrader stockTrader) {
        stockTraderService.updateStockTrader(stockTrader);
        return stockTrader;
    }

    @Override
    public void delete(StockTrader stockTrader) {
        stockTraderService.deleteStockTraderById(stockTrader.getTraderId());
    }
}
