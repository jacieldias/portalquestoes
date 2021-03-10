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

import br.com.viattec.portalquestoes.model.Instituicao;
import br.com.viattec.portalquestoes.service.InstituicaoService;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoService service;
	
	@GetMapping("/nova")
	public ModelAndView nova(Instituicao instituicao) {
		ModelAndView mv = new ModelAndView("instituicao/cadastro");
		if(instituicao == null) {
			mv.addObject("instituicao", new Instituicao());
		}else {
			mv.addObject("instituicao", instituicao);
		}
		List<Instituicao> instituicoes = service.listarTodas();
		mv.addObject("instituicoes", instituicoes);
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Instituicao instituicao, BindingResult result) {
		ModelAndView mv = new ModelAndView("instituicao/cadastro");
		if(result.hasErrors()) {
			nova(instituicao);
		}
		service.salvar(instituicao);
		mv.addObject("mensagem", "Cadastro salvo com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		return nova(service.buscarPorId(id));
	}
}
