package com.edanrh.ApiVizyon.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
    
    @Bean
    GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
               .group("Apiong")
               .pathsToMatch("/**")
               .build();
    }

    @Bean
    OpenAPI customOpenAPI(){
        return new OpenAPI()
               .info(new Info().title("apiTest").version("1.0.0"))
               .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
               .components(new Components()
                            .addSecuritySchemes("bearerAuth", new SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")))
               .externalDocs(new ExternalDocumentation().url("https://github.com/edanrh/Api-ong"));
    }
}
