package br.com.locadora.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.locadora.interfaces.IJogo;
import br.com.locadora.model.Plataforma;
import br.com.locadora.model.JogoFisico;
import br.com.locadora.model.Jogo;
import br.com.locadora.model.JogoDigital;

public class JogoRepoMemory implements IJogo {
    private List<Jogo> jogos = new ArrayList<>();
    private int prox = 1;

    @Override
    public void salvar(Jogo jogo) {
        if (jogo.getId() == 0) {
            // cadastrar um novo jogo
            jogo.setId(prox++);
            jogos.add(jogo);
        } else {
            // caso o id for diferente de 0, ou seja, ja exista
            // atualizar jogo ja existente
            for (int i = 0; i < jogos.size(); i++) {
                if (jogos.get(i).getId() == jogo.getId()) {
                    jogos.set(i, jogo);
                    return;
                }
            }
            jogos.add(jogo);

        }
    }

    @Override
    public Jogo buscarPorId(int id) {
        for (Jogo j : jogos) {
            if (j.getId() == id) {
                return j;
            }
        }
        return null;
    }

    @Override
    public List<Jogo> buscarTodos() {
        return new ArrayList<>(jogos);
    }

    @Override
    public void remover(int id) {
        Jogo jogoParaRemover = null;

        for (Jogo j : jogos) {
            if (j.getId() == id) {
                jogoParaRemover = j;
                break;
            }
        }

        if (jogoParaRemover != null) {
            jogos.remove(jogoParaRemover);
        }
    }

    @Override
    public List<Jogo> buscarPorNome(String nome) {
        List<Jogo> resultado = new ArrayList<>();

        for (Jogo j : jogos) {
            if (j.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(j);
            }
        }

        return resultado;
    }

    @Override
    public List<Jogo> buscarPorPlataforma(Plataforma plataforma) {
        List<Jogo> resultado = new ArrayList<>();

        for (Jogo j : jogos) {
            if (j.getPlataforma() == plataforma) {
                resultado.add(j);
            }
        }

        return resultado;
    }

    @Override
    public List<JogoFisico> buscarJogosFisicos() {
        List<JogoFisico> resultado = new ArrayList<>();

        for (Jogo j : jogos) {
            if (j instanceof JogoFisico) {
                resultado.add((JogoFisico) j);
            }
        }

        return resultado;
    }

    @Override
    public List<JogoDigital> buscarJogosDigitais() {
        List<JogoDigital> resultado = new ArrayList<>();

        for (Jogo j : jogos) {
            if (j instanceof JogoDigital) {
                resultado.add((JogoDigital) j);
            }
        }

        return resultado;
    }

}
