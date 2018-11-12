package com.br.gremio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.gremio.entity.TbSala;

@RestController
public class DeleteSala {

    @Autowired
    private SalaService salaService;

    @RequestMapping(value = "/DeleteSala", method = RequestMethod.POST)
    public String deleteSala(@RequestParam Long id_sala){
        TbSala sala = salaService.getOne(id_sala);
        try {
        	try {
        		salaService.delete(id_sala);
                return "Ok";
        	}catch (Exception e) {
        		return "Sala em um eveto";
        	}
        }catch (Exception e){
            return "Não Encontrado!";
        }
    }
}
