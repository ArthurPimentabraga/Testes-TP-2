package org.example.produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    @DisplayName("Para valor km igual a zero, calcularPontuacao deve retornar 8")
    void test02() {
        var output = tour.calcularPontuacao();
        assertEquals(8, output);
    }

    @Test
    @DisplayName("Para um passeio criado, toString não deve retornar null")
    void test03() {
        var output = tour.toString();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Para um destino igual a null, personalizaPasseio deve retornar null")
    void test04() throws ParseException {
        var output = Passeio.personalizaPasseio(null);
        assertEquals(null, output);
    }

    @Test
    @DisplayName("Para um passeio criado, a variável distanciaKm não deve retornar null")
    void test05() {
        var output = tour.getDistanciaKm();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Para um passeio criado, a variável valorKm não deve retornar null")
    void test06() {
        var output = tour.getValorKm();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Para parametros de criar um passeio válidos , arquirirPasseio não deve retornar null")
    void test07() {
        var output = Passeio.arquirirPasseio(new Date(), new Date(), "Teste");
        assertNotNull(output);
    }

    @Test
    @DisplayName("Verificar busca de variável localPasseio não deve retornar null")
    void test08() {
        tour.setLocalPasseio("BH");
        var output = tour.getLocalPasseio();
        assertNotNull(output);
    }

}