package com.example.customer.repository;

import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Customer customer) {

    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public List<Customer> get() {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(List<Integer> ids) {

    }
}
