package org.example.categoriasCliente;

import org.example.interfaces.ICategoria;

public class Diamante implements ICategoria {
    private static final float DESCONTO = 0.2F;
    private static final float PONTUACAO = 1.5F;
    public static final int PONTUACAO_MINIMA = 1500;

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

    //To String

    public String toString(){
        String descricao = "Diamante";
        return descricao;
    }
}
