package org.example.categoriasCliente;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DiamanteTest {

    private static Diamante diamante;

    @BeforeAll
    public static void init() {
        diamante = new Diamante();
    }

    @Test
    @DisplayName("Para precoBase igual a 100, o preco final deve ser 80")
    void test01() {
        var precoBase = 100;
        var output = diamante.calcularPrecoFinal(precoBase);
        assertEquals(80, output, 0.0001);
    }

    @Test
    @DisplayName("Para precoBase igual a 100.50, o preco final deve ser 80.4")
    void test02() {
        var precoBase = 100.50;
        var output = diamante.calcularPrecoFinal(precoBase);
        assertEquals(80.4, output, 0.0001);
    }

    @Test
    @DisplayName("Para pontoBase igual a 10, o pontuação final deve ser 25")
    void test03() {
        var pontoBase = 10;
        var output = diamante.calcularPontuacao(pontoBase);
        assertEquals(25, output);
    }

    @Test
    @DisplayName("Para pontoBase igual a 5, o pontuação final deve ser 12")
    void test04() {
        var pontoBase = 5;
        var output = diamante.calcularPontuacao(pontoBase);
        assertEquals(12, output);
    }

    @Test
    @DisplayName("Para precoBase menor ou igual a zero, o preço final deve ser 0")
    void test05() {
        var precoBase = -1;
        var output = diamante.calcularPrecoFinal(precoBase);
        assertEquals(0, output);
    }

    @Test
    @DisplayName("Para pontoBase menor ou igual a zero, o pontuação final deve ser 0")
    void test06() {
        var pontoBase = -1;
        var output = diamante.calcularPontuacao(pontoBase);
        assertEquals(0, output);
    }

    @Test
    @DisplayName("Para a categoria diamante criada, toString não deve retornar null")
    void test07() {
        var output = diamante.toString();
        assertNotNull(output);
    }

}
