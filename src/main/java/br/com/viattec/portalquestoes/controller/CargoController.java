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

import br.com.viattec.portalquestoes.model.Cargo;
import br.com.viattec.portalquestoes.service.CargoService;

@Controller
@RequestMapping("/cargo")
public class CargoController {
	
	@Autowired
	private CargoService service;
	
	@GetMapping("/novo")
	public ModelAndView novo(Cargo cargo) {
		ModelAndView mv = new ModelAndView("cargo/cadastro");
		List<Cargo> cargos = service.listarTodos();
		mv.addObject("cargos", cargos);
		if(cargo == null) {
			mv.addObject("cargo", new Cargo());
		}else {
			mv.addObject("cargo", cargo);
		}
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Cargo cargo, BindingResult result) {
		ModelAndView mv = new ModelAndView("cargo/cadastro");
		if(result.hasErrors()) {
			return novo(cargo);
		}
		service.salvar(cargo);
		mv.addObject("mensagem", "Cadastro salvo com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		return novo(service.buscarPorId(id));
	}
	

}
