package br.com.viattec.portalquestoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.viattec.portalquestoes.model.Assunto;
import br.com.viattec.portalquestoes.model.Disciplina;

@Repository
public interface AssuntoRepository extends JpaRepository<Assunto, Long>{

	@Query("select a from Assunto a where a.disciplina = :disciplina order by a.descricao asc")
	List<Assunto> listarAssuntoPorDisciplina(@Param("disciplina") Disciplina disciplina);
}
