package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer save (Customer customer);

    Customer update(Customer customer,Integer id);

    List<Customer> findAll();

    Customer findId(Integer id);

    void delete(Integer id);

}
