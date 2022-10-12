package org.example.interfaces;

public interface ICategoria {

    /**
     * Retorna a o preço final à pagar descontando o valor do desconto
     * @param precoBase -> Preço calculado pelo produto - Sem desconto aplicado
     */
    double calcularPrecoFinal(double precoBase);

    /**
     * Retorna a pontuação final à se ganhar após a compra dos produtos selecionados.
     * Acrescentando o bônus de acordo com a categoria.
     * @param pontoBase -> Pontuação calculada pelo produto - Sem adição de bônus
     */
    int calcularPontuacao(int pontoBase);

}
