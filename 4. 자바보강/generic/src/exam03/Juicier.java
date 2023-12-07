package exam03;

public class Juicier {
    // 컴파일할 때 <> <- 안에 값을 제거해버려서 오류가 발생한다.
    public static void make(FruitBox<Apple> appleBox){
    }
    public static void make(FruitBox<Pear> pearBox){
    }
}
