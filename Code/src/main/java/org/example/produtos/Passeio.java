package org.example.produtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Data
@EqualsAndHashCode(callSuper = false)
public class Passeio extends Produto {

    private static final String DESC = "passeio";
    private static final double VALOR_KM_PADRAO = 15.0;
    private static final double VALOR_MINIMO = 80.00;
    private static final double DISTANCIA_MINIMA = 20;
    private double distanciaKm;
    private double valorKm;
    private String localPasseio;

    public Passeio(Date inicio, Date retorno, String localidade, double valorKm, double distanciaKm){
        super(DESC, inicio, retorno, localidade);
        this.distanciaKm=distanciaKm;
        this.valorKm=valorKm;

    }

    @Override
    public double calcularPreco() {
        return valorKm * distanciaKm + VALOR_MINIMO ;

    }

    @Override
    public int calcularPontuacao() {
        return (int) (calcularPreco()*0.1);
    }

    public static Produto personalizaPasseio(String destino) {
        Scanner teclado = null;
        try {
            if (destino == null || destino.equals("")) return null;

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAtual = new Date();

            teclado = new Scanner(System.in);

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


            while (retorno.compareTo(inicio) < 0) {
                System.out.println("Retorno não pode ser anterior à ida.");
                System.out.println("Data retorno: ");
                retorno = sdf.parse(teclado.nextLine());
            }

            System.out.println("Passeio escolhido: ");
            String passeio = teclado.nextLine();

            return arquirirPasseio(inicio, retorno, passeio);

        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Erro ao ler entrada. Nenhuma informaçao encontrada! Erro: " + noSuchElementException);
            return null;
        } catch (IllegalStateException illegalStateException) {
            System.out.println("Erro ao ler entrada. Problema interno! Erro: " + illegalStateException);
            return null;
        } catch (Exception exception) {
            System.out.println("Erro ao personalizar passeio!");
            return null;
        }


    }

    public static Passeio arquirirPasseio(Date inicio, Date retorno, String passeio) {
        System.out.println("Passeio adquirido com sucesso!");
        return new Passeio(inicio, retorno, passeio, VALOR_KM_PADRAO, DISTANCIA_MINIMA);
    }

    @Override
    public String toString() {
        return "Tipo: " + DESC + " | Código: " + this.codigo + " | Descrição: " + this.descricao +
                " | Localidade: " + this.localidade + " | Valor KM: " + this.valorKm;

    }

}