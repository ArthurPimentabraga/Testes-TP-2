package org.example.produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNull;

class HospedagemTest {

    private Hospedagem hospedagem;

    @BeforeEach
    public void init() {
        hospedagem = new Hospedagem(new Date(), new Date(), "BH", 100.5, "Hotel 1");
    }

    @Test
    @DisplayName("Para destino igual a nulo, personalizaHospedagem deve retornar null")
    void test01() {
        var output = Hospedagem.personalizaHospedagem(null);
        assertNull(output);
    }

}
