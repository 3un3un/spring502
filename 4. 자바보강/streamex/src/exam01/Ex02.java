package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        String[] words1 = {"aaa", "aaa", "bb", "ccc", "ccc", "abcd"};
        Arrays.stream(words1)
                .distinct() // 중간 연산
                .filter(s->s.length() >= 3) // 중간 연산
                .forEach(System.out::println); // 최종 연산

/*
        List<String> words2 = Arrays.asList("aaa", "aaa", "bb", "ccc", "ccc", "abcd");
        words2.stream().distinct().filter(s -> s.length() >= 3)
                .forEach(System.out::println);

        System.out.println(words2);*/


    }
}
