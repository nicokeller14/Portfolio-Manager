package com.example.bookexample.repository;

import com.example.bookexample.model.Investor;
import org.springframework.data.repository.CrudRepository;

public interface InvestorRepository extends CrudRepository<Investor, Long> {
    Investor findByName(String name);
    Investor findById(long id);

}
