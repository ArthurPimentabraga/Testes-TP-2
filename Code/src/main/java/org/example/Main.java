package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        carregarDadosClientes();
        carregarDadosHospedagem();
        carregarDadosVoos();
        printMain();
        printMenu();
    }

    private static void carregarDadosClientes() throws FileNotFoundException {
        Scanner clientes = new Scanner(new File("src/main/java/org/example/dados/clientes.txt"));
        while (clientes.hasNextLine()) {
            String clienteLinha = clientes.nextLine();
            String[] cliente = clienteLinha.split(";");
            Agencia.adicionarCliente(cliente[1],cliente[0]);
        }
    }

    private static void carregarDadosHospedagem() throws FileNotFoundException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner hoteis = new Scanner(new File("src/main/java/org/example/dados/hospedagem.txt"));
        while (hoteis.hasNextLine()) {
            String hospedagemLinha = hoteis.nextLine();
            String[] hotel = hospedagemLinha.split(";");
            Hospedagem nova = new Hospedagem((formato.parse(hotel[0])),formato.parse(hotel[1]),hotel[2],Double.parseDouble(hotel[3]),hotel[4]);
            Agencia.adicionarProduto(nova);
        }
    }

    private static void carregarDadosVoos() throws FileNotFoundException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner voos = new Scanner(new File("src/main/java/org/example/dados/passagem.txt"));
        while (voos.hasNextLine()) {
            String passagemLinha = voos.nextLine();
            String[] passagem = passagemLinha.split(";");
            PassagemAeria nova = new PassagemAeria((formato.parse(passagem[0])),formato.parse(passagem[1]),passagem[2],Integer.parseInt(passagem[3]),Double.parseDouble(passagem[4]));
            Agencia.adicionarProduto(nova);
        }
    }

    private static void printMain() {
        System.out.println(" _________________________          _____                                 ");
        System.out.println("|                         \\          \\ U \\__      _____                ");
        System.out.println("|      Não interessa       \\__________\\   \\/_______\\___\\____________ ");
        System.out.println("|        by Caram          /          < /_/   .....................  `-.  ");
        System.out.println("|_________________________/            `-----------,----,--------------'  ");
        System.out.println("                                                 _/____/                  ");
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
                System.out.println("Informe \"H\" para Hospedagem e \"P\" para passagem aérea: ");
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
                    System.out.println("Informe \"H\" para Hospedagem e \"P\" para passagem aérea: ");
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
                System.out.println("Informe \"H\" para Hospedagem e \"P\" para passagem aérea: ");
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