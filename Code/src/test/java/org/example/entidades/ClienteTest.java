package org.example.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void init() {
        cliente = new Cliente("Nome", "000.000.000-00");
    }

    //============================================================
    // Adicionar produto

    @Test
    @DisplayName("")
    void test01() {
    }

    //============================================================
    // Agregar pontuação
    @Test
    @DisplayName("Para produto nulo, não deve fazer nada")
    void test02() {
        assertDoesNotThrow(() -> cliente.agregarPontuacao(null));
    }

    @Test
    @DisplayName("Se ocorrer uma exception, não deve propaga-la")
    void test03() {

    }


    //============================================================
    // Mudar categoria



}
