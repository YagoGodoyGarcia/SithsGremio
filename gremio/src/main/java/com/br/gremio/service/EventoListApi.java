package com.br.gremio.service;

import com.br.gremio.entity.TbEventos;
import com.br.gremio.entity.TbSala;
import com.br.gremio.models.AtualizaEvento;
import com.br.gremio.models.EventosModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yago Garcia
 */
@RestController
public class EventoListApi {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private SalaService salaService;

    @RequestMapping(value = "/ListaEvento", method = RequestMethod.GET, produces = "application/json")
    String ListarEvento(){
        List<TbEventos> eventos = eventoService.findAll();
        Gson g = new Gson();
        return g.toJson(eventos);
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

    @RequestMapping(value = "/DeleteEvento", method = RequestMethod.POST)
    public String deleteSala(@RequestParam Long id_evento) {
        TbEventos vento = eventoService.getOne(id_evento);
        try {
            eventoService.delete(id_evento);
            return "Ok";
        } catch (Exception e) {
            return "Não Encontrado!";
        }
    }

    @RequestMapping(value="/EventoRegistration", method=RequestMethod.POST)
    public String CriandoEvento(@RequestBody EventosModel eventoModel){
        TbEventos evento = new TbEventos();
        Gson g = new Gson();
        evento.setNome(eventoModel.getNome());
        evento.setData(eventoModel.getData());
        evento.setHora(eventoModel.getHora());
        evento.setDescricao(eventoModel.getDescricao());
        evento.setPalestrante(eventoModel.getPalestrante());
        TbSala sala = salaService.getOne(eventoModel.getSala());
        if(sala != null){
            evento.setSala(sala);

            eventoService.save(evento);
            return "Ok";
        }else{
            return "SalaModel não encontrada";
        }

    }

    @RequestMapping(value="/EventoAtualiza", method=RequestMethod.POST)
    public String AtualizaEvento(@RequestBody AtualizaEvento eventoModel){
        TbEventos evento = eventoService.getOne(eventoModel.getId_evento());
        Gson g = new Gson();
        evento.setNome(eventoModel.getNome());
        evento.setData(eventoModel.getData());
        evento.setHora(eventoModel.getHora());
        evento.setDescricao(eventoModel.getDescricao());
        evento.setPalestrante(eventoModel.getPalestrante());
        TbSala sala = salaService.getOne(eventoModel.getSala());
        if(sala != null){
            evento.setSala(sala);
            eventoService.save(evento);
            return "Ok";
        }else{
            return "SalaModel não encontrada";
        }

    }
}
