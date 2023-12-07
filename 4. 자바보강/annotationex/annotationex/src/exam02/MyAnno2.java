package exam02;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno2 {
    String value() default "기본값"; // value에 값 설정 안하면 default 값 출력
    int[] nums();

}
