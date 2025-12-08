package br.com.locadora.service;

import br.com.locadora.interfaces.IJogo;
import br.com.locadora.model.*;

import java.util.ArrayList;
import java.util.List;

public class JogoService {
     private final IJogo jogoRepository;
     private final List<Aluguel> alugueis = new ArrayList<>();

    public JogoService(IJogo jogoRepository) {
        this.jogoRepository = jogoRepository;
    }

    
    public void salvar(Jogo jogo) {
        jogoRepository.salvar(jogo);
    }  

   
}
