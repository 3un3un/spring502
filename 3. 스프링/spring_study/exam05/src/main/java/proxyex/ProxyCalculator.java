package proxyex;

import java.lang.reflect.Proxy;

public class ProxyCalculator implements Calculator{

    // 다형성을 위하여 다음과 같이 작성 (두 계산기 모두 사용 가능하도록)
    private Calculator calculator;

    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public long factorial(long num) {
        long stime = System.nanoTime(); // 공통 기능
        try {
            long result = calculator.factorial(10L); // 핵심 기능을 대신 수행

            return result;
        } finally {
            long etime = System.nanoTime(); // 공통 기능
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}
