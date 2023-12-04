package exam04;

import lombok.Builder;

@Builder
public class Book2 {
    private String title;
    private String author;
    private String publisher;

    @Override
    public String toString() {
        return "Book2{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

