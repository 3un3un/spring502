package exam;

public class Ex01 {
    public static void main(String[] args) {
        //생성자 함수(메소드) - 객체를 생성하는 역할 (힙 메모리에 필요한 자원을 위한 공간 할당)

        // 다형성
        C c = new C(); // C, B, A
        // 출처가 명확하기 때문에 가능
        A a = c;
        B b = c;



    }
}
