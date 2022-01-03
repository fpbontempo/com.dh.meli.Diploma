package com.dh.meli.diploma.controller;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping("/cadastra")
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody @Valid Aluno aluno, UriComponentsBuilder uriBuilder){
        alunoService.adicionaAluno(aluno);
        URI uri = uriBuilder.path("/exibirAluno/{nome}").buildAndExpand(aluno.getNome()).toUri();
        return ResponseEntity.created(uri).body(new Aluno(aluno));
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
