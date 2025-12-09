package br.com.locadora.interfaces;

import br.com.locadora.model.Aluguel;
import java.util.List;

public interface IAluguel {

    void salvar(Aluguel aluguel);
    List<Aluguel> listarTodos();
    List<Aluguel> listarPorCliente(String cpfCliente);
}