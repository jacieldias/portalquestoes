package br.com.viattec.portalquestoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.Questao;
import br.com.viattec.portalquestoes.repository.QuestaoRepository;

@Service
public class QuestaoService {
	
	@Autowired
	private QuestaoRepository repository;
	
	public Questao buscarPorId(Long id) {
		return repository.getOne(id);
	}
	
	public Questao salvar(Questao questao) {
		return repository.saveAndFlush(questao);
	}
}
