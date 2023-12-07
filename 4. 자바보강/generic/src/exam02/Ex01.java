package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(); // 객체가 만들어지는 시점에 <Apple>이 된다.
        appleBox.setItem(new Apple());

        //Apple apple = appleBox.getItem();

        Box<Pear> pearBox = new Box<>();
    }
}
