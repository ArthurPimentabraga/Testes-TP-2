package org.example;

import org.example.categoriasCliente.Bronze;
import org.example.categoriasCliente.Ouro;
import org.example.categoriasCliente.Prata;
import org.example.interfaces.ICategoria;
import java.text.ParseException;
import java.util.ArrayList;


public class Cliente {

    private String nome;
    private String cpf;
    private long pontuacao;
    /** categoria é definida pela pontuacao */
    private ICategoria categoria;
    /** lista de pedidos que o cliente ja adquiriu na agencia*/
    private ArrayList<Produto> produtos;

    public Cliente(String nome, String cpf){
        this.nome=nome;
        this.cpf=cpf;
        this.pontuacao=0;
        this.categoria=null;
    }

    /**
     * verifica se o destino escolhido consta na lista de ofertas da agencia.
     * se constar, adiciona o produto da agencia na lista de produto do cliente. 
     * se nao constar, cria um novo produto e adiciona na lista do cliente.
     * sempre que incluir um novo produto a pontuacao sera atualizada e a categoria verificada
     * 
     * @param destino localidade escolhida pelo cliente como destino
     * @throws ParseException
     *
     */
    public void adicionarProduto(String destino,String opcao) {
        try {
            if (destino == null || destino.equals("")) {
                System.out.println("Destino informado invalido!");
                return;
            }
            if(this.produtos==null)
                this.produtos=new ArrayList<>();

           Produto escolha = Agencia.localizarProduto(destino,opcao);

            if (escolha != null) {
                this.produtos.add(escolha);
                this.agregarPontuacao(escolha);
            } else {
                escolha = Agencia.personalizaProduto(destino,opcao);
                if (escolha != null) {
                    this.produtos.add(escolha);
                    this.agregarPontuacao(escolha);
                }
            }
            System.out.println("Destino " + destino + " incluído");
            this.mudarCategoria();
        } catch (Exception exception) {
            System.out.println("Erro ao adicionar produto ao cliente: " + exception);
        }
    }
    
    /** atualiza a pontuacao sempre que for adicionado um produto na lista do cliente*/
    public void agregarPontuacao(Produto p) {
        try {
            if (p == null) {
                System.out.println("Pontuaço nao foi agregada. Produto informado invalido!");
                return;
            }

            int aux = p.calcularPontuacao();

            if(this.categoria != null){
                this.pontuacao += this.categoria.calcularPontuacao(aux);
                return;
            }

            this.pontuacao += aux;
        } catch (Exception exception) {
            System.out.println("Erro ao agregar pontuação ao cliente: " + exception);
        }
    }

    /** verifica em qual categoria a pontuacao do cliente o enquadra*/
    public void mudarCategoria() {
        try {
            if(this.pontuacao >= Bronze.getPontuacaoMinima() && this.pontuacao < Prata.getPontuacaoMinima()) {
                this.categoria = (ICategoria) new Bronze();
                System.out.println("O cliente " + this.nome + " subiu de categoria. Categoria atual: Bronze");
                return;
            }

            if(this.pontuacao >= Prata.getPontuacaoMinima() && this.pontuacao < Ouro.getPontuacaoMinima()) {
                this.categoria = (ICategoria) new Prata();
                System.out.println("O cliente " + this.nome + " subiu de categoria. Categoria atual: Prata");
                return;
            }

            if(this.pontuacao >= Ouro.getPontuacaoMinima()) {
                this.categoria = (ICategoria) new Ouro();
                System.out.println("O cliente " + this.nome + " subiu de categoria. Categoria atual: Ouro");
            }
        } catch (Exception exception) {
            System.out.println("Erro ao verificar/modificar categoria. Cliente " + this.nome + " - Pontuação atual: " + this.pontuacao);
        }
    }

    public String toString() {
        return "Nome: " + this.nome + " | CPF: " + this.cpf + " | Pontuação: " + this.pontuacao +
                " | Categoria: " + this.categoria;
    }

    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ICategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ICategoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
