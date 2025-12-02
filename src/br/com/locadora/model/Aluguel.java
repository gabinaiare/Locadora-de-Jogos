package br.com.locadora.model;

import java.time.LocalDate;
import java.util.List;

public class Aluguel {
    private Cliente cliente;
    private List<Jogo> jogos;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private Double valorTotal;
}
