package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class AlunoEvento {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value="/AlunoEvento", method=RequestMethod.POST)
    @ResponseBody
    public String setEvento(@RequestBody long id_evento, @RequestBody long id_aluno){
        TbAluno aluno = alunoService.getOne(id_aluno);
        TbEventos evento = eventoService.getOne(id_evento);

        evento.inserirAluno(aluno);
        aluno.inserirEvento(evento);

        eventoService.save(evento);
        alunoService.save(aluno);
        return "Ok";
    }
}
