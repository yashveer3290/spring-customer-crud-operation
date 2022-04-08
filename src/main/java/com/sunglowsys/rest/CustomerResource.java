package com.sunglowsys.rest;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CustomerResource {


    private static final Logger LOGGER =  LoggerFactory.getLogger(CustomerResource.class);
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public  ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer result = customerService.save(customer);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/customers")
     public List<Customer> getALl(){
        List<Customer> customers =customerService.findAll();
        return customers;
     }
     @GetMapping("/customers/{id}")
     public  Customer getBYId(@PathVariable("id") Integer id){
        return customerService.findId(id);
     }
     @PutMapping("/customers/{id}")
     public Customer update(@RequestBody Customer customer,@PathVariable("id")Integer id){
        return customerService.update(customer,id);
     }
     @DeleteMapping("/customers/{id}")
     public void delete(@PathVariable("id") Integer id){
        customerService.delete(id);
     }
}
