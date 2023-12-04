package config;

import models.Greeter;
import org.springframework.context.annotation.Bean;

public class AppCtx {

    @Bean
    public Greeter greeter() {
        return new Greeter();
    }
}
