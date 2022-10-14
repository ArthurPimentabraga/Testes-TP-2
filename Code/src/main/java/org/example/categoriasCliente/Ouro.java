package org.example.categoriasCliente;

import lombok.Data;
import org.example.interfaces.ICategoria;

@Data
public class Ouro implements ICategoria {

    private static final double DESCONTO = 0.15D;
    private static final double PONTUACAO = 1D;
    public static final int PONTUACAO_MINIMA = 1000;

    public double calcularPrecoFinal(double precoBase) {
        return precoBase - (precoBase * DESCONTO);
    }

    public int calcularPontuacao(int pontoBase) {
        return pontoBase + (int)(pontoBase * PONTUACAO);
    }

    public String toString() {
        return "Ouro";
    }

}
