package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        System.out.print("아무거나 입력 : ");
        // 입력을 받을 때까지 다음 코드 실행 x 상황을 블로킹이라고 한다.
//        char ch = (char) System.in.read(); // 한글 -> 깨짐

        // 해결 방법 1. InputStreamReader(변환) + BufferedReader(효율)
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        char ch = (char) br.read();


        System.out.println("ch = " + ch);
    }
}
