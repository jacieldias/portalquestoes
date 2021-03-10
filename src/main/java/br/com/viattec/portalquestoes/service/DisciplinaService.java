package br.com.viattec.portalquestoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.Disciplina;
import br.com.viattec.portalquestoes.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	public Disciplina buscarPorId(Long id) {
		return repository.getOne(id);
	}
	
	public Disciplina salvar(Disciplina disciplina) {
		return repository.saveAndFlush(disciplina);
	}
	
	public List<Disciplina> listarTodas(){
		return repository.listarTodas();
	}
}
