package br.com.locadora.model;

import java.time.temporal.ChronoUnit;

public class JogoDigital extends Jogo {
    private String plataforma;
    private double tamanhoArquivo; 

    public JogoDigital(String nome,int anoLancamento,int classificacao,String descricao,String tipo,float valorBase, String plataforma, double tamanhoArquivo) {
        super(nome,anoLancamento,classificacao,descricao,tipo,valorBase);
        this.plataforma = plataforma;
        this.tamanhoArquivo = tamanhoArquivo;
    }
  public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(double tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    @Override
    public double CalcularValorAluguel(Aluguel aluguel) {
        long dias = ChronoUnit.DAYS.between(aluguel.getDataAluguel(), aluguel.getDataDevolucao());
        double valorDia = getValorBase(); 
        
        double valorTotal = valorDia * dias;
        double valorFinal = valorTotal * 0.85; // Aplica 15% de desconto
        
        return valorFinal;
    }
    @Override
    public String toString() {
        return super.toString() + 
               "\nPlataforma: " + plataforma +
               "\nTamanho: " + tamanhoArquivo + " GB";
    }

}
