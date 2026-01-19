package com.example.Streams.Basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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


        //Group Strings by First Character
        List<String> names = Arrays.asList("Tom", "Tim", "Alice", "Andy");
        Map<Character, List<String>> firstChar = names.stream().collect(Collectors.groupingBy(c -> c.charAt(0)));
        System.out.println("grouping by first character: " + firstChar);

        //Create a Map of String Length → Count
        Map<Integer, Long> strLength = names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("String length: " + strLength);

        //Flatten Nested Integer List and Remove Duplicates
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5));
        List<Integer> nestedNumbrs = nested.stream().flatMap(n -> n.stream()).distinct().toList();
        System.out.println("Nested Integer List: " + nestedNumbrs);

        //Find the Most Frequent Character in a String
        String input = "mississippi";
        Map<Character, Long> mostFrq = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        Map.Entry<Character, Long> output = mostFrq.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Most Freq Char: " + output);

        char f = input.chars().mapToObj(c -> (char) c).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Most frequent character: " + f);

        //Check if a List of Words Contains a Palindrome
        List<String> wordsPalindrome = Arrays.asList("hello", "civic", "world");
        boolean isPalindrome = wordsPalindrome.stream().anyMatch(s -> new StringBuilder(s).reverse().toString().equals(s));
        if(isPalindrome){
            System.out.println(true);
        } else{
            System.out.println(false);
        }

        //Find the First Non-Repeated Character in a String
        String inp = "success";
        Character nonRepeating = inp.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("Non Repeating Character: " + nonRepeating);


        //Check String is Palindrome
        String s = "madam";
        boolean b = IntStream.range(0, s.length()/2).allMatch(i -> s.charAt(i) == s.charAt(s.length()-i-1));
        System.out.print("String is Palindrome: ");
        if(b){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        //frequency of all characters
        String n = "navyasri edharapu";
        Map<Character, Long> cnt = n.chars().mapToObj(s2->(char)s2).filter(s2->s2!=' ').collect(Collectors.groupingBy(s2->s2, Collectors.counting()));
        System.out.println(cnt);
    }
}
