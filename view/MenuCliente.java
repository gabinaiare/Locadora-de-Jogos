package br.com.locadora.view;

import br.com.locadora.model.Cliente;
import br.com.locadora.service.ClienteService;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuCliente{
    private Scanner sc;
    private ClienteService service;

    public MenuCliente(ClienteService service) {
        this.sc = new Scanner(System.in);
        this.service = service;
    }

    public void exibirMenu(){
        int opcao;

        do{
            System.out.println("==== MENU CLIENTE ====");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Buscar Cliente por CPF");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Deletar Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1 -> criarCliente();
                case 2 -> listarClientes();
                case 3 -> buscarClientePorCpf();
                case 4 -> atualizarCliente();
                case 5 -> deletarCliente();
                case 0 -> System.out.println("Saindo do menu cliente.");
                default -> System.out.println("Opção inválida. Tente novamente.\n");
            }
        } while (opcao != 0);
    }