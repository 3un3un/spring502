package exam03;

import exam02.Fruit;

public class Ex01 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());


        Juicier.make(appleBox);

        FruitBox<Object> pearBox = new FruitBox<>();
        pearBox.add(new Pear());
        pearBox.add(new Pear());

        Juicier.make(pearBox);
    }
}
