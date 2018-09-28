package br.com.gremio.service;
import br.com.gremio.entity.TbEventos;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author Yago Garcia
 */
@Controller
public class EventoList {

    @Autowired
    private EventoService eventoService;
    @RequestMapping(value = "/ListaEvento", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    String ListarEvento(){
        List<TbEventos> list = eventoService.findAll();
        Gson g = new Gson();
        return g.toJson(list);
    }
}
