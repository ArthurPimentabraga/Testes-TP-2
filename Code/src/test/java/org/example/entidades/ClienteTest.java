package org.example.entidades;

import org.example.categoriasCliente.Bronze;
import org.example.categoriasCliente.Diamante;
import org.example.categoriasCliente.Ouro;
import org.example.categoriasCliente.Prata;
import org.example.produtos.PassagemAeria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void test01() {
        cliente.adicionarProduto(null, "H");
        assertEquals(cliente.getProdutos().size(), 0);
    }

    @Test
    @DisplayName("Para lista de produtos nula, deve cria-la")
    void test04() {
        cliente.setProdutos(null);
        cliente.adicionarProduto("Belo Horizonte", "P");
        assertEquals(cliente.getProdutos().size(), 1);
    }

    //============================================================
    // Agregar pontuação
    @Test
    @DisplayName("Para produto nulo, não deve fazer nada")
    void test02() {
        assertDoesNotThrow(() -> cliente.agregarPontuacao(null));
    }


    //============================================================
    // Mudar categoria

    @Test
    @DisplayName("Validar mudança de categoria para Bronze")
    void test06() {
        Cliente cliente = new Cliente("sem categoria","111.231.123-02");
        cliente.setPontuacao(100);
        cliente.mudarCategoria();
        assertEquals(Bronze.class, cliente.getCategoria().getClass());
    }

    @Test
    @DisplayName("Validar mudança de categoria para Prata")
    void test07() {
        Cliente cliente = new Cliente("bronze","111.231.123-02");
        cliente.setPontuacao(500);
        cliente.mudarCategoria();
        assertEquals(Prata.class,cliente.getCategoria().getClass());
    }

    @Test
    @DisplayName("Validar mudança de categoria para Ouro")
    void test08() {
        Cliente cliente = new Cliente("prata","111.231.123-02");
        cliente.setPontuacao(1000);
        cliente.mudarCategoria();
        assertEquals(Ouro.class,cliente.getCategoria().getClass());
    }

    @Test
    @DisplayName("Validar mudança de categoria para Diamante")
    void test09() {
        Cliente cliente = new Cliente("Ouro","111.231.123-02");
        cliente.setPontuacao(1500);
        cliente.mudarCategoria();
        assertEquals(Diamante.class,cliente.getCategoria().getClass());
    }

}
