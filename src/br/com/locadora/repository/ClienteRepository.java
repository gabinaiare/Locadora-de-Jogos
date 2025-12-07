package br.com.locadora.repository;

import br.com.locadora.model.Cliente;
import br.com.locadora.interface.ICliente;

import java.util.ArrayList;
import java.util.List;

/** Responsável por salvar, buscar e remover da lista
 *  implementando os métodos de ICliente
*/
public class ClienteRepository implements ICliente {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void criarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarCpf (String cpf){
        for(Cliente c : clientes){
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodos(){
        return new ArrayList<>(clientes);
    }

    @Override
    public void deletarCliente(String cpf){
        clientes.removeIf(c -> c.getCpf().equals(cpf));
    }
}