package exam03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        // 해결 방법 2. 1번의 번거로움 -> Scanner 쓰기
        Scanner sc = new Scanner(System.in);
        System.out.print("아무거나 입력 : ");
        String str = sc.nextLine();
        System.out.println(str);

    }
}
