package org.example.categoriasCliente;

import lombok.Data;
import org.example.interfaces.ICategoria;

@Data
public class Ouro implements ICategoria {

    private static final float DESCONTO = 0.15F;
    private static final float PONTUACAO = 1F;
    private static final int PONTUACAO_MINIMA = 1000;

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

    public static float getPontuacaoMinima() {
        return PONTUACAO_MINIMA;
    }

    public static float getDESCONTO() {
        return DESCONTO;
    }

    public static float getPONTUACAO() {
        return PONTUACAO;
    }

    public String toString() {
        return "Ouro";
    }

}
