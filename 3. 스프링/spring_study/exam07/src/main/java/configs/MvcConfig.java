package configs;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        // 모든 요청 : 컨트롤러 빈이 한다. 없는 경우 : 정적 자원 경로(css, js, 이미지)

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");

        //true : 최초 로딩시 번역, 다음 요청시에는 기존 파일을 그대로 사용 (실 사용중 서버)
        //false : 매번 요청시마다 다시 번역 (개발 중)
        templateResolver.setCacheable(false);

        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true); //EL식 사용 가능

        //확장 기능
        // Date Time API (java.time 패키지) - #temporals
        templateEngine.addDialect(new Java8TimeDialect());
        // 레이아웃 기능 추가
        templateEngine.addDialect(new LayoutDialect());

        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        // <%@ page contentType="text/html; charset=UTF-8" %> 미리 세팅하기
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8");
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/templates/", ".jsp");
//    }

}
