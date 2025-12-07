package br.com.locadora.interface;

import br.com.locadora.model.Cliente;
import java.util.List;

public interface ICliente {
    void criarCliente (Cliente cliente);
    Cliente buscarCpf(String cpf);
    List<Cliente> buscarTodos();
    void deletarCliente(String cpf);
}
