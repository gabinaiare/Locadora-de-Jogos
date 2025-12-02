package br.com.locadora.model;

import java.time.temporal.ChronoUnit;

public class JogoFisico extends Jogo {

    public String estado;

    public JogoFisico(String nome, int anoLancamento, int classificacao, String descricao, String tipo, float valorBase, String estado){
        super(nome, anoLancamento, classificacao, descricao, tipo, valorBase);
        this.estado = estado;
    }

    @Override
    public double CalcularValorAluguel(Aluguel aluguel){
        long dias = ChronoUnit.DAYS.between(aluguel.getDataAluguel(), aluguel.getDataDevolucao());
        
        double valorDia = 5.0; 
        
        System.out.print("Valor final: " + dias * valorDia);
    }

    @Override
    public String toString(){
        return super.toString() + "\nEstado: " + estado;
    }

}
