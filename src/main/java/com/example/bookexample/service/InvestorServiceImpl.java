package com.example.bookexample.service;
import com.example.bookexample.model.Investor;
import com.example.bookexample.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service("InvestorService")
public class InvestorServiceImpl implements InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    ArrayList<Investor> investorList = new ArrayList<>();
    @Override
    public List<Investor> findAllInvestors() {
        ArrayList<Investor> investorRepo = (ArrayList<Investor>) investorRepository.findAll();
        if (investorRepo.isEmpty())
            return investorList;
        else
            return investorRepo;
    }

    @Override
    public Investor findInvestorById(long id) {

        return findInvestorById(id);
    }

    @Override
    public Investor findInvestorByEmail(String email) {

        return investorRepository.findByEmail(email);
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
    public void deleteInvestor(Investor i) {
        Investor deleteInvestor = null;
        for (Investor investor : investorList) {
            if (i.getInvestorId() == investor.getInvestorId()) {
                deleteInvestor = i;
            }
        }

        if (deleteInvestor != null) {
            investorList.remove(deleteInvestor);
            investorRepository.delete(deleteInvestor);

        }
    }

    @Override
    public void deleteInvestorById(long id) {
        Investor deleteInvestor = null;
        for (Investor investor : investorList) {
            if (id == investor.getInvestorId()) {
                deleteInvestor = investor;
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
                investor.setEmail(i.getEmail());
                investor.setCity(i.getCity());
                investor.setCountry(i.getCountry());
                investor.setTimeZone(i.getTimeZone());
                investorRepository.save(investor);
            }
        }
    }
}
