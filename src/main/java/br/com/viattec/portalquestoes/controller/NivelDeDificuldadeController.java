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

import br.com.viattec.portalquestoes.model.NivelDeDificuldade;
import br.com.viattec.portalquestoes.service.NivelDeDificuldadeService;

@Controller
@RequestMapping("/nivel")
public class NivelDeDificuldadeController {
	
	@Autowired
	private NivelDeDificuldadeService service;
	
	@GetMapping("/novo")
	public ModelAndView novo(NivelDeDificuldade nivelDeDificuldade) {
		ModelAndView mv = new ModelAndView("nivel_dificuldade/cadastro");
		List<NivelDeDificuldade> niveis = service.listarTodos();
		mv.addObject("niveis", niveis);
		if(nivelDeDificuldade == null) {
			mv.addObject("nivelDeDificuldade", new NivelDeDificuldade());
		}else {
			mv.addObject("nivelDeDificuldade", nivelDeDificuldade);
		}
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid NivelDeDificuldade nivelDeDificuldade, BindingResult result) {
		ModelAndView mv = new ModelAndView("nivel_dificuldade/cadastro");
		if(result.hasErrors()) {
			novo(nivelDeDificuldade);
		}
		service.salvar(nivelDeDificuldade);
		mv.addObject("mensagem", "Cadastro salvo com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		return novo(service.buscarPorId(id));
	}
}
