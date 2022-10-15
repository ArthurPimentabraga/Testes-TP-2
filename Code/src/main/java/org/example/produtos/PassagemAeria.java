package org.example.produtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Data
@EqualsAndHashCode(callSuper = false)
public class PassagemAeria extends Produto {

    private static final String DESC = "Passagem Aérea";
    private int nVoo;
    private double precoPassagem;

    public PassagemAeria(Date inicio, Date retorno, String localidade, int nVoo, double preco){
        super(DESC, inicio, retorno, localidade);
        this.nVoo=nVoo;
        this.precoPassagem = preco;
    }

    @Override
    public double calcularPreco() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

        LocalDate diaCompra = LocalDate.now();
        LocalDate dateRetorno = LocalDate.parse(formatDate.format(this.inicio));
        long noOfDaysBetween = ChronoUnit.DAYS.between(diaCompra, dateRetorno);

        if (noOfDaysBetween<7) {
            return this.precoPassagem * 2;
        }

        if (noOfDaysBetween<60) {
            return this.precoPassagem + (this.precoPassagem * 0.5);
        }

        return this.precoPassagem;
    }

    @Override
    public int calcularPontuacao() {
        this.pontuacao = (int) (calcularPreco()*0.1);
        return this.pontuacao;
    }

    public static Produto personalizaPassagem(String destino){
        Scanner teclado = null;
        try {
            teclado = new Scanner(System.in);

            if (destino == null || destino.equals("")) return null;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAtual = new Date();
            System.out.println("Data de partida (dd/mm/yyyy): ");
            String dataIn = teclado.nextLine();
            Date inicio = sdf.parse(dataIn);

            while (inicio.compareTo(dataAtual) < 0) {
                System.out.println("Partida não pode ser uma data que já passou.");
                System.out.println("Data partida: ");
                inicio = sdf.parse(teclado.nextLine());
            }

            System.out.println("Data de retorno (dd/mm/yyyy): ");
            String dataOut = teclado.nextLine();
            Date retorno = sdf.parse(dataOut);

            // Viola o single responsibility?
            while (retorno.compareTo(inicio) < 0) {
                System.out.println("Retorno não pode ser anterior à ida.");
                System.out.println("Data retorno: ");
                retorno = sdf.parse(teclado.nextLine());
            }

            System.out.println("Voo escolhido: ");
            int voo = teclado.nextInt();

            System.out.println("Preço base do voo: ");
            double precoBase = teclado.nextDouble();

            System.out.println("Confirma escolha?: digite S ou N");
            String opcao = teclado.next().toUpperCase();

            if (opcao.equals("S")) {
                System.out.println("Passagem aérea adquirida com sucesso!");
                return new PassagemAeria(inicio, retorno, destino, voo, precoBase);
            }

            System.out.println("Pedido cancelado");
            return null;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Erro ao ler entrada. Nenhuma informaçao encontrada! Erro: " + noSuchElementException);
            return null;
        } catch (IllegalStateException illegalStateException) {
            System.out.println("Erro ao ler entrada. Problema interno! Erro: " + illegalStateException);
            return null;
        } catch (Exception exception) {
            System.out.println("Erro ao personalizar passagem aéria!");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Tipo: " + DESC + " | Código: " + this.codigo + " | Descrição: " + this.descricao +
                " | Localidade: " + this.localidade + " | Número do voo: " + this.nVoo +
                " | Preço base da passagem: " + this.precoPassagem;
    }

}
