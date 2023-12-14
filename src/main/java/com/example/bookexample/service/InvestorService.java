package com.example.bookexample.service;

import com.example.bookexample.model.Book;
import com.example.bookexample.model.Investor;

import java.util.ArrayList;

public interface InvestorService {
    ArrayList<Investor> findAllInvestors();
    Stock findInvestorById(long investorId);
    void addInvestor(Investor i);
    void updateInvestor (Investor i);
    void deleteInvestor(Investor i);
    void deleteInvestorById(long investorId);
    void deleteAllInvestors();
}
