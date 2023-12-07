package main;

public class Ex05 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 0;
            int result = num1 / num2; // throw new ArithmethicException();

        } catch (ArithmeticException e) { // = new ArithmethicException();
            e.printStackTrace();
            System.out.println("예외 처리....");
        }

        System.out.println("매우 중요한 실행 코드....");
        // ArithmeticException -> RuntimeException : 실행 중 체크되는 예외
        // 실행이 되려면? -> 컴파일 필요 -> 컴파일은 된다.
        // 예외처리 목적? 서비스 중단을 막기 위한 처리
        // try ~ catch
    }
}
