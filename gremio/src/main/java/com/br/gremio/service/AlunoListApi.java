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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Yago Garcia
 */
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

    @RequestMapping(value = "/AlunoRegistration", method = RequestMethod.POST)
    public ResponseEntity<String> RegistrarAluno(@RequestBody AlunoModel alunoModelModel) {
        try {
            TbAluno aluno = new TbAluno();
            Gson g = new Gson();
            aluno.setNome(alunoModelModel.getNome());
            aluno.setRa(alunoModelModel.getRa());
            aluno.setEmail(alunoModelModel.getEmail());
            aluno.setSenha(alunoModelModel.getSenha());
            aluno.setNivelPermissao(alunoModelModel.getNivelPermissao());
            alunoRepository.save(aluno);
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Verifique todos os campos!");
        }
    }

    @RequestMapping(value = "/alterarSenha", method = RequestMethod.POST)
    public ResponseEntity<String> RegistrarAluno(@RequestBody SenhaModel senha) {
        try {
            Gson g = new Gson();
            TbAluno aluno = alunoService.getOne(senha.getId_aluno());
            aluno.setSenha(senha.getSenha());
            alunoService.save(aluno);
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Aluno não existe na base de dados!");
        }
    }

    @RequestMapping(value = "/ListaAluno", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> ListaAlunos() {
        try {
            List<TbAluno> list = alunoService.findAll();
            Gson g = new Gson();
            return ResponseEntity.ok(g.toJson(list));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Estamos com problemas tecnicos por favor tente mais tarde!");
        }
    }

    @RequestMapping(value = "/AlunoNoEvento", method = RequestMethod.POST)
    public ResponseEntity<String> AlunoNoEvento(@RequestBody ChamadaModel chamadaModel) {
        try {
            TbEventos evento = eventoService.getOne(chamadaModel.getId_evento());
            TbAluno aluno = alunoService.getOne(chamadaModel.getId_aluno());
            evento.cadastraAluno(aluno);
            eventoRepository.save(evento);
            return ResponseEntity.ok("Ok");
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest()
                    .body("Aluno ou Evento não existe! por favor verifique os id's!");
        }
    }

    @RequestMapping(value = "/EventosAluno", method = RequestMethod.GET, produces = "application/json")
    public String pegarEvento(@RequestParam("id_aluno") long id_aluno) {
        try {
            alunoService.getOne(id_aluno);
            List<TbEventos> eventoP = eventoRepository.eventoPorAluno(id_aluno);
            Gson g = new Gson();
            return g.toJson(eventoP);
        } catch (NoSuchElementException e) {
            return e + "!";
        }
    }

    @RequestMapping(value = "/EventosDisponiveisAluno", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> pegarEventosDisponiveis(@RequestParam("id_aluno") long id_aluno) {
        try {
            Gson g = new Gson();
            List<TbEventos> eventoP = eventoRepository.eventoDisponivelPorAluno(id_aluno);
            return ResponseEntity.ok(g.toJson(eventoP));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Aluno não existe na base de dados");
        }
    }

    @RequestMapping(value = "/SairDoEvento", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> pegarEventosDisponiveis(@RequestBody ChamadaModel chamadaModel) {
        try {
            TbEventos evento = eventoService.getOne(chamadaModel.getId_evento());
            TbAluno aluno = alunoService.getOne(chamadaModel.getId_aluno());
            eventoRepository.deletarAlunoDoEvento(chamadaModel.getId_evento(), chamadaModel.getId_aluno());
            return ResponseEntity.ok("Ok");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Aluno ou Evento não existe! por favor verifique os id's!");
        }
    }
}
