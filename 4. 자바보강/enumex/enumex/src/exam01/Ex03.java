package exam01;

public class Ex03 {
    public static void main(String[] args) {
        System.out.println(Transportation.BUS instanceof Transportation);

        //Transportation trans = new Transportation(); // 상수-> 유일하게 하나만 존재해야 가치가 있음
        int totalFare = Transportation.BUS.getTotal(10);
        System.out.println(totalFare);
    }


}
