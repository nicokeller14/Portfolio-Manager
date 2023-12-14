package com.example.bookexample.presentation;

import com.example.bookexample.model.Investor;
import com.example.bookexample.model.Stock;
import com.example.bookexample.service.InvestorService;
import com.example.bookexample.service.StockService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("")
public class MainView extends VerticalLayout {

    private final InvestorService investorService;
    private final StockService stockService;

    public MainView(InvestorService investorService, StockService stockService) {
        this.investorService = investorService;
        this.stockService = stockService;

        GridCrud<Investor> crudInvestor = new GridCrud<>(Investor.class);
        crudInvestor.setCrudListener(new InvestorCrudListener(investorService));
        add(crudInvestor);

        GridCrud<Stock> crudStock = new GridCrud<>(Stock.class);
        crudStock.setCrudListener(new StockCrudListener(stockService));
        add(crudStock);
    }
}
