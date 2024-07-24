package com.ori.chores.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI defineOpenAPI(@Value("springdoc-openapi-ui") String serviceTitle, @Value("1.6.12") String serviceVersion){
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("api for helping non-single men");

        Contact myContact = new Contact();
        myContact.setName("Ori");
        myContact.setEmail("ori2864@gmail.com");

        Info info = new Info()
                .title("Chores Management System API")
                .version("1.0")
                .description("This API exposes endpoints to chores")
                .contact(myContact);

        final String securitySchemeName = "bearerAuth";

        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes(
                                securitySchemeName,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )

//                .security(List.of(new SecurityRequirement().addList(securitySchemeName)))
                .info(info.version(serviceVersion)).servers(List.of(server));

    }
}
