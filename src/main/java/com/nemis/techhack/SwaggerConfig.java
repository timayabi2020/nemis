package com.nemis.techhack;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Student Nemis Mock API",
        version = "1.0",
        description = "API for mimicking the student profile data from Nemis",
        contact = @Contact(name = "Support", email = "twamalwa@microsoft.com")
    ),
    servers = {
        @Server(url = "https://student-nemis-dbb3c9etf0bbgqd5.southafricanorth-01.azurewebsites.net/", description = "Local Dev Server")
    }
)
public class SwaggerConfig {
}

