package org.example.categoriasCliente;

import org.example.interfaces.ICategoria;

public class Prata implements ICategoria {

    private static final float DESCONTO = 0.1F;
    private static final float PONTUACAO = 0.5F;
    private static final int PONTUACAO_MINIMA = 500;

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
        String descricao = "Prata";
        return descricao;}

}
