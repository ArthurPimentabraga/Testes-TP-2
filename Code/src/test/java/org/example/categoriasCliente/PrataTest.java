package org.example.categoriasCliente;

import org.example.categoriasCliente.Bronze;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrataTest {
    private static Prata prata;

    @BeforeAll
    public static void init() {
        prata = new Prata();
    }

    @Test
    @DisplayName("Para precoBase igual a 100, o preco final deve ser 90")
    void test01() {
        var precoBase = 100;
        var output = prata.calcularPrecoFinal(precoBase);
        assertEquals(90, output, 0.0001);
    }

    @Test
    @DisplayName("Para precoBase igual a 100.50, o preco final deve ser 90,45")
    void test02() {
        var precoBase = 100.50;
        var output = prata.calcularPrecoFinal(precoBase);
        assertEquals(90.45, output, 0.0001);
    }

    @Test
    @DisplayName("Para pontoBase igual a 10, o pontuação final deve ser 15")
    void test03() {
        var pontoBase = 10;
        var output = prata.calcularPontuacao(pontoBase);
        assertEquals(15, output);
    }

    @Test
    @DisplayName("Para pontoBase igual a 5, o pontuação final deve ser 7")
    void test04() {
        var pontoBase = 5;
        var output = prata.calcularPontuacao(pontoBase);
        assertEquals(7, output);
    }

    @Test
    @DisplayName("Para precoBase menor ou igual a zero, o preço final deve ser 0")
    void test05() {
        var precoBase = -1;
        var output = prata.calcularPrecoFinal(precoBase);
        assertEquals(0, output);
    }

    @Test
    @DisplayName("Para pontoBase menor ou igual a zero, o pontuação final deve ser 0")
    void test06() {
        var pontoBase = -1;
        var output = prata.calcularPontuacao(pontoBase);
        assertEquals(0, output);
    }

    @Test
    @DisplayName("Para a categoria ouro criada, toString não deve retornar null")
    void test07() {
        var output = prata.toString();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Para a categoria ouro criada, getPontuacaoMinima deve retornar 500")
    void test08() {
        var output = Prata.getPontuacaoMinima();
        assertEquals(500, output);
    }
}