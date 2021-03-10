package br.com.viattec.portalquestoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.BancaOrganizadora;
import br.com.viattec.portalquestoes.repository.BancaOrganizadoraRepository;

@Service
public class BancaOrganizadoraService {
	
	@Autowired
	private BancaOrganizadoraRepository repository;
	
	public BancaOrganizadora buscarPorId(Long id) {
		return repository.getOne(id);
	}
	
	public BancaOrganizadora salvar(BancaOrganizadora bancaOrganizadora) {
		return repository.saveAndFlush(bancaOrganizadora);
	}
	
	public List<BancaOrganizadora> listarTodas(){
		return repository.findAll();
	}
}
