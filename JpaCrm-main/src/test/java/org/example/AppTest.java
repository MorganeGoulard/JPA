package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.PaymentDao;
import org.example.entity.Customer;
import org.example.entity.Payment;
import org.junit.Assert;
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

    @Test
    public void deleteCustomerById(){

        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);
        Customer lola = new Customer("Lola");
        CustomerDAO.create(lola);
        List<Customer> customers = CustomerDAO.findAll();
        assertEquals(2, customers.size());

        CustomerDAO.deleteById(marie.getId());
        List<Customer> customers2 = CustomerDAO.findAll();
        assertEquals(1, customers2.size());

    }

    @Test
    public void deleteCustomerByIdJC() { // version J-C avec assertNull et notNull
        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);
        Customer michel = new Customer("Michel");
        CustomerDAO.create(michel);
        Customer alex = new Customer("Alex");
        CustomerDAO.create(alex);

        CustomerDAO.deleteById(michel.getId());

        assertNull(CustomerDAO.findById(michel.getId()));
        assertNotNull(CustomerDAO.findById(marie.getId()));
        assertNotNull(CustomerDAO.findById(alex.getId()));
    }

    /*@Test
    public void deleteCustomerByIdV2(){

        Customer marie = new Customer("Marie");
        CustomerDAO.create(marie);
        Customer michel = new Customer("Michel");
        CustomerDAO.create(michel);
        Customer alex = new Customer("Alex");
        CustomerDAO.create(alex);

        CustomerDAO.deleteByIdV2(michel.getId());

        assertNull(CustomerDAO.findById(michel.getId()));
        assertNotNull(CustomerDAO.findById(marie.getId()));
        assertNotNull(CustomerDAO.findById(alex.getId()));
    }*/

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();
        customer.setFirstName("Alain");
        customer.setLastName("Delon");
        customer.setAddress("rue de machin");
        customer.setCity("Nantes");
        customer.setCompanyName("Google");
        customer.setCountry("France");
        customer.setEmail("alain@delon.fr");
        customer.setPhone("0606060606");
        customer.setZipCode("44000");
        customer.setState(1);
        CustomerDAO.create(customer);

        Customer newCustomerData = new Customer();
        newCustomerData.setFirstName("Jean-Paul");
        newCustomerData.setLastName("Belmondo");

        CustomerDAO.updateCustomer(customer.getId(), newCustomerData);

        Customer customerUpdated = CustomerDAO.findById(1L);
        assertEquals("Jean-Paul",customerUpdated.getFirstName());
        assertEquals("Belmondo",customerUpdated.getLastName());

    }

    @Test
    public void selectWhere(){
        Customer customer1 = new Customer();
        customer1.setFirstName("Alain");
        customer1.setLastName("Delon");
        CustomerDAO.create(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Alain");
        customer2.setLastName("Prost");
        CustomerDAO.create(customer2);

        Customer customer3 = new Customer();
        customer3.setFirstName("Albert");
        customer3.setLastName("De Monaco");
        CustomerDAO.create(customer3);

        /************/

        List<Customer> alains = CustomerDAO.findByFirstName("Alain");

        for(Customer c : alains){
            System.out.println(c);
        }
        assertEquals(2, alains.size());

        // si le prénom récup n'est pas Alain, alors test faux
        for(Customer c : alains){
            if(! c.getFirstName().equals("Alain")){
                assertTrue(false);
            }
        }


    }

    @Test
    public void createPayment(){
        Payment payment1 = new Payment();
        payment1.setCardNumber("0102030405060708");
        payment1.setConfidentialCode("1234");
        payment1.setBank("BNP Paribas");

        PaymentDao.createPayment(payment1);
        assertTrue(true);
    }

    @Test
    public void findPaymentById(){
        Payment payment1 = new Payment();
        payment1.setCardNumber("0102030405060708");
        payment1.setConfidentialCode("1234");
        payment1.setBank("BNP Paribas");

        PaymentDao.findById(1L);
        assertEquals("BNP Paribas", payment1.getBank());
    }

    @Test
    public void findAllPayments(){
        Payment payment1 = new Payment();
        payment1.setCardNumber("0000 1111 2222 3333");
        payment1.setConfidentialCode("1234");
        payment1.setBank("BNP Paribas");
        PaymentDao.createPayment(payment1);

        Payment payment2 = new Payment();
        payment2.setCardNumber("0000 2222 4444 6666");
        payment2.setConfidentialCode("0102");
        payment2.setBank("Crédit Agricole");
        PaymentDao.createPayment(payment2);

        List<Payment> payments = PaymentDao.findAll();
        assertEquals(2, payments.size());
    }

    @Test
    public void deletePayment(){
        Payment payment1 = new Payment();
        payment1.setCardNumber("0000 1111 2222 3333");
        payment1.setConfidentialCode("1234");
        payment1.setBank("BNP Paribas");
        PaymentDao.createPayment(payment1);

        Payment payment2 = new Payment();
        payment2.setCardNumber("0000 2222 4444 6666");
        payment2.setConfidentialCode("0102");
        payment2.setBank("Crédit Agricole");
        PaymentDao.createPayment(payment2);

        Payment payment3 = new Payment();
        payment3.setCardNumber("0000 2222 0000 2222");
        payment3.setConfidentialCode("0000");
        payment3.setBank("Caisse d'épargne");
        PaymentDao.createPayment(payment3);

        List<Payment> payments1 = PaymentDao.findAll();
        assertEquals(3, payments1.size());

        PaymentDao.deletePayment(payment2);
        List<Payment> payments2 = PaymentDao.findAll();
        assertEquals(2,payments2.size());

    }

    @Test
    public void deletePaymentById(){

        Payment payment1 = new Payment();
        payment1.setCardNumber("0000 1111 2222 3333");
        payment1.setConfidentialCode("1234");
        payment1.setBank("BNP Paribas");
        PaymentDao.createPayment(payment1);

        Payment payment2 = new Payment();
        payment2.setCardNumber("0000 2222 4444 6666");
        payment2.setConfidentialCode("0102");
        payment2.setBank("Crédit Agricole");
        PaymentDao.createPayment(payment2);

        Payment payment3 = new Payment();
        payment3.setCardNumber("0000 2222 0000 2222");
        payment3.setConfidentialCode("0000");
        payment3.setBank("Caisse d'épargne");
        PaymentDao.createPayment(payment3);

        PaymentDao.deletePaymentById(payment2.getId());
        List<Payment> payments = PaymentDao.findAll();
        assertEquals(2, payments.size());
        System.out.println(payments);

    }

    @Test
    public void updatePayment(){
        Payment payment = new Payment();
        payment.setCardNumber("0000 1111 2222 3333");
        payment.setConfidentialCode("1234");
        payment.setBank("BNP Paribas");
        PaymentDao.createPayment(payment);

        Payment payment2 = new Payment();
        payment2.setCardNumber("0000 2222 4444 6666");
        payment2.setConfidentialCode("0102");
        payment2.setBank("Crédit Agricole");
        PaymentDao.createPayment(payment2);

        Payment newPayment = new Payment();
        newPayment.setBank("Banque postale");
        newPayment.setConfidentialCode("4444");

        PaymentDao.updatePayment(payment.getId(), newPayment);
        assertEquals("Banque postale", payment.getBank());

    }



}


