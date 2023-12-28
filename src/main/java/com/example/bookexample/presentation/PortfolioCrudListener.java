package com.example.bookexample.presentation;

import com.example.bookexample.model.Portfolio;
import com.example.bookexample.service.PortfolioService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@SpringComponent
public class PortfolioCrudListener implements CrudListener<Portfolio> {

    private final PortfolioService portfolioService;

    public PortfolioCrudListener(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @Override
    public Collection<Portfolio> findAll() {
        return portfolioService.findAllPortfolios();
    }

    @Override
    public Portfolio add(Portfolio portfolio) {
        portfolioService.addPortfolio(portfolio);
        return portfolio;
    }

    @Override
    public Portfolio update(Portfolio portfolio) {
        portfolioService.updatePortfolio(portfolio);
        return portfolio;
    }

    @Override
    public void delete(Portfolio portfolio) {
        portfolioService.deletePortfolioById(portfolio.getPortfolioId());
    }


}
