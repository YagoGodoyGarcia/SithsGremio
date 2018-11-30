package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import com.br.gremio.models.Chamada;
import com.br.gremio.repository.AlunoRepository;
import com.br.gremio.repository.EventoRepository;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AlunoNoEvento {
    @Autowired
    private EventoService eventoService;

    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private EventoRepository eventoRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping(value="/AlunoNoEvento", method= RequestMethod.POST)
    @ResponseBody
    public String AlunoNoEvento(@RequestBody Chamada chamada){
    	TbEventos evento = eventoService.getOne(chamada.getId_evento());
    	TbAluno aluno = alunoService.getOne(chamada.getId_aluno());
    	if(evento != null && aluno != null) {
    		evento.cadastraAluno(aluno);
    		eventoRepository.save(evento);
    		return "Ok";
    	}
    	return null;
    }

    @RequestMapping(value = "/EventosAluno", method = RequestMethod.GET, produces = "application/json")
    public String pegarEvento(@RequestParam("id_aluno") long id_aluno){
        List<TbEventos> eventoP = eventoRepository.eventoPorAluno(id_aluno);
        Gson g = new Gson();
        if(eventoP != null) {
        	return g.toJson(eventoP);
        }
        return null;
    }
    @RequestMapping(value = "/EventosDisponiveisAluno", method = RequestMethod.GET, produces = "application/json")
    public String pegarEventosDisponiveis(@RequestParam("id_aluno") long id_aluno){
    	List<TbEventos> eventoNull = eventoRepository.findAll();
    	List<TbEventos> eventoP = eventoRepository.eventoDisponivelPorAluno(id_aluno);
        Gson g = new Gson();
    	for(int i = 0; i < eventoNull.size(); i++) {
    	Set<TbAluno> Alunos = eventoNull.get(i).getAlunos();
    		if(Alunos.size() == 0 ) {
    			eventoP.add(eventoNull.get(i));
    		}
    	}
        if(eventoP != null) {
        	return g.toJson(eventoP);
        }
        return null;
    }
    @RequestMapping(value = "/SairDoEvento", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String pegarEventosDisponiveis(@RequestBody Chamada chamada){
    	TbEventos evento = eventoService.getOne(chamada.getId_evento());
    	TbAluno aluno = alunoService.getOne(chamada.getId_aluno());
    	if(evento != null && aluno != null) {
        	eventoRepository.deletarAlunoDoEvento(chamada.getId_evento(), chamada.getId_aluno());
    	}
    	return null;
    }
}
