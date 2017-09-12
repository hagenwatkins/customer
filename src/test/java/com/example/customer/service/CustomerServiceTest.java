package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() {

        String customer = Long.toString(System.currentTimeMillis());
        Integer customer_id_seq = (int) System.currentTimeMillis();

        Customer customer1 = new Customer();
        customer1.setCustomer(customer);
        customer1.setCustomer_id_seq(customer_id_seq);
        customerService.add(customer1);

        List<Customer> customers = customerService.get();

        //Customer customer2 = findInList(customers, customer);
        //Assert.assertNotNull(customer2);

        Customer customer3 = customerService.getById(customer1.getCustomer_id_seq());
        Assert.assertNotNull(customer3);
        Assert.assertEquals(customer, customer3.getCustomer());
        //Assert.assertEquals(customer_id_seq, customer3.getCustomer_id_seq());
    }

    private Customer findInList(List<Customer> customers, String customer) {
    return null ;
    }
}

