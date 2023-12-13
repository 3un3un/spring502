package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 1.
        Calculator cal = new Calculator() {
            @Override
            public int square(int num) {
                return num * num;
            }
        };
        int[] nums2 = calc(nums, cal);

        // 2.
        int[] nums3 = calc(nums, new Calculator() {
            @Override
            public int square(int num) {
                return num*2;
            }
        });

        // 3. 람다
        //Calculator cal2 = x -> x*x;
        int[] nums4 = calc(nums, x -> x*x);

        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("nums3 = " + Arrays.toString(nums3));
        System.out.println("nums4 = " + Arrays.toString(nums4));



    }
    public static int[] calc(int[] nums, Calculator cal){
        int[] nums2 = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            nums2[i] = cal.square(nums[i]);
        }
        return nums2;
    }
}
