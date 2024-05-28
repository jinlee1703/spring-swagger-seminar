package com.example.swaggersemniar.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
		info = @Info(title = "Test App",
				description = "TestApp API 명세",
				version = "v1")
)
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi OpenApi() {
		String[] paths = {"/**"};

		return GroupedOpenApi.builder()
				.group("TestApp API v1")
				.pathsToMatch(paths)
				.build();
	}
}
