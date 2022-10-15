package org.example;

import org.example.entidades.Agencia;
import org.example.entidades.Cliente;
import org.example.produtos.Produto;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.example.utils.CarregamentoDados.*;

public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        carregarDadosClientes();
        carregarDadosHospedagem();
        carregarDadosVoos();
        carregarDadosPasseio();
        printMenu();
    }

    private static void printMenu() {
        Scanner menu = new Scanner(System.in);

        try {
            int choose = 0;
            while (choose != 8) {
                System.out.println("\nDigite o número respectivo à ação que deseja fazer:");
                System.out.println("1- Adicionar novo cliente");
                System.out.println("2- Adicionar novo produto");
                System.out.println("3- Adicionar produto a um cliente");
                System.out.println("4- Localizar produto");
                System.out.println("5- Localizar cliente");
                System.out.println("6- Listar produtos");
                System.out.println("7- Listar clientes");
                System.out.println("8- Sair");

                System.out.printf("> ");
                choose = menu.nextInt();
                callFunctionality(choose);
            }

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Método solicitado não existe, erro após criação de um produto " + noSuchElementException);
        } catch (Exception exception) {
            System.out.println("Erro ao printar menu: " + exception);
        }
    }

    private static void callFunctionality(int choose) {
        switch (choose) {
            case 1:
                System.out.println("Informe o nome: ");
                String nome = teclado.nextLine();
                System.out.println("Informe o cpf (xxx.xxx.xxx-xx): ");
                String cpf = teclado.nextLine();
                Cliente cliente = Agencia.adicionarCliente(nome, cpf);
                if(cliente != null) cliente.toString();
                break;
            case 2:
                System.out.println("Informe o destino: ");
                String destino = teclado.nextLine();
                System.out.println("Informe \"H\" para Hospedagem; \"P\" para passagem aérea; \"T\" para passeio: ");
                String opcao = teclado.nextLine().toUpperCase();
                Produto produto = Agencia.personalizaProduto(destino,opcao);
                if (produto != null) {
                    System.out.println("Confira as informações sobre o produto adqurido!\n"+produto.toString());
                }
                break;
            case 3:
                System.out.println("Informe o cpf: ");
                cpf = teclado.nextLine();
                cliente = Agencia.localizarCliente(cpf);
                if(cliente!=null){
                    System.out.println("Informe o destino: ");
                    destino = teclado.nextLine();
                    System.out.println("Informe \"H\" para Hospedagem; \"P\" para passagem aérea e \"T\" para passeio: ");
                    opcao = teclado.nextLine().toUpperCase();
                    cliente.adicionarProduto(destino,opcao);
                }
                else{
                    System.out.println("Cliente não localizado");
                }
                break;
            case 4:
                System.out.println("Informe o destino a ser buscado: ");
                String buscaProduto = teclado.nextLine();
                System.out.println("Informe \"H\" para Hospedagem; \"P\" para passagem aérea e \"T\" para passeio: ");
                opcao = teclado.nextLine().toUpperCase();
                Produto produtoBuscado = Agencia.localizarProduto(buscaProduto,opcao);
                if (produtoBuscado != null) produtoBuscado.toString();
                else System.out.println("Produto não localizado");
                break;
            case 5:
                System.out.println("Informe o cpf do cliente a ser buscado: ");
                String buscaCliente = teclado.nextLine();
                Cliente clienteBuscado = Agencia.localizarCliente(buscaCliente);
                if (clienteBuscado != null) clienteBuscado.toString();
                else System.out.println("Cliente não localizado");
                break;
            case 6:
                Agencia.listProdutos();
                break;
            case 7:
                Agencia.listClientes();
                break;
            case 8:
                System.out.println("\nObrigado por usar nosso sistema. Boa viajem :)");
                break;
            default:
                System.out.println("\nFuncionalidade não encontrada! Por favor, digite novamente.");
                break;
        }
    }

}