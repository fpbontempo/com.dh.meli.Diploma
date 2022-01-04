package com.dh.meli.diploma.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Disciplina {
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50, message = "tamanho para um nome/descricao é no minimo 8")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Deve conter apenas letras")
    private String descricao;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 2, message = "minimo de 1 e máximo de 2 digitos")
    @Pattern(regexp = "^(-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*))|0?\\.0+|0$", message = "Deve conter apenas números")
    private Double nota;

    public Disciplina(String descricao, Double nota) {
        this.descricao = descricao;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "descricao='" + descricao + '\'' +
                ", nota=" + nota +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
