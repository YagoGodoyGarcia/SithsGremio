package br.com.gremio.service;

import br.com.gremio.entity.TbEventos;
import br.com.gremio.models.Eventos;
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
    public String setEvento(@RequestBody Eventos eventoModel){
        TbEventos evento = new TbEventos();
        Gson g = new Gson();
        System.out.println(g.toJson(eventoModel));
        evento.setNome(eventoModel.getNome());
        evento.setData(eventoModel.getData());
        evento.setHora(eventoModel.getHora());
        evento.setDescricao(eventoModel.getDescricao());
        evento.setPalestrante(eventoModel.getPalestrante());

        eventoService.save(evento);

        return "Ok";
    }
}
