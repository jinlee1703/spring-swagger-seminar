package com.example.swaggersemniar.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition( //Swagger에 대한 설명
        info = @Info(title = "Swagger Seminar API 문서",
        description = "이혜원 작성",
        version = "v1")
)
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi openApi(){
        String[] paths = {"/**"}; // 어떤 경로 포함 API를 띄울 것인가.

        return GroupedOpenApi.builder()
                .group("Swagger Seminar API")
                .pathsToMatch(paths)
                .build();
    }
}
