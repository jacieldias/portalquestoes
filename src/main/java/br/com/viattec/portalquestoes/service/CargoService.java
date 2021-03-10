package br.com.viattec.portalquestoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viattec.portalquestoes.model.Cargo;
import br.com.viattec.portalquestoes.repository.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository repository;
	
	public Cargo buscarPorId(Long id) {
		return repository.getOne(id);
	}
	
	public List<Cargo> listarTodos(){
		return repository.findAll();
	}
	
	public Cargo salvar(Cargo cargo) {
		return repository.saveAndFlush(cargo);
	}
}
