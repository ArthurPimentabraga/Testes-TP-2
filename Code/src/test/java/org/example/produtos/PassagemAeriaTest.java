package org.example.produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PassagemAeriaTest {

    private PassagemAeria passagemAeria;

    @BeforeEach
    public void init() {
        passagemAeria = new PassagemAeria(new Date(), new Date(), "Belo Horizonte", 1234, 650.00);
    }

    @Test
    @DisplayName("Para destino igual a nulo, personalizaPassagem deve retornar null")
    void test01() {
        var output = PassagemAeria.personalizaPassagem(null);
        assertNull(output);
    }
}