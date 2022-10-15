package org.example.produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasseioTest {

    private Passeio tour;

    @BeforeEach
    public void init() {
        tour = new Passeio(new Date(), new Date(), "Igrejinha da Pampulha", 0.0, 25.0);
    }

    @Test
    @DisplayName("Para valor km igual a zero, calcularpreco deve retornar 80.0")
    void test01() {
        var valorEsperado=80.0;
        assertEquals(valorEsperado, tour.calcularPreco());
    }
}