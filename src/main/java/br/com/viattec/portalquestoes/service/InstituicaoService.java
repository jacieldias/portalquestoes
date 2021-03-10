package br.com.viattec.portalquestoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.Instituicao;
import br.com.viattec.portalquestoes.repository.InstituicaoRepository;

@Service
public class InstituicaoService {
	
	@Autowired
	private InstituicaoRepository repository;
	
	public Instituicao buscarPorId(Long id) {
		return repository.getOne(id);
	}
	
	public List<Instituicao> listarTodas(){
		return repository.findAll();
	}
	
	public Instituicao salvar(Instituicao instituicao) {
		return repository.saveAndFlush(instituicao);
	}
}
