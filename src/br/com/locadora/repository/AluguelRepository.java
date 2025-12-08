package br.com.locadora.repository;

import br.com.locadora.model.Aluguel;
import java.util.List;

public interface AluguelRepository {

    void salvar(Aluguel aluguel);
    List<Aluguel> listarTodos();
    List<Aluguel> listarPorCliente(String cpfCliente);
}
