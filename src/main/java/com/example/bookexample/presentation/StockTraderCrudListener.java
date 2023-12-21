package com.example.bookexample.presentation;

import com.example.bookexample.model.StockTrade;
import com.example.bookexample.service.StockTraderService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;


@SpringComponent
public class StockTraderCrudListener implements CrudListener<StockTrade> {

    private final StockTraderService stockTraderService;

    public StockTraderCrudListener(StockTraderService stockTraderService) {
        this.stockTraderService = stockTraderService;
    }

    @Override
    public Collection<StockTrade> findAll() {
        return stockTraderService.findAllStockTraders();
    }

    @Override
    public StockTrade add(StockTrade stockTrader) {
        stockTraderService.addStockTrader(stockTrader);
        return stockTrader;
    }

    @Override
    public StockTrade update(StockTrade stockTrader) {
        stockTraderService.updateStockTrader(stockTrader);
        return stockTrader;
    }

    @Override
    public void delete(StockTrade stockTrader) {
        stockTraderService.deleteStockTraderById(stockTrader.getTraderId());
    }
}
