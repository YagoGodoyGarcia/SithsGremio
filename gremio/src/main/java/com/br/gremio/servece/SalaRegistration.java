package com.br.gremio.servece;

import com.br.gremio.entity.TbSala;
import com.br.gremio.models.Sala;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SalaRegistration {
    @Autowired
    private SalaService salaService;

    @RequestMapping(value="/SalaRegistration", method= RequestMethod.POST)
    @ResponseBody
    public String CriandoSala(@RequestBody Sala salaModel){
        TbSala sala = new TbSala();
        Gson g = new Gson();
        System.out.println(g.toJson(salaModel));
        sala.setNumero(salaModel.getNumero());
        sala.setCapacidade(salaModel.getCapacidade());
        sala.setDisponibilidade(salaModel.getDisponibilidade());
        salaService.save(sala);

        return "Ok";
    }
}
