package com.example.Streams.Map_FlatMap;

import java.util.List;

public class MapVsFlatMap {

    public static void main(String args[]) {
        List<Customer> customers = EkartDb.getAll();

        // map -> one-to-one mapping
        List<String> emails = customers.stream().map( Customer::getEmail).toList();
        System.out.println("list of emails: " + emails);

        //customer -> customer.getPhoneNumbers - one-to-many mapping
        List<List<String>> phnNums = customers.stream().map(Customer::getPhoneNumbers).toList();
        System.out.println("list of phn nums using map: " + phnNums);

        //customer -> customer.getPhoneNumbers.stream - one-to-many mapping
        List<String> phnNo = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).toList();
        System.out.println("List of phn no's using flatMap: " + phnNo);
    }



}
