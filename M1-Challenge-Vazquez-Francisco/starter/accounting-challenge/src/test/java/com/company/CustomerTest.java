package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    Customer customer;
    Customer customer2;

    @BeforeEach
    public void setUp(){
        customer = new Customer();
        customer.setId(1);
        customer.setName("Francisco Vazquez");
        AccountRecord record1 = new AccountRecord();
        record1.setCharge(100);
        record1.setChargeDate("2023-06-14");
        AccountRecord record2 = new AccountRecord();
        record2.setCharge(-50);
        record2.setChargeDate("2022-06-15");
        customer.getCharges().add(record1);
        customer.getCharges().add(record2);

        customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("John Cena");
        AccountRecord record3 = new AccountRecord();
        record3.setCharge(-1000);
        record3.setChargeDate("2023-06-14");
        AccountRecord record4 = new AccountRecord();
        record4.setCharge(-50);
        record4.setChargeDate("2022-06-15");
        customer2.getCharges().add(record3);
        customer2.getCharges().add(record4);
    }

    @Test
    public void shouldGetBalanceCustomer1(){

        assertEquals(50, customer.getBalance());

    }

    @Test
    public void shouldGetBalanceCustomer2(){

        assertEquals(-1050, customer2.getBalance());

    }

    @Test
    public void shouldPrintCustomer1(){
        assertEquals("Customer ID: 1, Name: Francisco Vazquez, Balance: 50", customer.toString());
    }

    @Test
    public void shouldPrintCustomer2(){
        assertEquals("Customer ID: 2, Name: John Cena, Balance: -1050", customer2.toString());
    }
}
