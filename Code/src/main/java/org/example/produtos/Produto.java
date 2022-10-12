package org.example.produtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public abstract class Produto {
    private static int codigoAnterior = 0;
    protected int codigo;
    protected int pontuacao;
    protected String descricao;
    protected Date inicio;
    protected Date retorno;
    protected String localidade;

    public Produto(String desc, Date inicio, Date retorno, String localidade){
        this.descricao = desc;
        this.inicio = inicio;
        this.retorno = retorno;
        this.localidade = localidade;
        this.codigo = Produto.codigoAnterior;
        Produto.codigoAnterior++;
    }

    public abstract int calcularPontuacao();

    public abstract double calcularPreco();
    
}
