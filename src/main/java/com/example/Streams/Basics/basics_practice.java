package com.example.Streams.Basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class basics_practice {

    public static void main(String args[]) {
        System.out.println("Hello");

        //1)Sum of 2 numbers

        int a = 10, b = 20;
        System.out.println(a+b);
        System.out.println("Sum of 2 nums: " +  (a+b));
        int c = a+b;
        System.out.println("Sum using 3rd variable: " + c);

        //sum using Streams
        int sum = Stream.of(a, b).reduce(0, (x,y) -> (x + y));
        System.out.println("Sum using Streams: " + sum);

        List<Integer> nums = Arrays.asList(20,30);
        int i = nums.stream().mapToInt(n -> n).sum();
        System.out.println("Sum using mapToInt: " + i);

        //2) Find Maximum number
        int aa = 29, bb = 39;
        if (aa>=bb) {
            System.out.println("Max num: " + aa);
        } else {
            System.out.println("Max num: " + bb);
        }

        int[] arr = {aa,bb};
        int max1 = Math.max(arr[0], arr[1]);
        System.out.println("Max using arrays: " + max1);

        List<Integer> sumq = Arrays.asList(aa, bb);
        int max2 = Collections.max(sumq);
        System.out.println("Max using Collections: " + max2);

        int max3 = Stream.of(aa,bb).max(Comparator.naturalOrder()).get();
        System.out.println("Max using Streams: " +  max3);

        int max4 = Integer.MIN_VALUE;
        for (int n: sumq){
            if(n>max4){
                max4 = n;
            }
        }
        System.out.println("Max using for each: " +  max4);


        //3)Even or odd
        
    }
}
