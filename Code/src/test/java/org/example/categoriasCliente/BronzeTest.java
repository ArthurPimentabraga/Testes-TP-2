package org.example.categoriasCliente;

import org.example.categoriasCliente.Bronze;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}