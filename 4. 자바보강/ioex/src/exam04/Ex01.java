package exam04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Ex01 {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>(); // 여러 개 쓸 때 Map 이용해서 한꺼번에 write 하기

        try (FileOutputStream fos = new FileOutputStream("book.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Book b1 = new Book("book1", "author1", "publisher1");
            Book b2 = new Book("book2", "author2", "publisher2");

/*            oos.writeObject(b1);
            oos.writeObject(b2);
            oos.writeObject("안녕하세요.");*/
            data.put("book1", b1);
            data.put("book2", b2);
            data.put("str" ,"안녕하세요.");

            oos.writeObject(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
