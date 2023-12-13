package exam01;

import java.util.Arrays;
import java.util.Collections;

public class Ex06 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Arrays.setAll(nums, x -> x * x);
        System.out.println(Arrays.toString(nums));
    }
}
