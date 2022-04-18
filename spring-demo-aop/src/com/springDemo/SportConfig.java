package com.springDemo;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("com.springDemo")

@PropertySource(value = "classpath:/application.yaml", encoding="UTF-8")

public class SportConfig {
    //    define bean for our SadFortune
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    //    define bean for our SwimCotch and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
