package br.com.gremio.service;

import br.com.gremio.entity.TbEventos;
import br.com.gremio.models.Eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventoRegistration {

    @Autowired
    private EventoService eventoService;

    @RequestMapping(value="/EventoRegistration", method=RequestMethod.POST)
    @ResponseBody
    public String setEvento(@RequestBody Eventos eventoModel){
        TbEventos evento = new TbEventos();
        evento.setNome(eventoModel.getNome());
        eventoService.save(evento);

        return "Ok";
    }
}
