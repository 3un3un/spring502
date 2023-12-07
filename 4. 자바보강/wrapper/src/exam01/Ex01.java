package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //Integer num1 = Integer.valueOf(10);
       // Integer num2 = Integer.valueOf(10);
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);
        //동일한 객체를 반환하기 때문에 new 연산자 대신 valueOf 사용하는 것을 권장
        System.out.println(num1 == num2);
        System.out.println("num1 = " + System.identityHashCode(num1));
        System.out.println("num2 = " + System.identityHashCode(num2));
//        long num2 = num1.longValue();

    }
}
