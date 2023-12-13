package exam05;

import java.util.Arrays;
import java.util.Comparator;

public class Ex05 {
    public static void main(String[] args) {
        Integer[] nums = {10, 3, 5, 33, 19, 25};
        //Arrays.sort(nums); //Comparable 기본 정렬 기준 - 오름차순
        Arrays.sort(nums, Comparator.reverseOrder()); // 내림차순

        System.out.println(Arrays.toString(nums));
    }
}
