package com.dh.meli.diploma.entity;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Aluno{

    @NotEmpty
    @Size(min = 8, max = 50, message = "tamanho para um nome é no minimo 8")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Deve conter apenas letras")
    private String nome;
    private String endereco;
    private int idade;

    @NotEmpty
    @Size(min = 3, message = "Um aluno precisa estar em no minimo 3 disciplinas")
    @Valid
    private List<Disciplina> listaDisciplinas;

    public Aluno(String nome, String endereco, int idade, List<Disciplina> listaDisciplinas) {
        this.nome = nome;
        this.endereco = endereco;
        this.idade = idade;
        this.listaDisciplinas = listaDisciplinas;
    }

    public  Aluno(Aluno aluno){
        this.nome = aluno.getNome();
        this.endereco = aluno.getEndereco();
        this.idade = aluno.getIdade();
        this.listaDisciplinas = aluno.getListaDisciplinas();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", idade=" + idade +
                ", listaDisciplinas=" + listaDisciplinas +
                '}';
    }
}
