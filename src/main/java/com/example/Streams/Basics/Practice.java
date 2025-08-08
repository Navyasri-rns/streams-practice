package com.example.Streams.Basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
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

         //Filter Products Costing More Than 1000 and Sort by Price Descending
         List<Practice> filteredPrice = p.stream().filter(n -> n.price>1000).sorted(Comparator.comparingInt(Practice::getPrice).reversed()).toList();
         System.out.println("product cost more than 1000: " + filteredPrice);


        //Find All Unique Characters in a List of Words
        List<String> words = Arrays.asList("java", "streams", "code");
        List<Character> characters = words.stream().flatMap( n -> n.chars().mapToObj(c -> (char) c)).distinct().toList();
        System.out.println("unique characters: " + characters);


        //
    }
}
