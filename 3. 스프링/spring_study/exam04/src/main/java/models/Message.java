package models;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message) {
        System.out.printf("전송 메세지 : %s%n", message);
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        // 인터페이스 InitializingBean의 추상메서드 오버라이딩
        // 초기화 단계에서 호출되고 실행
        System.out.println("afterPropertiesSet()!!!!");

    }

    @Override
    public void destroy() throws Exception {
        // 인터페이스 DisposableBean의 추상메서드 오버라이딩
        // 스프링 컨테이너에 있는 빈 소멸 전에 호출한다.
        // 자원 해제를 주로 많이 처리 (ctx.close() 있어야 호출)
        System.out.println("destroy()!!!!");

    }
}
