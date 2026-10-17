package br.edu.exemplo.calculadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Inicia a aplicacao web e o servidor incorporado. */
@SpringBootApplication
public class CalculadoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraApplication.class, args);
    }
}
