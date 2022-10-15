package org.example.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.entidades.Agencia;
import org.example.produtos.Hospedagem;
import org.example.produtos.PassagemAeria;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarregamentoDados {

    private static final String arquivoClientes = "src/main/java/org/example/dados/clientes.txt";
    private static final String arquivoHospedagem = "src/main/java/org/example/dados/hospedagem.txt";
    private static final String arquivoPassagem = "src/main/java/org/example/dados/passagem.txt";

    public static void carregarDadosClientes() throws FileNotFoundException {
        Scanner clientes = new Scanner(new File(arquivoClientes));

        while (clientes.hasNextLine()) {
            String clienteLinha = clientes.nextLine();
            String[] cliente = clienteLinha.split(";");
            Agencia.adicionarCliente(cliente[1],cliente[0]);
        }
    }

    public static void carregarDadosHospedagem() throws FileNotFoundException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner hoteis = new Scanner(new File(arquivoHospedagem));
        while (hoteis.hasNextLine()) {
            String hospedagemLinha = hoteis.nextLine();
            String[] hotel = hospedagemLinha.split(";");
            Hospedagem nova = new Hospedagem((formato.parse(hotel[0])),formato.parse(hotel[1]),hotel[2],Double.parseDouble(hotel[3]),hotel[4]);
            Agencia.adicionarProduto(nova);
        }
    }

    public static void carregarDadosVoos() throws FileNotFoundException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner voos = new Scanner(new File(arquivoPassagem));
        while (voos.hasNextLine()) {
            String passagemLinha = voos.nextLine();
            String[] passagem = passagemLinha.split(";");
            PassagemAeria nova = new PassagemAeria((formato.parse(passagem[0])),formato.parse(passagem[1]),passagem[2],Integer.parseInt(passagem[3]),Double.parseDouble(passagem[4]));
            Agencia.adicionarProduto(nova);
        }
    }

}
