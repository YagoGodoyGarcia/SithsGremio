package br.com.gremio.gremio.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StartGremio {
    @RequestMapping("/")
    @ResponseBody
    String ola(){
        return "Seja bem vindo ao gerenciamento de eventos do gremio";
    }
}
