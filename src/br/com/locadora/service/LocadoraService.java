package br.com.locadora.service;

import br.com.locadora.model.Aluguel;
import java.util.ArrayList;
import java.util.List;

public class LocadoraService {
    private static final List<Aluguel> LISTA_ALUGUEIS = new ArrayList<>();

    public Aluguel realizarAluguel(Aluguel novoAluguel) {
        if (novoAluguel == null) {
            throw new IllegalArgumentException("O aluguel não pode ser nulo.");
        }
        
        LISTA_ALUGUEIS.add(novoAluguel);
        System.out.println("Aluguel realizado com sucesso para o cliente: " + novoAluguel.getCliente().getNome());
        return novoAluguel;
    }

    public List<Aluguel> listarAlugueis() {
        if (LISTA_ALUGUEIS.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.");
        }
        return LISTA_ALUGUEIS;
    }

}
