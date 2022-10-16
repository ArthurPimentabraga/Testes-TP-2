package org.example.entidades;

import org.example.produtos.PassagemAeria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void init() {
        cliente = new Cliente("Nome", "000.000.000-00");
        cliente.setProdutos(new ArrayList<>());

        Agencia.produtos.add(new PassagemAeria(new Date(), new Date(), "Belo Horizonte", 1234, 650.00));
    }

    //============================================================
    // Adicionar produto

    @Test
    @DisplayName("Para destino null não deve adicionar nenhum produto a lista")
    void test01() throws ParseException {
        cliente.adicionarProduto(null, "H");
        assertEquals(cliente.getProdutos().size(), 0);
    }

    @Test
    @DisplayName("Para lista de produtos nula, deve cria-la")
    void test02() throws ParseException {
        cliente.setProdutos(null);
        cliente.adicionarProduto("Belo Horizonte", "P");
        assertEquals(cliente.getProdutos().size(), 1);
    }

    //============================================================
    // Agregar pontuação
    @Test
    @DisplayName("Para produto nulo, não deve fazer nada")
    void test03() {
        assertDoesNotThrow(() -> cliente.agregarPontuacao(null));
    }

    @Test
    @DisplayName("Se ocorrer uma exception, não deve propaga-la")
    void test04() {

    }


    //============================================================
    // Mudar categoria



}
