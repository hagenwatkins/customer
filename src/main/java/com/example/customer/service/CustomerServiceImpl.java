package com.example.customer.service;

import com.example.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO customer (customer, customer_id_seq) VALUES (?,?)";

    @Transactional
    @Override
    public void add(Customer customer) {
        jdbcTemplate.update(INSERT_SQL, customer.getCustomer(), customer.getCustomer_id_seq());

    }

    private final String SELECT_BY_ID_SQL = "SELECT * FROM customer WHERE customer_id_seq = ?";

    @Override
    public Customer getById(int customer_id_seq) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new CustomerMapper(), customer_id_seq);

    }

    private final String SELECT_SQL = "SELECT * FROM customer";

    @Override
    public List<Customer> get() {
        return jdbcTemplate.query(SELECT_SQL, new CustomerMapper());
    }


    private final String UPDATE_SQL = "UPDATE customer SET customer=?, customer_id_seq=?";

    @Transactional
    @Override
    public void update(Customer customer) {
        jdbcTemplate.update(UPDATE_SQL, customer.getCustomer(), customer.getCustomer_id_seq());
    }


    private final String DELETE_SQL = "DELETE FROM customer WHERE customer_id_seq=?";

    @Transactional
    @Override
    public void delete(int customer_id_seq) {
        jdbcTemplate.update(DELETE_SQL, customer_id_seq);
    }

    @Transactional
    @Override
    public void delete(List<Integer> ids) {

    }

    private static class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomer_id_seq(rs.getInt("id"));
            customer.setCustomer(rs.getString("customer"));

            return customer;


        }
    }
}
