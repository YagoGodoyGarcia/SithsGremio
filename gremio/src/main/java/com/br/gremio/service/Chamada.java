package com.br.gremio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import com.br.gremio.models.Aluno;
import com.br.gremio.repository.AlunoRepository;
import com.br.gremio.repository.EventoRepository;
import com.google.gson.Gson;

@Controller
public class Chamada {
	@Autowired
    private AlunoRepository alunoRepository;
	private EventoRepository eventoRepository;

    @RequestMapping(value="/Chamada", method= RequestMethod.POST)
    @ResponseBody
    public String RegistrarAluno(@RequestBody int id_evento, @RequestBody int id_aluno){
        TbAluno aluno = new TbAluno();
        aluno = alunoRepository.findById(id_aluno);
        
        TbEventos evento = new TbEventos();
        evento = eventoRepository.findById(id_aluno);
        
        aluno.adicionarEvento(evento);        
        evento.adicionarAluno(aluno);
        eventoRepository.save(evento);
        alunoRepository.save(aluno);
        

        return "Ok";
    }
}
