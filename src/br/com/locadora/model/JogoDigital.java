package br.com.locadora.model;

import java.time.temporal.ChronoUnit;

public class JogoDigital extends Jogo {
 
    private double tamanhoArquivo; 

  public JogoDigital(String nome, int anoLancamento, int classificacao, String descricao, String tipo, float valorBase, double tamanhoArquivo, int id, Plataforma plataforma) { // Argumentos ajustados
         super(nome, anoLancamento, classificacao, descricao, tipo, valorBase, id, plataforma); 
         this.tamanhoArquivo = tamanhoArquivo;
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
               "\nTamanho: " + tamanhoArquivo + " GB";
    }

}