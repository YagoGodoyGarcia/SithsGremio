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

@Controller
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
    	}else {
    		return "evento ou aluno invalido!";
    	}    	
    }

    @RequestMapping(value = "/EventosAluno", method = RequestMethod.GET, produces = "application/json")
    public String pegarEvento(@RequestParam Long id_aluno){
        List<TbEventos> eventoP = eventoRepository.eventoOneAluno(id_aluno);
        Gson g = new Gson();
        if(eventoP != null) {
            return g.toJson(eventoP);
        }
        return "Não Existe fdp!";
    }
}
