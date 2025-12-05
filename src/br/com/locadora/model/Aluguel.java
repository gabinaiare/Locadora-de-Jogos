package br.com.locadora.model;

import java.time.LocalDate;
import java.util.List;

public class Aluguel {
    private Cliente cliente;
    private List<Jogo> jogos;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private Double valorTotal;

    public Aluguel(Cliente cliente, List<Jogo> jogos, LocalDate dataAluguel, LocalDate dataDevolucao) {
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

        this.cliente = cliente;
        this.jogos = jogos;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.valorTotal = 0.0;

        recalcularValorTotal();
    }

    // Getters. Só pegam valores, não alteram nada

    public Cliente getCliente() {
        return cliente;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
    
    public void setDataDevolucao(LocalDate novaDataDevolucao) {
        if (novaDataDevolucao == null) {
            throw new IllegalArgumentException("A data de devolução não pode ser nula.");
        }
        if (novaDataDevolucao.isBefore(dataAluguel)) {
            throw new IllegalArgumentException("A nova data de devolução não pode ser antes da data do aluguel.");
        }

        this.dataDevolucao = novaDataDevolucao;
        recalcularValorTotal();
    }

    public void recalcularValorTotal() {
        double total = 0.0;
        for (Jogo jogo : jogos) {
            // Chama o método que agora retorna um valor double
            total += jogo.CalcularValorAluguel(this);
        }
        this.valorTotal = total;
    }
}
