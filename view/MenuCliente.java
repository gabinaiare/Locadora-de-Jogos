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
    public void criarCliente() {
      try{
        System.out.println("\n==== Criar Cliente ====");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Data de Nascimento (YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(sc.nextLine());

        service.criarCliente(nome, cpf, data, email);
        System.out.println("Cliente criado com sucesso!\n");
      } catch (Exception e){
        System.out.println("Erro ao criar cliente: " + e.getMessage() + "\n");
      }
    }

    private void listarClientes() {
        System.out.println("\n==== Lista de Clientes ====");
        List<Cliente> clientes = service.buscarTodosClientes();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.\n");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println("Nome: " + c.getNome() + "| CPF: " + c.getCpf());
        }
        System.out.println();
    }
}