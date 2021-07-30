package com.org.springrest6.springrest6.configuration;
/**
 * Swagger Configuration file
 */
import java.util.Collections;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.org.springrest6"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Payments API Service", //Title
            "The Api handles the payment services within bank,and accross Bank over IMPS and NEFT, UPI based Instruments", //Description
            "Version 1.1",//Version
            "My Terms of Service",
            new Contact("Gokul","gokuljaeger@gmail.com","gokul@contact.google.com"),
            "License of API",
            "Api Licene url",
            Collections.emptyList());
        
    }
}


