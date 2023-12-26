package exam03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex05 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("data.dat");
             DataInputStream dis = new DataInputStream(fis)) {

            // 순서 중요
            boolean result = dis.readBoolean();
            int num = dis.readInt();
            String str = dis.readUTF();

            System.out.printf("result=%s, num=%d str=%s%n", result, num, str);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
