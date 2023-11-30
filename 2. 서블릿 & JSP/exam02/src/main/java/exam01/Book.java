package exam01;


import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE) //기본 생성자
//@AllArgsConstructor //모든 멤버 변수 초기화 생성자
//@RequiredArgsConstructor
//@EqualsAndHashCode
//@Data //@Getter @Setter @ToString @EqualsAndHashCode
public class Book {
    private String title;
    private String author;
    private String publisher;

    @Override
    public String toString() {
        return super.toString();
    }
}
