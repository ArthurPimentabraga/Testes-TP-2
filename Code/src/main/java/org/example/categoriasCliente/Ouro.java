package org.example.categoriasCliente;

import org.example.interfaces.ICategoria;

public class Ouro implements ICategoria {

    private static final float DESCONTO = 0.15F;
    private static final float PONTUACAO = 1F;
    private static final int PONTUACAO_MINIMA = 1000;

    public double calcularPrecoFinal(double precoBase) {
        return precoBase - (precoBase * getDESCONTO());
    }

    public int calcularPontuacao(int pontoBase) {
        return pontoBase + (int)(pontoBase * getPONTUACAO());
    }

    // Getters and Setters

    public static float getDESCONTO() {
        return DESCONTO;
    }

    public static float getPONTUACAO() {
        return PONTUACAO;
    }

    public static float getPontuacaoMinima() {
        return PONTUACAO_MINIMA;
    }

    //ToString
    public String toString(){
        String descricao = "Ouro";
        return descricao;}

}
