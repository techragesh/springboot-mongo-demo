package com.techragesh.sprinbootmongodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

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
                .apis(RequestHandlerSelectors.any()).build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());

    }
}