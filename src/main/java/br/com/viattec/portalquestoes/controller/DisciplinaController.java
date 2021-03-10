package br.com.viattec.portalquestoes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.viattec.portalquestoes.model.Disciplina;
import br.com.viattec.portalquestoes.service.DisciplinaService;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
	
	@GetMapping("/nova")
	public ModelAndView nova(Disciplina disciplina) {
		ModelAndView mv = new ModelAndView("disciplina/cadastro");
		List<Disciplina> disciplinas = service.listarTodas();
		mv.addObject("disciplinas", disciplinas);
		if(disciplina == null) {
			mv.addObject("disciplina", new Disciplina());
		}else {
			mv.addObject("disciplina", disciplina);
		}
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Disciplina disciplina, BindingResult result) {
		ModelAndView mv = new ModelAndView("disciplina/cadastro");
		if(result.hasErrors()) {
			nova(disciplina);
		}
		
		service.salvar(disciplina);
		mv.addObject("mensagem", "Cadastro salvo com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		return nova(service.buscarPorId(id));
	}
}
