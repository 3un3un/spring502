package exam04;

public class Ex01 {
    public static void main(String[] args) {
       //Book b1 = new Book();
        Book b1 = Book.builder()
                .title("제목1")
                .author("저자1")
                .publisher("출판사")
                .build();

        System.out.println(b1);
    }

}
