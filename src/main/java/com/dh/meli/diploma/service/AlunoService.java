package com.dh.meli.diploma.service;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.entity.Disciplina;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {
    List<Aluno> listaAlunos = new ArrayList<>();

    public Aluno adicionaAluno(Aluno aluno){
        listaAlunos.add(aluno);
        return aluno;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public Aluno getAluno(String nome){
        for (Aluno aluno: listaAlunos){
            if(aluno.getNome().equals(nome)){
                return aluno;
            }
        }
        return null;
    }

    public String getAlunoComMedia(String nome){
        double media = 0;
        Aluno aluno = getAluno(nome);
        for (Disciplina disciplina: aluno.getListaDisciplinas()){
            media += disciplina.getNota();
        }
        return aluno.toString() + "\nMédia"+ media/aluno.getListaDisciplinas().size();
    }

    public Aluno alterarAluno(Aluno aluno){
        for (Aluno al: listaAlunos){
            if(al.getNome().equals(aluno.getNome())){
                listaAlunos.set(listaAlunos.indexOf(al), aluno);
                return aluno;
            }
        }
        return null;
    }

    public String removerAluno(Aluno aluno){
        for (Aluno al: listaAlunos){
            if(al.getNome().equals(aluno.getNome())){
                listaAlunos.remove(al);
                return "ALUNO REMOVIDO\n\n" + al.toString();
            }
        }
        return "Aluno não encontrado!!!";
    }


}
