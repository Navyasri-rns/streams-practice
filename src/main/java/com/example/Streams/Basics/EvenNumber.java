package com.example.Streams.Basics;

import lombok.Getter;
import lombok.Setter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class EvenNumber {
    public static void main(String[] args){
        //Filter even numbers from a list
        List<Integer> num = Arrays.asList(1,2,3,4,6,7);
        num.stream().filter(n -> n%2==0)
                .forEach(System.out::println);

        List<Integer> mm = num.stream().filter(n->n%2==0).toList();
        System.out.println("Even numbers: " + mm);

        //Convert list of strings to uppercase
        List<String> names = Arrays.asList("navya", "anusha", "bob");
        names.stream().map(n -> n.toUpperCase()).forEach(System.out::println);

        //squares of numbers
        List<Integer> numbrs = Arrays.asList(1,2,3,4,6,7);
        List<Integer> square = numbrs.stream().map(n -> n*n).toList();
        System.out.println("squares of numbers: " +  square);

        //Find the first element starting with "A"
        Optional<String> nam = names.stream().filter(n -> n.startsWith("a")).findFirst();
        if (nam.isPresent()) {
            System.out.println("First element starting with A: " + nam.get());
        } else {
            System.out.println("No element starting with A found");
        }

        //Count how many strings have length > 3
        //names.stream().filter(n ->n.length()>3).forEach(System.out::println);
        List<String> namesLen = names.stream().filter(n ->n.length()>3)
                .toList();
        System.out.println("names have length > 3: " + namesLen);

        //Sort a list of integers in descending order
        List<Integer> nums = Arrays.asList(1,2,2,8,3,4,4,6,7);
        List<Integer> sorted = nums.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sorted numbers: " +  sorted);

        //Find the max value from a list
        Optional<Integer> i = nums.stream().max(Integer::compareTo);
        System.out.println("max value: " + i);
        int numm = nums.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max number: " + numm);

        //Remove duplicate elements
        List<Integer> dup = nums.stream().distinct().toList();
        System.out.println("removed duplicate elements: "+ dup);

        //Join strings with comma
        String namesJoin = names.stream().collect(Collectors.joining(","));
        System.out.println("names joined: "+ namesJoin);

        //Sum of all numbers in the list
        int n = nums.stream().reduce(0,(a,b)-> a+b);
        System.out.println("Sum of all numbers using reduce: " + n);

        int n1 = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of all numbers using sum: " +  n1);
        int n3 = nums.stream().mapToInt(n33->n33).sum();
        System.out.println("Sum of all numbers using summ: " +  n3);

        int[] sum = {0};
        nums.forEach(z -> sum[0] += z);
        System.out.println("Sum of all numbers using forEach: "+ sum[0]);

        //Group strings by their length
        List<String> words = Arrays.asList("hi", "hello", "world", "java", "go");
        Map<Integer, List<String>> wordsLen = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("words by their length: "+ wordsLen);

        //Find duplicate elements
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 3, 5);
        Set<Integer> duplicate = list.stream().filter(s -> Collections.frequency(list, s) > 1).collect(Collectors.toSet());
        System.out.println("duplicate elements: " + duplicate);

        Set<Integer> duplicates = new HashSet<>();
        List<Integer> dupNums = list.stream().filter(nu -> !duplicates.add(nu)).distinct().toList();
        System.out.println("efficent way for duplicate elements: " + dupNums);

        for (Integer dupp : list){
            if (Collections.frequency(list, dupp) > 1){
                duplicates.add(dupp);
            }
        }
        System.out.println("duplicate elements using Collections.freq: " + duplicates);

        List<Integer> dupNum = list.stream().filter(du -> Collections.frequency(list, du)>1).distinct().toList();
        System.out.println("duplicate elements using list: " + dupNum);

        //Partition numbers into even and odd
        Map<Boolean, List<Integer>> numbers = nums.stream().
                collect(Collectors.partitioningBy(m -> m%2 == 0));
        System.out.println("Even Numbers: " + numbers.get(true));
        System.out.println("Odd Numbers: " + numbers.get(false));

        //Get average age of people
        List<AgeBased> people = Arrays.asList(new AgeBased("Tom", 20), new AgeBased("Jerry", 30));
        double age = people.stream().mapToInt(p -> p.getAge()).average().orElse(0.0);
        System.out.println("average age of people: "+ age);

        double ages = people.stream().mapToInt(AgeBased::getAge).average().orElse(0.0);
        System.out.println("avg age of people: " + ages);

        //Create a map from list of persons using name as key
        List<AgeBased> peoples = Arrays.asList(new AgeBased("Tom", 20), new AgeBased("Jerry", 30));
        Map<String, AgeBased> ppl = peoples.stream()
                .collect(Collectors.toMap(p -> p.getName(), p -> p));
        System.out.println("List of persons using name as key: "+ ppl);

        //start and end with vowel
        String s = "i love india";
        List<String> namee = Arrays.stream(s.split(" "))
                .filter(w -> w.matches("(?i)^[aeiou]([a-z]*[aeiou])?$"))
                .toList();
        System.out.println("split: " + namee);

    }

}
