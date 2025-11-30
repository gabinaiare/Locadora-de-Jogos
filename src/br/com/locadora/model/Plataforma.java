package br.com.locadora.model;

public class Plataforma {
    private int id;
    private String nome;
    private String fabricante;

    public Plataforma(int id, String nome, String fabricante) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getFabricante() {
        return fabricante;
    }
}
