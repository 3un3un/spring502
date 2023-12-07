package aopex;

public class RecCalculator implements Calculator {

    // 재귀방식은 스택에 계속 쌓임 -> 추천 x
    @Override
    public long factorial(long num) {
        if(num < 1L) {
            return 1L;
        }
        return num * factorial(num - 1);
    }
}
