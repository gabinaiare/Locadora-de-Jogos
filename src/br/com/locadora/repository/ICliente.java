package br.com.locadora.repository;

import br.com.locadora.model.Cliente;
import java.util.List;

public interface ICliente {
    void criarCliente (Cliente cliente);
    Cliente buscarCpf(String cpf);
    List<Cliente> buscarTodos();
    void atualizar(Cliente cliente);
    void deletarCliente(String cpf);
}
