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

import br.com.viattec.portalquestoes.model.Assunto;
import br.com.viattec.portalquestoes.model.Disciplina;
import br.com.viattec.portalquestoes.service.AssuntoService;
import br.com.viattec.portalquestoes.service.DisciplinaService;

@Controller
@RequestMapping("/assunto")
public class AssuntoController {
	
	@Autowired
	private AssuntoService assuntoService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Assunto assunto) {
		ModelAndView mv = new ModelAndView("assunto/cadastro");
		List<Disciplina> disciplinas = disciplinaService.listarTodas();
		mv.addObject("disciplinas", disciplinas);
		if(assunto == null) {
			mv.addObject("assunto", new Assunto());
		}else {
			mv.addObject("assunto", assunto);
		}
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Assunto assunto, BindingResult result){
		ModelAndView mv = new ModelAndView("assunto/cadastro");
		if(result.hasErrors()) {
			return novo(assunto);
		}
		assuntoService.salvar(assunto);
		mv.addObject("mensagem", "Cadastro salvo com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		return novo(assuntoService.buscarPorId(id));
	}
}
