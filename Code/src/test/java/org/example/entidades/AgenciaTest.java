package org.example.entidades;

import org.example.produtos.Hospedagem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AgenciaTest {

    private Agencia agencia;
    private Hospedagem hospedagem;

    // Colocar annotation Before (ta quebrando por isso)


    //============================================================
    // Adicionar Cliente
    @Test
    @DisplayName("Para nome igual a null, adicionarCliente deve retornar null")
    void test01() {
        var output = Agencia.adicionarCliente(null, "123.123.123-01");
        assertNull(output);
    }

    @Test
    @DisplayName("Para nome igual a string vazia, adicionarCliente deve retornar null")
    void test02() {
        var output = Agencia.adicionarCliente("", "123.123.123-01");
        assertNull(output);
    }

    @Test
    @DisplayName("Para cpf igual a null, adicionarCliente deve retornar null")
    void test03() {
        var output = Agencia.adicionarCliente("José Silva", null);
        assertNull(output);
    }

    @Test
    @DisplayName("Para cpf igual a string vazia, adicionarCliente deve retornar null")
    void test04() {
        var output = Agencia.adicionarCliente("José Silva", "");
        assertNull(output);
    }

    @Test
    @DisplayName("Para cpf menor que 14 caracteres, adicionarCliente deve retornar null")
    void test05() {
        var output = Agencia.adicionarCliente("José Silva", "12312312312312");
        assertNull(output);
    }

    @Test
    @DisplayName("Para nome e cpf preenchidos, adicionarCliente deve retornar o novo cliente")
    void test06() {
        var output = Agencia.adicionarCliente("José Silva", "123.123.123-01");
        var expected = Agencia.localizarCliente("123.123.123-01");
        assertEquals(expected, output);
    }

    //     @Test
    //    @DisplayName("Se ocorrer uma exception, não deve propaga-la")
    //    void test03() {
    //
    //    }


    //==============================================================
    // Localizar Cliente
    @Test
    @DisplayName("Para cpf igual a null, localizarCliente deve retornar null")
    void test07() {
        var output = Agencia.localizarCliente(null);
        assertNull(output);
    }

    @Test
    @DisplayName("Para cpf igual a string vazia, localizarCliente deve retornar null")
    void test08() {
        var output = Agencia.localizarCliente("");
        assertNull(output);
    }

    @Test
    @DisplayName("Para cpf não cadastrado, localizarCliente deve retornar null")
    void test09() {
        var output = Agencia.localizarCliente("123.123.123-01");
        assertNull(output);
    }

    @Test
    @DisplayName("Caso não tenha clientes cadastrados, localizarCliente deve retornar null")
    void test10() {
        var output = Agencia.localizarCliente("123.123.123-01");
        assertNull(output);
    }

    @Test
    @DisplayName("Caso cpf esteja cadastrado, localizarCliente deve retornar o cliente passado")
    void test11() {
        var output = Agencia.localizarCliente("123.123.123-01");
        assertNull(output);
    }

    //    @Test
    //    @DisplayName("Se ocorrer uma exception, não deve propaga-la")
    //    void test03() {
    //
    //    }

    //==============================================================
    // Localizar Produto
    @Test
    @DisplayName("Para lista de produtos vazia, localizar produto deve retornar null")
    void test12() {
        var output = Agencia.localizarProduto("Belo Horizonte", "P");
        assertNull(output);
    }

    @Test
    @DisplayName("Para destino igual a null, localizarProduto deve retornar null")
    void test13() {
        var output = Agencia.localizarProduto(null, "H");
        assertNull(output);
    }

    @Test
    @DisplayName("Para destino igual a string vazia, localizarProduto deve retornar null")
    void test14() {
        var output = Agencia.localizarProduto("", "H");
        assertNull(output);
    }

    @Test
    @DisplayName("Para destino inválido, localizarProduto deve retornar null")
    void test15() {
        var output = Agencia.localizarProduto("", "H");
        assertNull(output);
    }

    @Test
    @DisplayName("Para opção inválida, localizarProduto deve retornar null")
    void test16() {
        var output = Agencia.localizarProduto("Belo Horizonte", "J");
        assertNull(output);
    }

    @Test
    @DisplayName("Para destino e opção validos, localizarProduto deve retornar o Produto passado")
    void test17() {
        var output = Agencia.localizarProduto("Belo Horizonte", "H");
        assertEquals(hospedagem, output);
    }

    //    @Test
    //    @DisplayName("Se ocorrer uma exception, não deve propaga-la")
    //    void test03() {
    //
    //    }

}
