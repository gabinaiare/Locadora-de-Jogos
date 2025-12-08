package br.com.locadora.model;

public abstract class Jogo {
    private int id;
    private String nome;
    private int anoLancamento;
    private int classificacao;
    private String descricao;
    private String tipo;
    private float valorBase;
    private Plataforma plataforma;

    // public abstract void CalcularValorAluguel(Aluguel aluguel);
    public abstract double CalcularValorAluguel(Aluguel aluguel); // Mudar de 'void' para 'double'

    public Jogo(String nome, int anoLancamento, int classificacao, String descricao, String tipo, float valorBase,
            int id, Plataforma plataforma) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valorBase = valorBase;
        this.id = id;
        this.plataforma = plataforma;

    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public String toString() {
        return "\nId: " + id +
                "\nNome: " + nome +
                "\nAno de lançamento: " + anoLancamento +
                "\nPlataforma: " + plataforma +
                "\nClassificação: " + classificacao +
                "\nDescrição: " + descricao +
                "\nTipo: " + tipo +
                "\nValor base: " + valorBase;
    }
}
