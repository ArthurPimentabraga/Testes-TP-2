package org.example.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarregamentoDadosTest {

    @Test
    @DisplayName("Para o arquivo existente, carregarDadosClientes não deve propagar um FileNotFoundException")
    void test01() {
        assertDoesNotThrow(
                () -> CarregamentoDados.carregarDadosClientes()
        );

    }

    @Test
    @DisplayName("Para o arquivo existente, carregarDadosHospedagem() não deve propagar um FileNotFoundException")
    void test02() {
        assertDoesNotThrow(
                () -> CarregamentoDados.carregarDadosHospedagem()
        );

    }

    @Test
    @DisplayName("Para o arquivo existente, carregarDadosHospedagem() não deve propagar uma ParseException")
    void test03() {
        assertDoesNotThrow(
                () -> CarregamentoDados.carregarDadosHospedagem()
        );

    }

    @Test
    @DisplayName("Para o arquivo existente, carregarDadosVoos não deve propagar um FileNotFoundException")
    void test04() {
        assertDoesNotThrow(
                () -> CarregamentoDados.carregarDadosVoos()
        );

    }

    @Test
    @DisplayName("Para o arquivo existente, carregarDadosVoos não deve propagar um ParseException")
    void test05() {
        assertDoesNotThrow(
                () -> CarregamentoDados.carregarDadosVoos()
        );

    }

}
