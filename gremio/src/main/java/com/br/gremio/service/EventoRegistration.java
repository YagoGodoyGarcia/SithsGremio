package com.br.gremio.service;

import com.br.gremio.entity.TbEventos;
import com.br.gremio.models.Eventos;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yago Garcia
 */
@Controller
public class EventoRegistration {

    @Autowired
    private EventoService eventoService;

    @RequestMapping(value="/EventoRegistration", method=RequestMethod.POST)
    @ResponseBody
    public String CriandoEvento(@RequestBody Eventos eventoModel){
        TbEventos evento = new TbEventos();
        Gson g = new Gson();
        evento.setNome(eventoModel.getNome());
        evento.setData(eventoModel.getData());
        evento.setHora(eventoModel.getHora());
        evento.setDescricao(eventoModel.getDescricao());
        evento.setPalestrante(eventoModel.getPalestrante());
        evento.setSala(eventoModel.getSala());

        eventoService.save(evento);
        return "Ok";
    }
}
