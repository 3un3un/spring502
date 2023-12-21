package exam01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("test2.txt")) {
            for(char ch='A'; ch <= 'Z'; ch++){
                fos.write(ch); // ch -> int 자동 형변환
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
