package br.com.viattec.portalquestoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.viattec.portalquestoes.model.Alternativa;
import br.com.viattec.portalquestoes.model.Questao;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Long>{
	
	@Query("select a from Alternativa a where a.questao = :questao")
	List<Alternativa> listarAlternativasPorQuestao(@Param("questao")Questao questao);

}
