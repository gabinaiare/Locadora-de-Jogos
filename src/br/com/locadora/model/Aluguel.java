package br.com.locadora.model;

import java.time.LocalDate;
import java.util.List;

public class Aluguel {
    private Cliente cliente;
    private List<Jogo> jogos;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private Double valorTotal;
    
    public Aluguel (Cliente cliente, List<Jogo> jogos, LocalDate dataAluguel, LocalDate dataDevolucao){
        if (cliente == null) {
                throw new IllegalArgumentException("Cliente não pode ser nulo!");
            }
            if (jogos == null || jogos.isEmpty()) {
                throw new IllegalArgumentException("Deve haver pelo menos um jogo no aluguel.");
            }
            if (dataAluguel == null || dataDevolucao == null) {
                throw new IllegalArgumentException("Datas de aluguel e devolução não podem ser nulas!");
            }
            if (dataDevolucao.isBefore(dataAluguel)) {
                throw new IllegalArgumentException("Data de devolução não pode ser antes da data de aluguel.");
            }
        }
}
