package br.com.locadora.model;

public class Aluguel {
    // Identificador único do aluguel
    private int id; 
    
    // Relacionamento Cliente
    private Cliente cliente; 
    
    // Relacionamento com Jogo. Pode ser uma lista se o aluguel 
    //private Jogo jogo; 
    
    
    private LocalDate dataInicio;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal; // Pode ser null se ainda não devolvido
    
    
    private double valorTotal;
    private boolean isAtivo;

    
    // Método de Negócio Exemplo:
    public boolean isAluguelAtivo() {
        // Um aluguel está ativo se a data de devolução real for nula 
        // e/ou a data prevista ainda não foi atingida.
        return dataDevolucaoReal == null;
}
