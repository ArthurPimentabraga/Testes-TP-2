package org.example.produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HospedagemTest {

    private Hospedagem hospedagem;

    @BeforeEach
    public void init() {
        hospedagem = new Hospedagem(new Date(), new Date(), "Belo Horizonte", 100.5, "Hotel 1");
    }

    @Test
    @DisplayName("Para destino igual a nulo, personalizaHospedagem deve retornar null")
    void test01() {
        var output = Hospedagem.personalizaHospedagem(null);
        assertNull(output);
    }

    @Test
    @DisplayName("Para o produto criado com uma diferença de dias da data atual de 0 dias, calcularPreco deve retornar 0")
    void test02() {
        var output = hospedagem.calcularPreco();
        assertEquals(0, output);
    };

    @Test
    @DisplayName("Para o produto criado com uma diferença de dias da data atual de 0 dias, calcularPontuacao deve retornar 0")
    void test03() {
        var output = hospedagem.calcularPontuacao();
        assertEquals(0, output);
    }

    @Test
    @DisplayName("Para um produto criado, a variável nomeHotel não pode ser nula")
    void test4() {
        var output = hospedagem.getNomeHotel();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Para um produto criado, a variável valorDiaria não pode ser nula")
    void test5() {
        var output = hospedagem.getValorDiaria();
        assertNotNull(output);
    }
}
