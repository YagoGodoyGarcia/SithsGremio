package com.br.gremio.service;

import com.br.gremio.entity.TbAluno;
import com.br.gremio.entity.TbEventos;
import com.br.gremio.models.AlunoModel;
import com.br.gremio.models.ChamadaModel;
import com.br.gremio.models.SenhaModel;
import com.br.gremio.repository.AlunoRepository;
import com.br.gremio.repository.EventoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
public class AlunoListApi {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoRepository eventoRepository;

    @RequestMapping(value="/AlunoRegistration", method= RequestMethod.POST)
    public String RegistrarAluno(@RequestBody AlunoModel alunoModelModel){
        TbAluno aluno = new TbAluno();
        Gson g = new Gson();
        aluno.setNome(alunoModelModel.getNome());
        aluno.setRa(alunoModelModel.getRa());
        aluno.setEmail(alunoModelModel.getEmail());
        aluno.setSenha(alunoModelModel.getSenha());
        aluno.setNivelPermissao(alunoModelModel.getNivelPermissao());
        alunoRepository.save(aluno);
        return "Ok";
    }

    @RequestMapping(value="/alterarSenha", method= RequestMethod.POST)
    public String RegistrarAluno(@RequestBody SenhaModel senha){
        try{
            Gson g = new Gson();
            TbAluno aluno = alunoService.getOne(senha.getId_aluno());
	        aluno.setSenha(senha.getSenha());
	        alunoService.save(aluno);
	        return "Ok";
        }catch (NoSuchElementException e){
            return e+ "!";
        }
    }

    @RequestMapping(value="/ListaAluno", method= RequestMethod.GET,  produces = "application/json")
    public String ListaAlunos(){
    	List<TbAluno> list = alunoService.findAll();
        Gson g = new Gson();
        return g.toJson(list);
    }

    @RequestMapping(value="/AlunoNoEvento", method= RequestMethod.POST)
    public String AlunoNoEvento(@RequestBody ChamadaModel chamadaModel){
        try{
            TbEventos evento = eventoService.getOne(chamadaModel.getId_evento());
            TbAluno aluno = alunoService.getOne(chamadaModel.getId_aluno());
            evento.cadastraAluno(aluno);
            eventoRepository.save(evento);
            return "Ok";
        }catch (NoSuchElementException e){
            return e+"!";
        }
    }

    @RequestMapping(value = "/EventosAluno", method = RequestMethod.GET, produces = "application/json")
    public String pegarEvento(@RequestParam("id_aluno") long id_aluno){
        try{
            alunoService.getOne(id_aluno);
            List<TbEventos> eventoP = eventoRepository.eventoPorAluno(id_aluno);
            Gson g = new Gson();
            return g.toJson(eventoP);
        }catch (NoSuchElementException e) {
            return e + "!";
        }
    }
    @RequestMapping(value = "/EventosDisponiveisAluno", method = RequestMethod.GET, produces = "application/json")
    public String pegarEventosDisponiveis(@RequestParam("id_aluno") long id_aluno){
    	List<TbEventos> eventoNull = eventoRepository.findAll();
    	List<TbEventos> eventoP = eventoRepository.eventoDisponivelPorAluno(id_aluno);
        Gson g = new Gson();
    	for(int i = 0; i < eventoNull.size(); i++) {
    	Set<TbAluno> Alunos = eventoNull.get(i).getAlunos();
    		if(Alunos.size() == 0 ) {
    			eventoP.add(eventoNull.get(i));
    		}
    	}
        if(eventoP != null) {
        	return g.toJson(eventoP);
        }
        return null;
    }
    @RequestMapping(value = "/SairDoEvento", method = RequestMethod.POST, produces = "application/json")
    public String pegarEventosDisponiveis(@RequestBody ChamadaModel chamadaModel){
        TbEventos evento = eventoService.getOne(chamadaModel.getId_evento());
        TbAluno aluno = alunoService.getOne(chamadaModel.getId_aluno());
        if(evento != null && aluno != null) {
            eventoRepository.deletarAlunoDoEvento(chamadaModel.getId_evento(), chamadaModel.getId_aluno());
        }
        return null;
    }
}
