package exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex05 {
    public static void main(String[] args) {
        byte[] buffer = new byte[5];

        try(FileInputStream fis = new FileInputStream("test2.txt")) {
            while (fis.available() > 0) {
                int ch = fis.read(buffer); // 5byte씩 읽어오기
                System.out.println(ch);
                for(int i=0; i<ch; i++) {
                    System.out.print((char)buffer[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
