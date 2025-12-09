package br.com.locadora.view;

import br.com.locadora.model.*;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.JogoService;
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
            System.out.println("4. Remover Jogo por ID");
            System.out.println("5. Alugar Jogo");
            System.out.println("6. Listar Aluguéis");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1 -> cadastrarJogo();
                case 2 -> listarJogos();
                case 3 -> buscarPorId();
                case 4 -> deletarJogo();
                case 5 -> alugarJogo();
                case 6 -> listarAlugueis();
                case 0 -> System.out.println("Saindo do menu jogo.");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void cadastrarJogo() {
        try {
            System.out.println("\n==== Cadastro de Jogo ====");
            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Ano de lançamento: ");
            int ano = Integer.parseInt(input.nextLine());

            System.out.print("Classificação: ");
            int classificacao = Integer.parseInt(input.nextLine());

            System.out.print("Descrição: ");
            String descricao = input.nextLine();

            System.out.print("Valor base: ");
            float valorBase = Float.parseFloat(input.nextLine());

            System.out.print("Nome da plataforma: ");
            String platNome = input.nextLine();
            Plataforma plataforma = new Plataforma(0, platNome, "");

            System.out.print("Tipo (Fisico/Digital): ");
            String tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("fisico")) {
                System.out.print("Estado de conservação: ");
                String estado = input.nextLine();
                jogoService.criarJogo(nome, ano, classificacao, descricao, tipo, valorBase, plataforma, null, estado);
            } else {
                System.out.print("Tamanho do download (GB): ");
                double tamanho = Double.parseDouble(input.nextLine());
                jogoService.criarJogo(nome, ano, classificacao, descricao, tipo, valorBase, plataforma, tamanho, null);
            }

            System.out.println("Jogo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o jogo: " + e.getMessage());
        }
    }

    private void listarJogos() {
        System.out.println("\n==== Lista de Jogos ====");
        List<Jogo> jogos = jogoService.listarJogos();

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.\n");
            return;
        }

        jogos.forEach(System.out::println);
    }

    private void buscarPorId() {
        try {
            System.out.println("\n==== Buscar Jogo ====");
            System.out.print("ID: ");
            int id = Integer.parseInt(input.nextLine());

            Jogo jogo = jogoService.buscarPorId(id);

            if (jogo == null)
                System.out.println("Jogo não encontrado.");
            else
                System.out.println("\n" + jogo + "\n");

        } catch (Exception e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }

    private void deletarJogo() {
        System.out.println("\n==== Remover Jogo ====");

        try {
            System.out.print("ID do jogo: ");
            int id = Integer.parseInt(input.nextLine());

            jogoService.deletarJogo(id);

            System.out.println("Jogo removido com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("ID inválido! Digite um número inteiro.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void alugarJogo() {
        try {
            System.out.println("\n=== Alugar Jogo ===");
            System.out.print("CPF do cliente: ");
            String cpf = input.nextLine();

            Cliente cliente = clienteService.buscarClientePorCpf(cpf);
            if (cliente == null) {
                System.out.println("Cliente não encontrado!");
                return;
            }

            System.out.print("ID do jogo: ");
            int id = Integer.parseInt(input.nextLine());

            Jogo jogo = jogoService.buscarPorId(id);
            if (jogo == null) {
                System.out.println("Jogo não encontrado!");
                return;
            }

            System.out.print("Data aluguel (AAAA-MM-DD): ");
            LocalDate dtAluguel = LocalDate.parse(input.nextLine());

            System.out.print("Data devolução (AAAA-MM-DD): ");
            LocalDate dtDevolucao = LocalDate.parse(input.nextLine());

            Aluguel aluguel = new Aluguel(cliente, List.of(jogo), dtAluguel, dtDevolucao);
            locadoraService.realizarAluguel(aluguel);

            System.out.println("Valor total: R$ " + aluguel.getValorTotal());

        } catch (Exception e) {
            System.out.println("Erro ao alugar o jogo: " + e.getMessage());
        }
    }

    private void listarAlugueis() {
        System.out.println("\n=== ALUGUÉIS ===");
        List<Aluguel> alugueis = locadoraService.listarAlugueis();
        alugueis.forEach(System.out::println);
    }
}