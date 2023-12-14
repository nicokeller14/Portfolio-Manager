package com.example.bookexample.presentation;

import com.example.bookexample.model.*;
import com.example.bookexample.service.BookService;
import com.example.bookexample.service.InvestorService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;
import java.util.List;

@SpringComponent
public class InvestorCrudListener implements CrudListener {

    private final InvestorService investorService;
    public InvestorCrudListener(InvestorService investorService) {
        this.investorService = investorService;
    }

    @Override
    public Collection findAll() {
        List<Investor> investors = investorService.findAllInvestors();
        return investors;
    }

    @Override
    public Object add(Object o) {
        Investor i = (Investor) o;
        investorService.addInvestor(i);
        return i;
    }

    @Override
    public Object update(Object o) {
        Investor i = (Investor) o;
        InvestorService.updateInvestor(i);
        return i;
    }

    @Override
    public void delete(Object o) {
        Investor i = (Investor)o;
        InvestorService.deleteInvestorById(i.getInvestorId());
    }
}
