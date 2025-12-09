package br.com.locadora.model;

import java.time.LocalDate;
import java.time.Period;

/** Por enquanto fiz os atributos e apliquei o encapsulamento
 *  Ainda não realizei testes então é possível haver erros
*/
public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private boolean ativo; // Para identificar se o cliente está disponível

    public Cliente(String nome, String cpf, LocalDate dataNascimento, String email){
        // Verificação para o cliente se cadastrar apenas se for mais de idade
        LocalDate dataMinima = LocalDate.now().minusYears(18);

        if (dataNascimento.isAfter(dataMinima)) {
            // o "throw" é para mostar que há uma exceção, um aviso que pode estar sendo gerado um exceção do tipo IllegalArgumentException
            throw new IllegalArgumentException("Cliente deve ter 18 anos ou mais para realizar o cadastro");
        }
        
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.ativo = true;
    }

    // GETTERS
    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }
    public int getIdade(){
        // Aqui ele está fazendo o calculo da diferença entre a data de nascimento e a data atualmente para assim ter a idade do cliente
        Period periodo = Period.between(this.dataNascimento, LocalDate.now());
        return periodo.getYears();
    }

    public String getEmail(){
        return email;
    }

    public boolean isAtivo(){
        return ativo;
    }

    // SETTERS
    public void setNome(String novoNome){
        if (novoNome != null && !novoNome.trim().isEmpty()){
            this.nome = novoNome;
        } else {
        throw new IllegalArgumentException("Nome não pode ser vazio."); 
        }
    }
    
    //fatal o set cpf
    
    public void setEmail(String novoEmail){
        if (novoEmail != null && novoEmail.contains("@")){
            this.email = novoEmail;   
        }else{
            throw new IllegalArgumentException("E-mail inválido."); 
        }
    }

    public void setDataNascimento(LocalDate novaData){
        LocalDate dataMinima = LocalDate.now().minusYears(18);

        if (novaData.isAfter(dataMinima)) {
            throw new IllegalArgumentException("A nova Data de Nacimento torna o cliente menor de 18 anos");
        }

        this.dataNascimento = novaData;
    }

    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
}