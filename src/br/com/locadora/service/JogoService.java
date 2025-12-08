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

      public void criarJogo(String nome, int anoLancamento, int classificacao, String descricao,String tipo, float valorBase, Plataforma plataforma, Double tamanhoArquivo, String estadoFisico) {

        Jogo jogo;

        if (tipo.equalsIgnoreCase("Digital")) {
            if (tamanhoArquivo == null) {
                throw new IllegalArgumentException("Tamanho do arquivo obrigatório para digitais!");
            }

            jogo = new JogoDigital(nome, anoLancamento, classificacao, descricao, tipo,
                    valorBase, tamanhoArquivo, 0, plataforma);

        } else if (tipo.equalsIgnoreCase("Fisico")) {
            if (estadoFisico == null || estadoFisico.isBlank()) {
                throw new IllegalArgumentException("Estado obrigatório para jogo físico!");
            }

            jogo = new JogoFisico(nome, anoLancamento, classificacao, descricao, tipo,
                    valorBase, estadoFisico, 0, plataforma);

        } else {
            throw new IllegalArgumentException("Esse tipo não existe! Use: Digital ou Fisico");
        }

        salvar(jogo);
    }

   
}
