package org.example.categoriasCliente;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BronzeTest {
    private static Bronze bronze;

    @BeforeAll
    public static void init() {
        bronze = new Bronze();
    }

    @Test
    @DisplayName("Para precoBase igual a 100, o preco final deve ser 95")
    void test01() {
        var precoBase = 100;
        var output = bronze.calcularPrecoFinal(precoBase);
        assertEquals(95, output, 0.0001);
    }

    @Test
    @DisplayName("Para precoBase igual a 100.50, o preco final deve ser 95,475")
    void test02() {
        var precoBase = 100.50;
        var output = bronze.calcularPrecoFinal(precoBase);
        assertEquals(95.475, output, 0.0001);
    }

    @Test
    @DisplayName("Para pontoBase igual a 10, o pontuação final deve ser 11")
    void test03() {
        var pontoBase = 10;
        var output = bronze.calcularPontuacao(pontoBase);
        assertEquals(11, output);
    }

    @Test
    @DisplayName("Para pontoBase igual a 5, o pontuação final deve ser 5")
    void test04() {
        var pontoBase = 5;
        var output = bronze.calcularPontuacao(pontoBase);
        assertEquals(5, output);
    }

    @Test
    @DisplayName("Para precoBase menor ou igual a zero, o preço final deve ser 0")
    void test05() {
        var precoBase = -1;
        var output = bronze.calcularPrecoFinal(precoBase);
        assertEquals(0, output);
    }

    @Test
    @DisplayName("Para pontoBase menor ou igual a zero, o pontuação final deve ser 0")
    void test06() {
        var pontoBase = -1;
        var output = bronze.calcularPontuacao(pontoBase);
        assertEquals(0, output);
    }

    @Test
    @DisplayName("Para a categoria bronze criada, toString não deve retornar null")
    void test07() {
        var output = bronze.toString();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Para a categoria bronze criada, getPontuacaoMinima deve retornar 100")
    void test08() {
        var output = Bronze.getPontuacaoMinima();
        assertEquals(100, output);
    }
}