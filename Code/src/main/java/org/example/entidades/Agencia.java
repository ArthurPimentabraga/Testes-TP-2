package org.example.entidades;

import org.example.produtos.Hospedagem;
import org.example.produtos.PassagemAeria;
import org.example.produtos.Passeio;
import org.example.produtos.Produto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

    private int codigo;
    private String nome;
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Produto> produtos = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public Agencia(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public static Cliente adicionarCliente(String nome, String cpf) {
        if (nome == null || cpf == null || nome.equals("") || cpf.equals("")) return null;

        if (cpf.length() != 14) {
            System.out.println("CPF informádo é inválido.");
            return null;
        }

        Cliente novoCliente = new Cliente(nome, cpf);
        clientes.add(novoCliente);
        System.out.println("Cliente adicionado com sucesso!");
        return novoCliente;
    }

    public static void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    /**
     * metodo para adicionar um produto personalizado para um destino informado pelo
     * cliente
     */
    public static Produto personalizaProduto(String destino, String opcao) throws ParseException { // AQUI

        Produto produto = null;
        switch (opcao) {
            case "H":
                produto = Hospedagem.personalizaHospedagem(destino);
                break;

            case "P":
                produto = PassagemAeria.personalizaPassagem(destino);
                break;

            case "T":
                produto= Passeio.personalizaPasseio(destino);
                break;
        }

        if (produto != null) {
            adicionarProduto(produto);
            return produto;
        }

        return null;
    }

    /**
     * localizar um cliente da agência a partir de um cpf informado
     */
    public static Cliente localizarCliente(String cpf) {
        Cliente buscado = null;

        if (clientes == null || clientes.isEmpty()) {
            System.out.println("\nNão há clientes registrados!");
            return null;
        }

        if (cpf == null || cpf.equals("")) return null;

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                buscado = cliente;
                System.out.println(buscado);
                return buscado;
            }
        }
        return null;
    }

    /**
     * localizar um produto ofertado pela agencia a partir de um destino informado
     */
    public static Produto localizarProduto(String destino, String opcao) {
        Produto resultado = null;

        if (validaListaProdutos()) return null;

        if (destino == null || destino.equals("")) return null;

        for (Produto produto : produtos) {
            if (produto.getLocalidade().equals(destino)) {
                switch (opcao) {
                    case "H":
                        if (produto instanceof Hospedagem) {
                            resultado = produto;
                            System.out.println(resultado);
                        }
                        break;

                    case "P":
                        if (produto instanceof PassagemAeria) {
                            resultado = produto;
                            System.out.println(resultado);
                        }
                        break;

                    case "T":
                        if (produto instanceof Passeio) {
                            resultado = produto;
                            System.out.println(resultado);
                        }
                        break;
                }
            }
        }
        return resultado;
    }

    public static void listProdutos() {
        if (validaListaProdutos()) return;

        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public static boolean validaListaProdutos() {
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("\nNão há produtos registrados!");
            return true;
        }

        return false;
    }

    public static void listClientes() {
        if (validaListaClientes()) return;

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public static boolean validaListaClientes() {
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("\nNão há clientes registrados!");
            return true;
        }

        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
