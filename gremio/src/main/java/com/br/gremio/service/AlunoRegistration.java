package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.models.Aluno;
import com.br.gremio.repository.AlunoRepository;
import com.br.gremio.repository.SalaRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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

}
