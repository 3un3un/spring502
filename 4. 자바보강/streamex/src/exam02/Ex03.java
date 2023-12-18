package exam02;

import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        //0~9
        IntStream.range(0, 10).forEach( i -> System.out.println("반복"));

        //1~100
        int total = IntStream.rangeClosed(1, 100).sum();
        System.out.println(total);
    }
}
