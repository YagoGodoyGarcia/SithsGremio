package com.br.gremio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.models.LoginModel;
import com.br.gremio.repository.AlunoRepository;
import com.google.gson.Gson;

@RestController
public class LoginService {
	
	@Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping(value="/LoginAuth", method= RequestMethod.POST)
    @ResponseBody
    public String auth(@RequestBody LoginModel login) {
    	 TbAluno aluno = alunoRepository.authLogin(login.getEmail(), login.getSenha());
    	 Gson g = new Gson();
    	 if(aluno != null) {
    		 return g.toJson(aluno);
    	 }else {
    		 return "Login Incorreto";
    	 }    	 
    }
}
