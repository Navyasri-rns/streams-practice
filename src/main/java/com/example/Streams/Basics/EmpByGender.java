package com.example.Streams.Basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EmpByGender {

    private String name;
    private String gender;
    private double salary;

    public static void main(String args[]){
        List<EmpByGender> empByGenderList = Arrays.asList(
                new EmpByGender("Navya", "Female", 32000),
                new EmpByGender("Anusha", "Female", 25000),
                new EmpByGender("Arjun", "Male", 42000)
        );

        //Get the Total Salary of Employees by Gender
        Map<String, Double> empList = empByGenderList.stream().collect(Collectors.groupingBy(e -> e.gender, Collectors.summingDouble(e -> e.salary)));
        System.out.print("Total Salary of Employees by Gender: " + empList);
    }
}
