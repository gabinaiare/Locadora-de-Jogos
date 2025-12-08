package br.com.locadora.service;

import br.com.locadora.model.Aluguel;
import br.com.locadora.repository.AluguelRepository;
import java.util.List;

public class LocadoraService {

    private final AluguelRepository aluguelRepository;

    public LocadoraService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public Aluguel realizarAluguel(Aluguel novoAluguel) {
        if (novoAluguel == null) {
            throw new IllegalArgumentException("O aluguel não pode ser nulo.");
        }

        aluguelRepository.salvar(novoAluguel);

        System.out.println("Aluguel realizado com sucesso para o cliente: "
                + novoAluguel.getCliente().getNome());

        return novoAluguel;
    }

    public List<Aluguel> listarAlugueis() {
        List<Aluguel> alugueis = aluguelRepository.listarTodos();

        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.");
        }

        return alugueis;
    }

    public List<Aluguel> listarPorCliente(String cpf) {
        return aluguelRepository.listarPorCliente(cpf);
    }

}
