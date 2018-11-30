package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import com.br.gremio.models.Aluno;
import com.br.gremio.models.SenhaModel;
import com.br.gremio.repository.AlunoRepository;
import com.br.gremio.repository.SalaRepository;
import com.google.gson.Gson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoRegistration {

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping(value="/AlunoRegistration", method= RequestMethod.POST)
    @ResponseBody
    public String RegistrarAluno(@RequestBody Aluno alunoModel){
        TbAluno aluno = new TbAluno();
        Gson g = new Gson();
        aluno.setNome(alunoModel.getNome());
        aluno.setRa(alunoModel.getRa());
        aluno.setEmail(alunoModel.getEmail());
        aluno.setSenha(alunoModel.getSenha());
        aluno.setNivelPermissao(alunoModel.getNivelPermissao());

        alunoRepository.save(aluno);

        return "Ok";
    }
    @RequestMapping(value="/alterarSenha", method= RequestMethod.POST)
    @ResponseBody
    public String RegistrarAluno(@RequestBody SenhaModel senha){
    	Gson g = new Gson();
        TbAluno aluno = alunoService.getOne(senha.getId_aluno());
        System.out.println(g.toJson(aluno));
        if(aluno != null) {
	        aluno.setSenha(senha.getSenha());
	        alunoService.save(aluno);
	        return "Ok";
        }
        return null;
    }
    @Autowired
    private AlunoService alunoService;
    @RequestMapping(value="/ListaAluno", method= RequestMethod.GET,  produces = "application/json")
    @ResponseBody
    public String ListaAlunos(){
    	List<TbAluno> list = alunoService.findAll();
        Gson g = new Gson();
        return g.toJson(list);
    }

}
