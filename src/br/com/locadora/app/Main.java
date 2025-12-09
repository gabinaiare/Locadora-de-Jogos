package br.com.locadora.app;

import br.com.locadora.repository.AluguelRepoMemory;
import br.com.locadora.repository.ClienteRepository;
import br.com.locadora.repository.JogoRepoMemory;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.JogoService;
import br.com.locadora.service.LocadoraService;
import br.com.locadora.view.MenuCliente;
import br.com.locadora.view.MenuJogo;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Repositórios
        ClienteRepository clienteRepo = new ClienteRepository();
        JogoRepoMemory jogoRepo = new JogoRepoMemory();
        AluguelRepoMemory aluguelRepo = new AluguelRepoMemory();

        // Serviços
        ClienteService clienteService = new ClienteService(clienteRepo);
        JogoService jogoService = new JogoService(jogoRepo);
        LocadoraService locadoraService = new LocadoraService(aluguelRepo);

        // Menus
        MenuCliente menuCliente = new MenuCliente(clienteService);
        MenuJogo menuJogo = new MenuJogo(jogoService, clienteService, locadoraService);

        int opcao;
        do {
            System.out.println("\n===== LOCADORA DE JOGOS =====");
            System.out.println("1. Menu Cliente");
            System.out.println("2. Menu Jogo");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> menuCliente.exibirMenu();
                case 2 -> menuJogo.exibirMenu();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}