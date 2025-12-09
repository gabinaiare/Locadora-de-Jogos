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
     public Jogo buscarPorId(int id) {
        return jogoRepository.buscarPorId(id);
    }

    public List<Jogo> listarJogos() {
        return jogoRepository.buscarTodos();
    }

   
    public void deletarJogo(int id) {
        if (jogoRepository.buscarPorId(id) == null) {
            throw new IllegalArgumentException("Jogo não encontrado!");
        }
        jogoRepository.remover(id);
    }

    public List<Jogo> buscarPorNome(String nome) {
        return jogoRepository.buscarPorNome(nome);
    }

   
    public List<Jogo> buscarPorPlataforma(Plataforma plataforma) {
        return jogoRepository.buscarPorPlataforma(plataforma);
    }

   
    public void registrarAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public List<Aluguel> listarAlugueis() {
        return alugueis;
    }

   
}