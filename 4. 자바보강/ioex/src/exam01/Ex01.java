package exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt")) {

            // .read() : 리턴 타입 int, 1바이트 읽기 char(2 or 3byte) - 양의 정수
            // 범위 int > char, 정보 유실 가능성으로 char형으로 받아야 함.
            int ch = 0;
            while ((ch = fis.read()) != -1){
                System.out.println((char)ch);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
