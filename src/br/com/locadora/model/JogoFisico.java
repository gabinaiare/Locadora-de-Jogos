package br.com.locadora.model;

public class JogoFisico extends Jogo {

    public String estado;

    public JogoFisico(String nome, int anoLancamento, int classificacao, String descricao, String tipo, float valorBase, String estado){
        super(nome, anoLancamento, classificacao, descricao, tipo, valorBase);
        this.estado = estado;
    }

    @Override
    

}
