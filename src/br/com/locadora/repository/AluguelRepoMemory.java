package br.com.locadora.repository;

import br.com.locadora.interfaces.IAluguel;
import br.com.locadora.model.Aluguel;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepoMemory implements IAluguel{

    private static final List<Aluguel> ALUGUEIS = new ArrayList<>();

    @Override
    public void salvar(Aluguel aluguel) {
        if (aluguel == null) {
            throw new IllegalArgumentException("O aluguel não pode ser nulo.");
        }
        ALUGUEIS.add(aluguel);
    }

    @Override
    public List<Aluguel> listarTodos() {
        return new ArrayList<>(ALUGUEIS); 
    }

    @Override
    public List<Aluguel> listarPorCliente(String cpfCliente) {
        List<Aluguel> resultado = new ArrayList<>();

        for (Aluguel aluguel : ALUGUEIS) {
            if (aluguel.getCliente().getCpf().equals(cpfCliente)) {
                resultado.add(aluguel);
            }
        }

        return resultado;
    }
}