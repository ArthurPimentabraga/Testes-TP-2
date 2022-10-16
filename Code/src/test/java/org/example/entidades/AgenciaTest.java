package org.example.entidades;

import org.example.produtos.Hospedagem;
import org.example.produtos.PassagemAeria;
import org.example.produtos.Passeio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AgenciaTest {

    private Cliente cliente;
    private Hospedagem hospedagem;
    private PassagemAeria passagem;

    private Passeio passeio;

    @BeforeEach
    public void init() {
        Agencia.produtos = new ArrayList<>();
        Agencia.clientes = new ArrayList<>();

        hospedagem = new Hospedagem(
                new Date(), new Date(), "Belo Horizonte", 100, "Nome hotel"
        );

        passagem = new PassagemAeria(
                new Date(), new Date(), "Orlando", 666, 600.0
        );

        passeio = new Passeio(
                new Date(), new Date(), "Rio de Janeiro", 30.0, 0
        );

        Agencia.produtos.add(hospedagem);
        Agencia.produtos.add(passagem);
        Agencia.adicionarProduto(passeio);

        cliente = new Cliente("Nome", "123.123.123-02");
        Agencia.clientes = new ArrayList<>();
        Agencia.clientes.add(cliente);
    }

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
        var output = Agencia.adicionarCliente("José Silva", "1231231231231");
        assertNull(output);
    }

    @Test
    @DisplayName("Para nome e cpf preenchidos, adicionarCliente deve retornar o novo cliente")
    void test06() {
        var output = Agencia.adicionarCliente("José Silva", "123.123.123-01");
        var expected = Agencia.localizarCliente("123.123.123-01");

        assertNotNull(expected);
        assertEquals(expected.getCpf(), output.getCpf());
        assertEquals(expected.getNome(), output.getNome());
    }

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
        var output = Agencia.localizarCliente("000.000.000-00");
        assertNull(output);
    }

    @Test
    @DisplayName("Caso não tenha clientes cadastrados, localizarCliente deve retornar null")
    void test10() {
        Agencia.clientes = new ArrayList<>();
        var output = Agencia.localizarCliente("123.123.123-01");
        assertNull(output);
    }

    @Test
    @DisplayName("Caso cpf esteja cadastrado, localizarCliente deve retornar o cliente passado")
    void test11() {
        var output = Agencia.localizarCliente("123.123.123-02");
        assertEquals(cliente, output);
    }

    //==============================================================
    // Localizar Produto

    @Test
    @DisplayName("Para lista de produtos vazia, localizar produto deve retornar null")
    void test12() {
        Agencia.produtos = new ArrayList<>();
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
        var output = Agencia.localizarProduto("Montes Claros", "H");
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

    @Test
    @DisplayName("Para destino e opção validos para PassagemAeria, localizarProduto deve retornar o Produto desejado")
    void test18() {
        var output = Agencia.localizarProduto("Orlando", "P");
        assertEquals(passagem, output);
    }

    @Test
    @DisplayName("Para destino e opção validos para PassagemAeria, localizarProduto deve retornar o Produto desejado")
    void test19() {
        var output = Agencia.localizarProduto("Rio de Janeiro", "T");
        assertEquals(passeio, output);
    }

    //==============================================================
    // Valida lista clientes

    @Test
    @DisplayName("Para lista de clientes nula, deve retornar TRUE")
    void test20() {
        Agencia.clientes = null;
        var output = Agencia.validaListaClientes();
        assertTrue(output);
    }

    @Test
    @DisplayName("Para lista de clientes vazia, deve retornar TRUE")
    void test21() {
        Agencia.clientes = new ArrayList<>();
        var output = Agencia.validaListaClientes();
        assertTrue(output);
    }

    @Test
    @DisplayName("Para lista de clientes válida, deve retornar FALSE")
    void test22() {
        var output = Agencia.validaListaClientes();
        assertFalse(output);
    }

    //==============================================================
    // Personaliza produto

    @Test
    @DisplayName("Para opção inexistente deve retornar null")
    void test23() throws ParseException {
        var output = Agencia.personalizaProduto("Miami", "J");
        assertNull(output);
    }

}
