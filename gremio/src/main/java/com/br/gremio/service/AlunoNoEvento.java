package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import com.br.gremio.models.Chamada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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

    @RequestMapping(value="/AlunoNoEvento", method= RequestMethod.POST)
    @ResponseBody
    public String AlunoNoEvento(@RequestBody Chamada chamada){
        TbAluno aluno = alunoService.getOne(chamada.getId_aluno());
        TbEventos evento = eventoService.getOne(chamada.getId_evento());

        evento.inserirAluno(aluno);
        aluno.inserirEvento(evento);
        
        eventoService.save(evento);
        alunoService.save(aluno);
        return "Ok";
    }
}
