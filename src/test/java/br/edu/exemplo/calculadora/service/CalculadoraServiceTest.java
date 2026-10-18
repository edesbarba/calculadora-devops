package br.edu.exemplo.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraServiceTest {

    private final CalculadoraService calculadora =
        new CalculadoraService();

    @Test
    @DisplayName("UT01 - Somar dois números")
    void deveSomarDoisNumeros() {
        assertEquals(15.0, calculadora.somar(10, 5));
    }

    @Test
    @DisplayName("UT02 - Subtrair dois números")
    void deveSubtrairDoisNumeros() {
        assertEquals(5.0, calculadora.subtrair(10, 5));
    }

    @Test
    @DisplayName("UT03 - Multiplicar dois números")
    void deveMultiplicarDoisNumeros() {
        assertEquals(50.0, calculadora.multiplicar(10, 5));
    }

    @Test
    @DisplayName("UT04 - Dividir dois números")
    void deveDividirDoisNumeros() {
        assertEquals(2.0, calculadora.dividir(10, 5));
    }

    @Test
    @DisplayName("UT05 - Rejeitar divisão por zero")
    void deveRejeitarDivisaoPorZero() {

        IllegalArgumentException erro = assertThrows(
            IllegalArgumentException.class,
            () -> calculadora.dividir(10, 0)
        );

        assertEquals(
            "Não é possível dividir por zero.",
            erro.getMessage()
        );
    }

    @Test
    @DisplayName("UT06 - Rejeitar operação inválida")
    void deveRejeitarOperacaoInvalida() {

        assertThrows(
            IllegalArgumentException.class,
            () -> calculadora.calcular(10, 5, "potencia")
        );
    }
}
