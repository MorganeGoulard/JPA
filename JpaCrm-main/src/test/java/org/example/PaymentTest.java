package org.example;

import org.example.dao.PaymentDao;
import org.example.entity.Payment;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaymentTest {

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
