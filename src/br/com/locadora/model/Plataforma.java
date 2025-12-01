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

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getFabricante() {
        return fabricante;
    }

    // Setters
    public void setId(int id){
        if (id <=0 ){
            throw new IllegalArgumentException("O ID deve ser maior que zero.");
        }
    }

    public void setNome(String nome){
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome da plataforma não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setFabricante(String fabricante){
        if (fabricante == null || fabricante.trim().isEmpty()){
            throw new IllegalArgumentException("O nome do fabricante não pode ser vazio.");
        }
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return id + " - " + nome + " (" + fabricante + ")";
    }
}