package com.br.gremio.service;

import com.br.gremio.entity.TbEventos;
import com.br.gremio.entity.TbSala;
import com.br.gremio.models.Eventos;
import com.br.gremio.models.Sala;
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
    @Autowired
    private SalaService salaService;

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
        TbSala sala = salaService.getOne(eventoModel.getSala());
        evento.setSala(sala);

        eventoService.save(evento);
        return "Ok";
    }
}
