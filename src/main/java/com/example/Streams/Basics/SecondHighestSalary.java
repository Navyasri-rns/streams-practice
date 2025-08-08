package com.example.Streams.Basics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecondHighestSalary {

    public static int findSecondHighestSalary(int[] arr){
        if(arr == null || arr.length<2){
            log.info("Array must contain at least two elements");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num : arr){
            if(num > first){
                second = first;
                first = num;
            } else if (num > second & num != first) {
                second = num;
            }
        }

        if(second == Integer.MIN_VALUE){
            log.info("No second highest salary found in the array");
        }

        return second;
    }

    public static void main(String args[]){
        int[] arr = {2,4,6,8,11,9};
        System.out.println("Second highest salary: " + findSecondHighestSalary(arr));
    }
}
