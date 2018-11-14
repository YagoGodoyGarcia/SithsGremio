package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import com.br.gremio.models.Chamada;
import com.br.gremio.repository.EventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlunoNoEvento {
    @Autowired
    private EventoService eventoService;

    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value="/AlunoNoEvento", method= RequestMethod.POST)
    @ResponseBody
    public String AlunoNoEvento(@RequestBody Chamada chamada){
    	TbEventos evento = eventoService.getOne(chamada.getId_evento());
    	TbAluno aluno = alunoService.getOne(chamada.getId_aluno());
    	
    	if(evento != null && aluno != null) {
    		evento.cadastraAluno(aluno);
    		eventoRepository.save(evento);
    		return "Ok";
    	}else {
    		return "evento ou aluno invalido!";
    	}    	
    }
}
