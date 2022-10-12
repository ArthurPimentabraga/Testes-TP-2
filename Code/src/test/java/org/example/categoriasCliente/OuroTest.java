package org.example.categoriasCliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OuroTest {

    private Ouro ouro;

    @BeforeEach
    public void init() {
        ouro = new Ouro();
    }

    @Test
    @DisplayName("Para precoBase igual a 100, o preco final deve ser 85")
    void test01() {
        var precoBase = 100;
        var output = ouro.calcularPrecoFinal(precoBase);
        assertEquals(85, output, 0.0001);
    }

    @Test
    @DisplayName("Para precoBase igual a 100.50, o preco final deve ser 85.425")
    void test02() {
        var precoBase = 100.50;
        var output = ouro.calcularPrecoFinal(precoBase);
        assertEquals(85.425, output, 0.0001);
    }

    @Test
    @DisplayName("Para pontoBase igual a 10, o pontuação final deve ser 20")
    void test03() {
        var pontoBase = 10;
        var output = ouro.calcularPontuacao(pontoBase);
        assertEquals(20, output);
    }

    @Test
    @DisplayName("Para pontoBase igual a 5, o pontuação final deve ser 10")
    void test04() {
        var pontoBase = 5;
        var output = ouro.calcularPontuacao(pontoBase);
        assertEquals(10, output);
    }

}
