package br.com.locadora.service;

import br.com.locadora.model.Cliente;
import br.com.locadora.interfaces.ICliente;
import java.time.LocalDate;
import java.util.List;
import java.time.Period;

public class ClienteService {
    private final ICliente ClienteRepository;

    public ClienteService(ICliente ClienteRepository) {
        this.ClienteRepository = ClienteRepository;
    }

    // Criar cliente com validações
    public void criarCliente(String nome, String cpf, LocalDate data, String email) {
        
        // Impedir CPF duplicado
        if (ClienteRepository.buscarCpf(cpf) != null) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        // Validar idade mínima de 18 anos
        if (calcularIdade(data) < 18) {
            throw new IllegalArgumentException("Cliente deve ter pelo menos 18 anos.");
        }

        // Validar email
        if (email == null || !email.contains("@")){
            throw new IllegalArgumentException("Email inválido.");
        }

        Cliente cliente = new Cliente(nome, cpf, data, email);
        ClienteRepository.criarCliente(cliente);
    }

    // Atualizar cliente
    public void atualizarCliente(String cpf, String novoNome, String novoEmail, LocalDate novaData, Boolean ativo) {
        Cliente cliente = ClienteRepository.buscarCpf(cpf);
        
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        // Atualizar nome, email, data de nascimento e status
        if (novoNome != null) cliente.setNome(novoNome);
        if (novoEmail != null) cliente.setEmail(novoEmail);
        if (novaData != null) cliente.setDataNascimento(novaData);
        if (ativo != null) cliente.setAtivo(ativo);
    }

    // Buscar cliente por CPF
    public Cliente buscarClientePorCpf(String cpf) {
        return ClienteRepository.buscarCpf(cpf);
    }

    // Buscar todos os clientes
    public List<Cliente> buscarTodosClientes() {
        return ClienteRepository.buscarTodos();
    }

    // Deletar cliente
    public void deletarCliente(String cpf) {
        Cliente c = ClienteRepository.buscarCpf(cpf);
        if (c == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        ClienteRepository.deletarCliente(cpf);
    }

    // Calcular idade
    private int calcularIdade(LocalDate dataNascimento){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}