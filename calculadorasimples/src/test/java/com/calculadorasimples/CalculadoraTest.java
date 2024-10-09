package com.calculadorasimples;

import com.calculadorasimples.model.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    void testSomar() {
        assertEquals(5, calculadora.somar(2, 3));
        assertEquals(-2, calculadora.somar(6, -8));
        assertEquals(8.75, calculadora.somar(8, 0.75));
    }

    @Test
    void testSubtrair() {
        assertEquals(-1, calculadora.subtrair(2, 3));
        assertEquals(14, calculadora.subtrair(6, -8));
        assertEquals(7.25, calculadora.subtrair(8, 0.75));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
        assertEquals(-48, calculadora.multiplicar(6, -8));
        assertEquals(6, calculadora.multiplicar(8, 0.75));
    }

    @Test
    void testDividir() {
        assertEquals(0.6666666666666666, calculadora.dividir(2, 3));
        assertEquals(10.666666666666666, calculadora.dividir(8, 0.75));
        assertEquals(2, calculadora.dividir(10, 5));
    }

    @Test
    void testDividirPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(5, 0));
    }
}
