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

import br.com.viattec.portalquestoes.model.BancaOrganizadora;
import br.com.viattec.portalquestoes.service.BancaOrganizadoraService;

@Controller
@RequestMapping("/banca")
public class BancaOrganizadoraController {
	
	@Autowired
	private BancaOrganizadoraService service;
	
	@GetMapping("/nova")
	public ModelAndView nova(BancaOrganizadora bancaOrganizadora) {
		ModelAndView mv = new ModelAndView("banca_organizadora/cadastro");
		if(bancaOrganizadora == null) {
			mv.addObject("bancaOrganizadora", new BancaOrganizadora());
		}else {
			mv.addObject("bancaOrganizadora", bancaOrganizadora);
		}
		List<BancaOrganizadora> bancas = service.listarTodas();
		mv.addObject("bancas", bancas);
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid BancaOrganizadora bancaOrganizadora, BindingResult result) {
		ModelAndView mv = new ModelAndView("banca_organizadora/cadastro");
		if(result.hasErrors()) {
			return nova(bancaOrganizadora);
		}
		
		service.salvar(bancaOrganizadora);
		mv.addObject("mensagem", "Cadastro salvo com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		return nova(service.buscarPorId(id));
	}
}
