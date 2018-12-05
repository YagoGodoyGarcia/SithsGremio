package com.br.gremio.service;

import com.br.gremio.entity.TbEventos;
import com.br.gremio.entity.TbRegistro;
import com.br.gremio.entity.TbSala;
import com.br.gremio.models.AtualizaEvento;
import com.br.gremio.models.EventosModel;
import com.br.gremio.repository.RegistroRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> ListarEvento() {
        try {
            List<TbEventos> eventos = eventoService.findAll();
            Gson g = new Gson();
            return ResponseEntity.ok(g.toJson(eventos));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Estamos com problemas tecnicos por favor tente mais tarde!");
        }
    }

    @RequestMapping(value = "/OneEvento", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> pegarEvento(@RequestParam Long id_evento) {
        try {
            TbEventos eventoP = eventoService.getOne(id_evento);
            Gson g = new Gson();
            return ResponseEntity.ok(g.toJson(eventoP));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Evento não existe na base de dados!");
        }
    }

    @RequestMapping(value = "/DeleteEvento", method = RequestMethod.POST)
    public ResponseEntity<String> deleteSala(@RequestParam Long id_evento) {
        try {
            eventoService.delete(id_evento);
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Evento não existe na base de dados!");
        }
    }


    @Autowired
    private SalaService salaRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @RequestMapping(value = "/EventoRegistration", method = RequestMethod.POST)
    public ResponseEntity<String> CriandoEvento(@RequestBody EventosModel eventoModel) {
        try {
            TbEventos evento = new TbEventos();

            TbRegistro registro = new TbRegistro();
            Gson g = new Gson();
            evento.setNome(eventoModel.getNome());
            evento.setData(eventoModel.getData());
            evento.setHora(eventoModel.getHora());
            evento.setDescricao(eventoModel.getDescricao());
            evento.setPalestrante(eventoModel.getPalestrante());
            try {
                TbSala sala = salaService.getOne(eventoModel.getSala());
                evento.setSala(sala);
                TbRegistro registroBD = registroRepository.verificarDisponibilidade(sala.getIdSala(), eventoModel.getData());
                if (registroBD == null) {
                    registro.setData(eventoModel.getData());
                    registro.setIdSala(sala.getIdSala());
                    registroRepository.save(registro);
                    eventoService.save(evento);
                } else {
                    return ResponseEntity.badRequest().body("Esse local ja possui outro evento na mesma data ");
                }
                return ResponseEntity.ok("Ok");
            } catch (Exception e) {
                return ResponseEntity.badRequest()
                        .body(e.getMessage());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Verifique todos os campos!");
        }
    }

    @RequestMapping(value = "/EventoAtualiza", method = RequestMethod.POST)
    public ResponseEntity<String> AtualizaEvento(@RequestBody AtualizaEvento eventoModel) {
        try {
            TbEventos evento = eventoService.getOne(eventoModel.getId_evento());
            Gson g = new Gson();
            evento.setNome(eventoModel.getNome());
            evento.setData(eventoModel.getData());
            evento.setHora(eventoModel.getHora());
            evento.setDescricao(eventoModel.getDescricao());
            evento.setPalestrante(eventoModel.getPalestrante());
            try {
                TbSala sala = salaService.getOne(eventoModel.getSala());
                evento.setSala(sala);
                eventoService.save(evento);
                return ResponseEntity.ok("Ok");
            } catch (Exception e) {
                return ResponseEntity.badRequest()
                        .body("Sala não existe na base de dados!");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Evento não existe na base de dados!");
        }
    }
}
