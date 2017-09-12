package com.example.customer.model;

public class Customer {
    public String customer;
    public Integer customer_id_seq;

    public Customer() {
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getCustomer_id_seq() {
        return customer_id_seq;
    }

    public void setCustomer_id_seq(Integer customer_id_seq) {
        this.customer_id_seq = customer_id_seq;
    }
}
