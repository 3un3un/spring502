package main;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int result = add(10, 20);
        System.out.println(result);
        int result2 = add(10, 20, 30, 40);
        System.out.println(result2);

    }

    //메서드 오버로딩
    public static int add(int ... nums) { //가변적인 매개변수
/*
        int total = 0;
        for(int num : nums) {
            total += total;
        }
        */
        int total = Arrays.stream(nums).sum();
        return  total;
    }


}
