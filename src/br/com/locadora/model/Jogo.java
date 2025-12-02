package br.com.locadora.model;

public abstract class Jogo {
    private String nome;
    private int anoLancamento;
    private int classificacao;
    private String descricao;
    private String tipo;
    private float valorBase;

    public abstract void CalcularValorAluguel(Aluguel aluguel);

    public Jogo(String nome, int anoLancamento, int classificacao, String descricao, String tipo, float valorBase){
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valorBase = valorBase;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setValorBase(float valorBase) {
        this.valorBase = valorBase;
    }

    public float getValorBase() {
        return valorBase;
    }
    
}
