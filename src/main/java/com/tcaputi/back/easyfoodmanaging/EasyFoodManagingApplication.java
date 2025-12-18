package com.tcaputi.back.easyfoodmanaging;

import com.tcaputi.back.easyfoodmanaging.common.config.GracefulTaskScheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class EasyFoodManagingApplication {

    @Bean
    @Primary
    public ThreadPoolTaskScheduler taskScheduler() {
        return new GracefulTaskScheduler();
    }

    public static void main(String[] args) {
        SpringApplication.run(EasyFoodManagingApplication.class, args);
    }

}
