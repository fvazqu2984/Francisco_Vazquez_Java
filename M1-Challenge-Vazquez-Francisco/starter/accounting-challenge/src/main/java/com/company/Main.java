package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //Update this

        List<Customer> customersList = new ArrayList<>();

        //for loop to traverse all customer data
        for(int i = 0; i < customerData.size(); i++){
            String[] customer = customerData.get(i);
            int customerID = Integer.parseInt(customer[0]);
            String customerName = customer[1];
            int customerCharge = Integer.parseInt(customer[2]);
            String chargeDate = customer[3];

            //for loop to check and traverse new customer list and find existing objects
            boolean customerExists = false;
            for (int j = 0; j < customersList.size(); j++) {
                Customer customers = customersList.get(j);
                //if customer exists
                if (customers.getId() == customerID) {
                    //add account records to existing customer
                    AccountRecord record = new AccountRecord();
                    record.setCharge(customerCharge);
                    record.setChargeDate(chargeDate);
                    customers.getCharges().add(record);

                    customerExists = true;
                    break;
                }
            }

            //if customer doesn't exist
            if (!customerExists) {
                //create new customer and account record
                Customer newCustomer = new Customer();
                newCustomer.setName(customerName);
                newCustomer.setId(customerID);
                customersList.add(newCustomer);

                AccountRecord record = new AccountRecord();
                record.setCharge(customerCharge);
                record.setChargeDate(chargeDate);
                newCustomer.getCharges().add(record);

            }

        }

        //Prints all the customers in the updated list
        for (Customer customer : customersList) {
            System.out.println(customer.toString());
        }

        System.out.println(" ");

        //Stream to collect positive account in list
        List<Customer> positiveAccounts = customersList.stream()
                .filter(customer -> customer.getBalance() > 0)
                .collect(Collectors.toList());

        System.out.println("Positive Accounts:");
        for (Customer customer : positiveAccounts) {
            System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName() + ", Balance: " + customer.getBalance());
        }

        //Stream to collect negative account in list
        List<Customer> negativeAccounts = customersList.stream()
                .filter(customer -> customer.getBalance() < 0)
                .collect(Collectors.toList());

        System.out.println("Negative Accounts:");
        for (Customer customer : negativeAccounts) {
            System.out.println("Customer ID: " + customer.getId() + ", Name: " + customer.getName() + ", Balance: " + customer.getBalance());
        }

    }

}

