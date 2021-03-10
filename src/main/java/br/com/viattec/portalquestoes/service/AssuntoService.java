package br.com.viattec.portalquestoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.Assunto;
import br.com.viattec.portalquestoes.model.Disciplina;
import br.com.viattec.portalquestoes.repository.AssuntoRepository;

@Service
public class AssuntoService {
	
	@Autowired
	private AssuntoRepository repository;
	
	public Assunto buscarPorId(Long id) {
		return repository.getOne(id);
	}
	
	public Assunto salvar(Assunto assunto) {
		return repository.saveAndFlush(assunto);
	}

	public List<Assunto> listarAssuntoPorDisciplina(Disciplina disciplina){
		return repository.listarAssuntoPorDisciplina(disciplina);
	}
}
