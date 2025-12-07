package br.com.locadora.service;

import br.com.locadora.model.Cliente;
import br.com.locadora.interfaces.ICliente;
import java.time.LocalDate;
import java.util.List;

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

        Cliente cliente = new Cliente(nome, cpf, email);
        cliente.setDataDeNascimento(data);
        ClienteRepository.criarCliente(cliente);
    }

    // Atualizar cliente
    public void atualizarCliente(String cpf, String novoNome, String novoEmail, LocalDate novaData, Boolean ativo) {
        Cliente cliente = ClienteRepository.buscarCpf(cpf);
        
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        // Atulizar nome, email, data de nascimento e status
        if (novoNome != null) cliente.setNome(novoNome);
        if (novoEmail != null) cliente.setEmail(novoEmail);
        if (novaData != null) cliente.setDataDeNascimento(novaData);
        if (ativo != null) cliente.setAtivo(ativo);

        ClienteRepository.atualizar(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) {
        return ClienteRepository.buscarCpf(cpf);
    }

    public List<Cliente> buscarTodosClientes() {
        return ClienteRepository.buscarTodos();
    }

    public void deletarCliente(String cpf) {
        Cliente c = ClienteRepository.buscarCpf(cpf);
        if (c == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        ClienteRepository.deletarCliente(cpf);
    }

    private int calcularIdade(LocalDate dataNascimento){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}