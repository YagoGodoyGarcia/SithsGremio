package com.br.gremio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.gremio.entity.TbEventos;

@RestController
public class DeleteEveto {
	@Autowired
	private EventoService eventoService;

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
}
