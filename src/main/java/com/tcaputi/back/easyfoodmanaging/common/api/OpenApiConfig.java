package com.tcaputi.back.easyfoodmanaging.common.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI easyFoodManagingOpenApi() {
        return new OpenAPI().info(new Info()
                .title("EasyFoodManaging API")
                .description("Manage food stock and recipes easily!")
                .version("v1")
        );
    }

}
