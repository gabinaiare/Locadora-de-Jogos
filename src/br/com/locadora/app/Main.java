package br.com.locadora.app;

import br.com.locadora.service.LocadoraService;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.JogoDigital;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.Jogo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocadoraService service = new LocadoraService();
     
        Cliente cli1 = new Cliente("Maria Silva", "123.456.789-00", LocalDate.of(1990, 5, 10), "maria@email.com");
        Jogo jogoD1 = new JogoDigital("Cyberpunk", 2020, 18, "RPG futurista", "Digital", 10.0f, "PC", 70.0,2);
        
        List<Jogo> listaJogos = Arrays.asList(jogoD1);
        
        try {
            LocalDate dataAluguel = LocalDate.now();
            LocalDate dataDevolucao = dataAluguel.plusDays(3);
            
            Aluguel aluguel1 = new Aluguel(cli1, listaJogos, dataAluguel, dataDevolucao);
            service.realizarAluguel(aluguel1);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao realizar aluguel: " + e.getMessage());
        }
        
        System.out.println("---");
        List<Aluguel> alugueisRegistrados = service.listarAlugueis();
        for (Aluguel a : alugueisRegistrados) {
            System.out.println("Cliente: " + a.getCliente().getNome());
            System.out.println("Valor Total Estimado: R$ " + a.getValorTotal());
            System.out.println("  Jogos Alugados:");

            for (Jogo jogo : a.getJogos()) { 
                System.out.println("  - " + jogo.getNome() + " (" + jogo.getTipo() + ")");
            }
            
            System.out.println("----------------------");
        }
    }
}