package com.br.gremio.service;

import com.br.gremio.entity.TbEventos;
import com.br.gremio.repository.EventoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yago Garcia
 */
@RestController
public class EventoList {

    @Autowired
    private EventoService eventoService;
    @RequestMapping(value = "/ListaEvento", method = RequestMethod.GET, produces = "application/json")
    String ListarEvento(){
        List<TbEventos> list = eventoService.findAll();
        Gson g = new Gson();
        return g.toJson(list);
    }

    @RequestMapping(value = "/OneEvento", method = RequestMethod.GET, produces = "application/json")
    public String pegarEvento(@RequestParam Long id_evento){
        TbEventos eventoP = eventoService.getOne(id_evento);
        Gson g = new Gson();
        if(eventoP != null) {
            return g.toJson(eventoP);
        }
        return "Não Existe fdp!";
    }
    @Autowired
    private EventoRepository eventoRepository;
    @RequestMapping(value = "/OneEventoAluno", method = RequestMethod.GET, produces = "application/json")
    public String pegarEventosDeUmAluno(@RequestParam Long id_aluno){
    	List<TbEventos> listP = eventoRepository.eventoOneAluno(id_aluno);
        Gson g = new Gson();
        if(listP != null) {
            return g.toJson(listP);
        }
        return "Não Existe fdp!";
    }
}
