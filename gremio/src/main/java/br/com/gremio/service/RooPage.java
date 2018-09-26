package br.com.gremio.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RooPage {

    @RequestMapping(value="/")
    @ResponseBody
    public String startWebService(){
        return "Bem-Vindo ao web service Gremio";
    }
}
