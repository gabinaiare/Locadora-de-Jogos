package br.com.locadora.model;

public class JogoDigital extends Jogo {
    private String plataforma;
    private double tamanhoArquivo; 

    public JogoDigital(String nome,int anoLancamento,int classificacao,String descricao,String tipo,float valorBase, String plataforma, double tamanhoArquivo) {
        super(nome,anoLancamento,classificacao,descricao,tipo,valorBase);
        this.plataforma = plataforma;
        this.tamanhoArquivo = tamanhoArquivo;
    }

}
