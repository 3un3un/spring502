package main;

import config.AppCtx;
import config.AppCtx2;
import models.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {

        // 객체 생성, 의존 설정, 초기화(afterPropertiesSet)
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx2.class);
        //getBean() 하기 전에도 객체를 만들기 때문에 출력 o
        //getBean()은 이미 만들어진 객체를 가져오는 것임

        Message m1 = ctx.getBean(Message.class);
        Message m2 = ctx.getBean(Message.class);
        System.out.println(m1 == m2);

        ctx.close(); // 컨테이너 소멸 -> 이 전에 destroy() 호출

    }
}
