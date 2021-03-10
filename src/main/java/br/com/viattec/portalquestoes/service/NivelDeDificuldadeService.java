package br.com.viattec.portalquestoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.NivelDeDificuldade;
import br.com.viattec.portalquestoes.repository.NivelDeDificuldadeRepository;

@Service
public class NivelDeDificuldadeService {
	
	@Autowired
	private NivelDeDificuldadeRepository repository;
	
	public NivelDeDificuldade buscarPorId(Long id) {
		return repository.getOne(id);
	}
	
	public NivelDeDificuldade salvar(NivelDeDificuldade nivelDeDificuldade) {
		return repository.saveAndFlush(nivelDeDificuldade);
	}
	
	public List<NivelDeDificuldade> listarTodos(){
		return repository.findAll();
	}
}
