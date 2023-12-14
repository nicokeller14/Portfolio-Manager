package com.example.bookexample.service;

import com.example.bookexample.model.Investor;
import java.util.List;

public interface InvestorService {
    List<Investor> findAllInvestors();
    Investor findInvestorById(long investorId);
    void addInvestor(Investor investor);
    void updateInvestor(Investor investor);
    void deleteInvestorById(long investorId);
    void deleteAllInvestors();
}
