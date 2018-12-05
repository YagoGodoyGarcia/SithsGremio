package com.br.gremio.service;

import com.br.gremio.entity.TbRegistro;
import com.br.gremio.entity.TbSala;
import com.br.gremio.models.RegistroModel;
import com.br.gremio.models.SalaModel;
import com.br.gremio.repository.RegistroRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaListApi {

    @Autowired
    private SalaService salaService;

    @RequestMapping(value = "/ListaSala", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> ListarEvento() {
        try {
            List<TbSala> list = salaService.findAll();
            Gson g = new Gson();
            return ResponseEntity.ok(g.toJson(list));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Estamos com problemas tecnicos por favor tente mais tarde!");
        }
    }

    @Autowired
    private RegistroRepository registroRepository;

    @RequestMapping(value = "/Data", method = RequestMethod.POST)
    public ResponseEntity<String> validaData(@RequestBody RegistroModel registro) {
        try {
            TbRegistro registroBD = registroRepository.verificarDisponibilidade(registro.getIdSala(), registro.getData());
            if (registroBD == null) {
                return ResponseEntity.ok("Ok");
            } else {
                return ResponseEntity.badRequest().body("Esse local ja possui outro evento na mesma data ");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Verifique os campos!");
        }
    }

    @RequestMapping(value = "/DeleteSala", method = RequestMethod.POST)
    public ResponseEntity<String> deleteSala(@RequestParam Long id_sala) {
        try {
            TbSala sala = salaService.getOne(id_sala);
            try {
                salaService.delete(id_sala);
                return ResponseEntity.ok("Ok");
            } catch (Exception e) {
                return ResponseEntity.badRequest()
                        .body("Essa sala esta cadastrada em um eveto!");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Não existe na base de dados!");
        }
    }

    @RequestMapping(value = "/SalaRegistration", method = RequestMethod.POST)
    public ResponseEntity<String> CriandoSala(@RequestBody SalaModel salaModel) {
        try {
            TbSala sala = new TbSala();
            Gson g = new Gson();
            sala.setNumero(salaModel.getNumero());
            sala.setCapacidade(salaModel.getCapacidade());
            sala.setDescricao(salaModel.getDescricao());
            salaService.save(sala);
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Verifique todos os campos!");
        }
    }
}
