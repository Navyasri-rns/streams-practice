package com.example.Streams.Map_FlatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EkartDb {

    public static List<Customer> getAll(){
        return Stream.of(
                new Customer(101, "Navya", "navya@gmail.com", Arrays.asList("35466789", "12340987")),
                new Customer(102, "Anusha", "anu@gmail.com", Arrays.asList("987612234","87654312")),
                new Customer(103, "Arjun", "arjun@gmail.com", Arrays.asList("987654","1324567"))
        ).toList();
    }


}
