package br.com.viattec.portalquestoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.viattec.portalquestoes.model.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

	@Query("select d from Disciplina d order by d.nome asc")
	List<Disciplina> listarTodas();
}
