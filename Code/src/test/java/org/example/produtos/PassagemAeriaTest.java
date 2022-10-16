package org.example.produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PassagemAeriaTest {

    private PassagemAeria passagemAeria;
    @Mock
    private Scanner scanner;

    @BeforeEach
    public void init() {
        passagemAeria = new PassagemAeria(new Date(), new Date(), "Belo Horizonte", 1234, 650.00);
    }

    @Test
    @DisplayName("Para destino igual a nulo, personalizaPassagem deve retornar null")
    void test01() throws ParseException {
        var output = PassagemAeria.personalizaPassagem(null);
        assertNull(output);
    }

    @Test
    @DisplayName("Para o produto criado com uma diferença de dias da data atual de mais de 60 dias, calcularPreco deve retornar 650")
    void test02() {
        passagemAeria.setInicio(createDate(80));
        passagemAeria.setRetorno(createDate(80));
        var output = passagemAeria.calcularPreco();
        assertEquals(650, output);
    };

    @Test
    @DisplayName("Para o produto criado com uma diferença de dias da data atual menor que 7 dias, calcularPreco deve retornar 1300")
    void test03() {
        var output = passagemAeria.calcularPreco();
        assertEquals(1300, output);
    };

    @Test
    @DisplayName("Para o produto criado com uma diferença de dias da data atual menor que 60 dias, calcularPreco deve retornar 975")
    void test04() {
        passagemAeria.setInicio(createDate(50));
        passagemAeria.setRetorno(createDate(50));
        var output = passagemAeria.calcularPreco();
        assertEquals(975, output);
    };

    @Test
    @DisplayName("Para o produto criado com uma diferença de dias da data atual de mais de 60 dias, calcularPontuacao deve retornar 130")
    void test05() {
        var output = passagemAeria.calcularPontuacao();
        assertEquals(130, output);
    }

    @Test
    @DisplayName("Para um destino igual a null, personalizaPassagem deve retornar null")
    void test06() throws ParseException {
        var output = PassagemAeria.personalizaPassagem(null);
        assertEquals(null, output);
    }

    @Test
    @DisplayName("Para um destino igual a String vazia, personalizaPassagem deve retornar null")
    void test07() throws ParseException {
        var output = PassagemAeria.personalizaPassagem("");
        assertEquals(null, output);
    }

    @Test
    @DisplayName("Para um produto criado, toString não deve retornar null")
    void test08() {
        var output = passagemAeria.toString();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Para um produto criado, toString não deve retornar uma string vazia")
    void test09() {
        var output = passagemAeria.toString();
        assertNotEquals("", output);
    }

    @Test
    @DisplayName("Para um produto criado, a variável nVoo não pode ser nula")
    void test10() {
        assertNotNull( passagemAeria.getnVoo());
    }

    @Test
    @DisplayName("Para um produto criado, a variável precoPassagem não pode ser nula")
    void test11() {
        assertNotNull(passagemAeria.getPrecoPassagem());
    }

    @Test
    @DisplayName("Para parametros de criar um passeio válidos , arquirirPasseio não deve retornar null")
    void test12() {
        var output = PassagemAeria.arquirirPassagemAeria(new Date(), new Date(), "Teste", 123, 3509);
        assertNotNull(output);
    }

    private Date createDate(int plusDays) {
        LocalDate diaCompra = LocalDate.now().plusDays(plusDays);
        Instant instant = Instant.from(diaCompra.atStartOfDay(ZoneId.of("GMT")));
        return Date.from(instant);
    }

}