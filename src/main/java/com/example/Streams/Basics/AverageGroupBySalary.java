package com.example.Streams.Basics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class AverageGroupBySalary {

    String name;
    String department;
    double salary;

    public static void main(String[] args){
        List<AverageGroupBySalary> members = Arrays.asList(
                new AverageGroupBySalary("Navya", "Java", 29000),
                new AverageGroupBySalary("Rachana", "Java", 35000),
                new AverageGroupBySalary("Abhinav", "Devops", 28000),
                new AverageGroupBySalary("Chaitanya", "Devops", 43000),
                new AverageGroupBySalary("Srikanth", "Hr", 49000),
                new AverageGroupBySalary("Surya", "Hr", 40000)
        );

        //average salary of department
        Map<String, Double> avgSalary = members.stream().collect(Collectors.groupingBy(
                AverageGroupBySalary::getDepartment, Collectors.averagingDouble(AverageGroupBySalary::getSalary)
        ));

        System.out.println("avg salary by dep: " + avgSalary);
        //group by dep and get the highest salary by dep
    }
}
