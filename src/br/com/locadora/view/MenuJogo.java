package br.com.locadora.view;

import br.com.locadora.model.*;
import br.com.locadora.service.JogoService;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.LocadoraService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class MenuJogo {
     private Scanner input;
     private JogoService jogoService;
     private ClienteService clienteService;
     private LocadoraService locadoraService;

    public MenuJogo(JogoService jogoService, ClienteService clienteService, LocadoraService locadoraService) {
        this.input = new Scanner(System.in);
        this.jogoService = jogoService;
        this.clienteService = clienteService;
        this.locadoraService = locadoraService;
    }
    
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n==== MENU JOGO ====");
            System.out.println("1. Cadastrar Jogo");
            System.out.println("2. Listar Jogos");
            System.out.println("3. Buscar Jogo por ID");
            System.out.println("4. Alugar Jogo");
            System.out.println("5. Listar Aluguéis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1 -> cadastrarJogo();
                case 2 -> listarJogos();
                case 3 -> buscarPorId();
                case 4 -> alugarJogo();
                case 5 -> listarAlugueis();
                case 0 -> System.out.println("Saindo do menu jogo.");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
    
}