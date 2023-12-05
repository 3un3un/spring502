package exam05;

public interface Calculator {
    int num = 10; // 인터페이스에 선언한 변수는 상수!! (public static final)

    //인스턴스 메서드
    int add(int num1, int num2); // (public abstract 생략)

   default int minus(int num1, int num2){ // 범위는 public이다.
        return num1 - num2;
    }


}
