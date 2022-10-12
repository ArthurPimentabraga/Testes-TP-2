package org.example;

import java.util.Date;

public abstract class Produto {
    private static int codigoAnterior = 0;
    protected int codigo;
    protected int pontuacao;
    protected String descricao;
    protected Date inicio;
    protected Date retorno;
    protected String localidade;

    //criar construtor
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

    // Getters and Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPontuacaoBase() {
        return pontuacao;
    }

    public void setPontuacaoBase(int pontuacaoBase) {
        this.pontuacao = pontuacaoBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getRetorno() {
        return retorno;
    }

    public void setRetorno(Date retorno) {
        this.retorno = retorno;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    
    
}
