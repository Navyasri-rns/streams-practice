package com.example.Streams.Basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OldestPeople {

    private String name;
    private int age;

    public static void main(String[] args){

        List<OldestPeople> people = Arrays.asList(
              new OldestPeople("Navya", 23),
              new OldestPeople("Anu", 21),
              new OldestPeople("Harsha", 14),
              new OldestPeople("Arjun", 26),
                new OldestPeople("Vishnu", 12)
        );

        //Get the Names of the 3 Oldest People
        List<String> names = people.stream().sorted(Comparator.comparingInt(OldestPeople::getAge).reversed()).limit(3).map(OldestPeople::getName).toList();
        System.out.println("3 Oldest people names: " + names);
    }
}
