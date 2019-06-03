package com.techragesh.sprinbootmongodemo.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER= "Authorization";


    ApiInfo apiInfo() {
        return new ApiInfo(
                "Book Rest Operation API in Spring boot",
                "Rest API for Spring Boot MongoDB demo.",
                "1.0",
                "Terms of service",
                new Contact("techragesh", "www.techragesh.com", "info@techragesh.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    @Bean
    public Docket configureControllerPackageAndConvertors() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.any()).build()
                .securitySchemes(Lists.newArrayList(apiKey()))
                .apiInfo(apiInfo());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }
}