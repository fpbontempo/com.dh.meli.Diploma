package com.dh.meli.diploma.entity;

import javax.validation.constraints.*;

public class Disciplina {
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50, message = "tamanho para um nome/descricao é no minimo 8")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Deve conter apenas letras")
    private String descricao;

    @NotNull(message = "nota da disciplina é obrigatória")
    @Max(value = 10, message = "Nota não pode ser maior que 10")
    @Min(value = 0, message = "Nota não pode ser menor que 0")
    @Digits(integer = 2, fraction = 2, message = "Nota não válida. Aceito apenas de 0 a 10, com 2 dígitos decimais")
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
