package br.com.locadora.model;

import java.time.temporal.ChronoUnit;

public class JogoFisico extends Jogo {

    private String estado;

    public JogoFisico(String nome, int anoLancamento, int classificacao, String descricao, String tipo, float valorBase, String estado, int id){
        super(nome, anoLancamento, classificacao, descricao, tipo, valorBase,id);
        this.estado = estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public double CalcularValorAluguel(Aluguel aluguel){
        long dias = ChronoUnit.DAYS.between(aluguel.getDataAluguel(), aluguel.getDataDevolucao());
        
        double valorDia = 5.0; 
        
        return valorDia * dias;
    }

    @Override
    public String toString(){
        return super.toString() + "\nEstado: " + estado;
    }

}
