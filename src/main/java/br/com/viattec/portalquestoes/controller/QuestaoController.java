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
import br.com.viattec.portalquestoes.model.Cargo;
import br.com.viattec.portalquestoes.model.Disciplina;
import br.com.viattec.portalquestoes.model.Instituicao;
import br.com.viattec.portalquestoes.model.NivelDeDificuldade;
import br.com.viattec.portalquestoes.model.Questao;
import br.com.viattec.portalquestoes.service.BancaOrganizadoraService;
import br.com.viattec.portalquestoes.service.CargoService;
import br.com.viattec.portalquestoes.service.DisciplinaService;
import br.com.viattec.portalquestoes.service.InstituicaoService;
import br.com.viattec.portalquestoes.service.NivelDeDificuldadeService;
import br.com.viattec.portalquestoes.service.QuestaoService;

@Controller
@RequestMapping("/questao")
public class QuestaoController {
	
	@Autowired
	private QuestaoService questaoService;
	
	@Autowired
	private BancaOrganizadoraService bancaService;
	
	@Autowired
	private InstituicaoService insituicaoService;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private NivelDeDificuldadeService nivelService;
	
	
	@GetMapping("/nova")
	public ModelAndView nova(Questao questao) {
		ModelAndView mv = new ModelAndView("questao/cadastro");
		List<BancaOrganizadora> bancas = bancaService.listarTodas();
		List<Instituicao> instituicoes = insituicaoService.listarTodas();
		List<Cargo> cargos = cargoService.listarTodos();
		List<Disciplina> disciplinas = disciplinaService.listarTodas();
		List<NivelDeDificuldade> niveis = nivelService.listarTodos();
		mv.addObject("bancas", bancas);
		mv.addObject("instituicoes", instituicoes);
		mv.addObject("cargos", cargos);
		mv.addObject("disciplinas", disciplinas);
		mv.addObject("niveis", niveis);
		if(questao == null) {
			mv.addObject("questao", new Questao());
		}else {
			mv.addObject("questao", questao);
		}
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Valid Questao questao, BindingResult result) {
		ModelAndView mv = new ModelAndView("questao/cadastro");
		if(result.hasErrors()) {
			return nova(questao);
		}
		
		questaoService.salvar(questao);
		mv.addObject("mensagem", "Questão cadastrada com sucesso!");
		return mv;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id")Long id) {
		return nova(questaoService.buscarPorId(id));
	}
}
