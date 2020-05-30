package br.com.desafio.automovel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AutomovelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomovelApplication.class, args);
    }

}
