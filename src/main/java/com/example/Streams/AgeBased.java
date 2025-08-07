package com.example.Streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AgeBased {
    String name;
    int age;
    public static void main(String args[]){

        List<AgeBased> a1 = Arrays.asList(
                new AgeBased("Navya", 23),
                new AgeBased("Nishu", 13),
                new AgeBased("Anu", 21)
        );

        List<String> names = a1.stream().
                filter( n -> n.getAge()>18).map(AgeBased::getName).toList();

        System.out.println("People older than 18: " + names);
    }
}
