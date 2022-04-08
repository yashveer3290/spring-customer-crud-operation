package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer, Integer id) {
        Customer customer1 = customerRepository.getById(id);
        customer1.setEmail(customer.getEmail());
        return  customerRepository.save(customer1);
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findId(Integer id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer= null;
        if(optional.isPresent()){
            customer = optional.get();
        }
        else {
            throw new RuntimeException("customer is not available for this id" + id);
        }
        return customer;
    }


    @Override
    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }
}
