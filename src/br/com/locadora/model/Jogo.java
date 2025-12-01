package br.com.locadora.model;

public abstract class Jogo {
    private String nome;
    private int anoLancamento;
    private int classificacao;
    private String descricao;
    private String tipo;
    private float valorBase;

    public abstract void CalcularValorAluguel(Aluguel aluguel);
}
