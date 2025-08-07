package com.example.Streams;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Practice {

    String name;
    int price;

    public static void main(String args[]){
         List<Practice> p = Arrays.asList(
                 new Practice("Navya", 500),
                 new Practice("Anu", 1100),
                 new Practice("Nav", 1001),
                 new Practice("Arjun", 900)
         );

         //List<Practice> filteredPrice = p.stream().filter(n -> n.price>1000).sorted(Comparator.reverseOrder()).toList();
    }
}
