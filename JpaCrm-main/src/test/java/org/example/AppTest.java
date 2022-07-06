package org.example;

import org.example.dao.CustomerDAO;
import org.example.entity.Customer;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest 
{

    @Test
    public void createCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");

        CustomerDAO.create(customer);

        assertTrue(true);
    }

    @Test
    public void findById(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        CustomerDAO.create(customer);

        Customer customer1 = CustomerDAO.findById(1L);
        assertEquals("Alain",customer1.getFirstName());
    }

    @Test
    public void dontFindById(){
       Customer customer = CustomerDAO.findById(5);
       assertNull(customer);
    }

    @Test
    public void findAll(){
    CustomerDAO.create(new Customer("Toto"));
    CustomerDAO.create(new Customer("Mimi"));
    CustomerDAO.create(new Customer("Lola"));

        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(3, customers.size());

    }

    @Test
    public void deleteCustomer(){
        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);
        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(1, customers.size());

        CustomerDAO.delete(marie);
        List<Customer> customers2 = CustomerDAO.findAll();
        assertEquals(0, customers2.size());


    }
}
