package br.edu.exemplo.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	// lógica do programa 
    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException(
                "Não é possível dividir por zero."
            );
        }
        return a / b;
    }

    public double calcular(double a, double b,
                           String operacao) {

        return switch (operacao) {
            case "somar" -> somar(a, b);
            case "subtrair" -> subtrair(a, b);
            case "multiplicar" -> multiplicar(a, b);
            case "dividir" -> dividir(a, b);
            default -> throw new IllegalArgumentException(
                "Operação inválida."
            );
        };
    }
}
