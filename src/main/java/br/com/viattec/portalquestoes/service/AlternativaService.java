package br.com.viattec.portalquestoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.Alternativa;
import br.com.viattec.portalquestoes.model.Questao;
import br.com.viattec.portalquestoes.repository.AlternativaRepository;

@Service
public class AlternativaService {
	
	@Autowired
	private AlternativaRepository repository;
	
	public Alternativa buscarPorId(long id) {
		return repository.getOne(id);
	}
	
	public Alternativa salvar(Alternativa alternativa) {
		return repository.saveAndFlush(alternativa);
	}
	
	public List<Alternativa> listarAlternativasPorQuestao(Questao questao){
		return repository.listarAlternativasPorQuestao(questao);
	}
}
