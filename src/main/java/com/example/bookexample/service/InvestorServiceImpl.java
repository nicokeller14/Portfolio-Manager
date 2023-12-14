package com.example.bookexample.service;

import com.example.bookexample.model.Book;
import com.example.bookexample.model.Investor;
import com.example.bookexample.repository.BookRepository;
import com.example.bookexample.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("InvestorService")
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    ArrayList<Investor> investorList = new ArrayList<>();
    @Override
    public List<Investor> findAllInvestors() {
        Iterable<Investor> iterable = investorRepository.findAll();
        List<Investor> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Override
    public Investor findInvestorById(long investorId) {
        return investorRepository.findById(investorId);
    }


    @Override
    public void addInvestor(Investor i) {
        investorList.add(i);
        investorRepository.save(i);
    }
    @Override
    public void deleteAllInvestors() {
        investorList.clear();
        investorRepository.deleteAll();
    }

    @Override
    public void deleteInvestorById(long id) {
        Investor deleteInvestor = null;
        for (Investor i : investorList) {
            if (i.getInvestorId() == id) {
                deleteInvestor = i;
            }
        }

        if (deleteInvestor != null) {
            investorList.remove(deleteInvestor);
            investorRepository.delete(deleteInvestor);

        }
    }

    @Override
    public void updateInvestor(Investor i) {
        for (Investor investor : investorList) {
            if (investor.getInvestorId() == i.getInvestorId()) {
                investor.setFirstName(i.getFirstName());
                investor.setLastName(i.getLastName());
                investorRepository.save(investor);
            }
        }
    }
}
