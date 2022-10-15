package org.example.categoriasCliente;

import org.example.interfaces.ICategoria;

public class Bronze implements ICategoria {

    private static final float DESCONTO = 0.05F;
    private static final float PONTUACAO = 0.1F;
    private static final int PONTUACAO_MINIMA = 100;

    public double calcularPrecoFinal(double precoBase) {
        if (precoBase < 0) {
            return 0;
        }
        return precoBase - (precoBase * getDESCONTO());
    }

    public int calcularPontuacao(int pontoBase) {
        if (pontoBase < 0) {
            return 0;
        }
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

    //To String

    public String toString(){
        String descricao = "Bronze";
        return descricao;}
}
