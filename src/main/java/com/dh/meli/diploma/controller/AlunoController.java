package com.dh.meli.diploma.controller;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping("/cadastra")
    public Aluno cadastrarAluno(@RequestBody Aluno aluno){
        alunoService.adicionaAluno(aluno);
        return aluno;
    }

    @GetMapping("/exibirAlunos")
    public List<Aluno> exibirAlunos(){
        return alunoService.getListaAlunos();
    }

    @GetMapping("/exibirAluno/{nome}")
    public Aluno exibirAluno(@PathVariable String nome){
        return alunoService.getAluno(nome);
    }

    @GetMapping("/exibirAlunoComMedia/{nome}")
    public String exibirAlunoComMedia(@PathVariable String nome){
        return alunoService.getAlunoComMedia(nome);
    }

    @PutMapping("/alterarAluno")
    public Aluno alteraAluno(@RequestBody Aluno aluno){
        return alunoService.alterarAluno(aluno);
    }

    @DeleteMapping("/removerAluno")
    public String removeAluno(@RequestBody Aluno aluno){
        return alunoService.removerAluno(aluno);
    }

}
