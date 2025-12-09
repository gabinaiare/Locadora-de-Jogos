package br.com.locadora.interfaces;

import br.com.locadora.model.Jogo;
import br.com.locadora.model.JogoDigital;
import br.com.locadora.model.JogoFisico;
import br.com.locadora.model.Plataforma;
import java.util.List;

public interface IJogo {

    void salvar(Jogo jogo);
    Jogo buscarPorId(int id);
    List<Jogo> buscarTodos();
    void remover(int id);

    List<Jogo> buscarPorNome(String nome);
    List<Jogo> buscarPorPlataforma(Plataforma plataforma);

    List<JogoFisico> buscarJogosFisicos();
    List<JogoDigital> buscarJogosDigitais();
}