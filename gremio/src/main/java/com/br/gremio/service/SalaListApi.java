package com.br.gremio.service;

import com.br.gremio.entity.TbSala;
import com.br.gremio.models.SalaModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaListApi {

    @Autowired
    private SalaService salaService;
    @RequestMapping(value = "/ListaSala", method = RequestMethod.GET, produces = "application/json")
    String ListarEvento(){
        List<TbSala> list = salaService.findAll();
        Gson g = new Gson();
        return g.toJson(list);
    }

    @RequestMapping(value = "/ListaSalaNDisponivel", method = RequestMethod.GET, produces = "application/json")
    String ListarEventoNDisponivel(){
        List<TbSala> list = salaService.findAllND();
        Gson g = new Gson();
        return g.toJson(list);
    }

    @RequestMapping(value = "/ListaSalaDisponivel", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    String ListarEventoDisponivel(){
        List<TbSala> list = salaService.findAllD();
        Gson g = new Gson();
        return g.toJson(list);
    }

    @RequestMapping(value = "/DeleteSala", method = RequestMethod.POST)
    public String deleteSala(@RequestParam Long id_sala){
        TbSala sala = salaService.getOne(id_sala);
        try {
            try {
                salaService.delete(id_sala);
                return "Ok";
            }catch (Exception e) {
                return "SalaModel em um eveto";
            }
        }catch (Exception e){
            return "Não Encontrado!";
        }
    }

    @RequestMapping(value="/SalaRegistration", method= RequestMethod.POST)
    public String CriandoSala(@RequestBody SalaModel salaModel){
        TbSala sala = new TbSala();
        Gson g = new Gson();
        sala.setNumero(salaModel.getNumero());
        sala.setCapacidade(salaModel.getCapacidade());
        sala.setDisponibilidade(salaModel.getDisponibilidade());
        salaService.save(sala);
        return "Ok";
    }
}
