package com.senai.josemauro.csi_apiemprestimolivrobibliotecan2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}",
                version = "${info.build.version}",
                description = "${info.app.description}",
                contact = @io.swagger.v3.oas.annotations.info.Contact(name = "José Mauro", email = "josemaurosilva600@gmail.com")))
@SpringBootApplication
public class N2Application {

    public static void main(String[] args) {
        SpringApplication.run(N2Application.class, args);
    }

}
