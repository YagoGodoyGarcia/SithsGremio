package com.br.gremio.service;

import com.br.gremio.entity.TbSala;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SalaList {

    @Autowired
    private SalaService salaService;
    @RequestMapping(value = "/ListaSala", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    String ListarEvento(){
        List<TbSala> list = salaService.findAll();
        Gson g = new Gson();
        return g.toJson(list);
    }

}
