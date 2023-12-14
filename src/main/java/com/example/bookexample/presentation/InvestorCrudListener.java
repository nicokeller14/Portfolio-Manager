package com.example.bookexample.presentation;

import com.example.bookexample.model.Investor;
import com.example.bookexample.service.InvestorService;
import org.vaadin.crudui.crud.CrudListener;
import java.util.Collection;
import java.util.List;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class InvestorCrudListener implements CrudListener<Investor> {

    private final InvestorService investorService;

    public InvestorCrudListener(InvestorService investorService) {
        this.investorService = investorService;
    }

    @Override
    public Collection<Investor> findAll() {
        return investorService.findAllInvestors();
    }

    @Override
    public Investor add(Investor investor) {
        investorService.addInvestor(investor);
        return investor;
    }

    @Override
    public Investor update(Investor investor) {
        investorService.updateInvestor(investor);
        return investor;
    }

    @Override
    public void delete(Investor investor) {
        investorService.deleteInvestorById(investor.getInvestorId());
    }
}
