package org.example.produtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

@Data
@EqualsAndHashCode(callSuper = false)
public class Hospedagem extends Produto {

    private static final String DESC = "Hospedagem";
    private static final double VALOR_DIARIA_PADRAO = 350.00;
    private double valorDiaria;
    private String nomeHotel;

    public Hospedagem(Date inicio, Date retorno, String localidade, double valorDiaria, String nomeHotel){
        super(DESC, inicio, retorno, localidade);
        this.valorDiaria=valorDiaria;
        this.nomeHotel=nomeHotel;
    }

    @Override
    public double calcularPreco() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate dateRetorno = LocalDate.parse(formatDate.format(this.retorno));
        LocalDate dateInicio = LocalDate.parse(formatDate.format(this.inicio));

        long noOfDaysBetween = ChronoUnit.DAYS.between(dateInicio, dateRetorno);

        return (double)noOfDaysBetween * valorDiaria;
    }

    @Override
    public int calcularPontuacao() {
        return (int) (calcularPreco()*0.1);
    }

    public static Produto personalizaHospedagem(String destino) throws ParseException {
        Scanner teclado = null;

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

        System.out.println("Hotel escolhido: ");
        String hotel = teclado.nextLine();

        System.out.println("Valor diaria nesse hotel: " + VALOR_DIARIA_PADRAO);
        return arquirirHospedagem(inicio, retorno, destino, hotel);
    }

    public static Hospedagem arquirirHospedagem(Date inicio, Date retorno, String destino, String hotel) {
        System.out.println("Hospedagem adquirida com sucesso!");
        return new Hospedagem(inicio, retorno, destino, VALOR_DIARIA_PADRAO, hotel);
    }

    @Override
    public String toString() {
        return "Tipo: " + DESC + " | Código: " + this.codigo + " | Descrição: " + this.descricao +
                " | Localidade: " + this.localidade + " | Valor diária: " + this.valorDiaria +
                " | Nome Hotel: " + this.nomeHotel;
    }

}
