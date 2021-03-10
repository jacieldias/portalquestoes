package br.com.viattec.portalquestoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viattec.portalquestoes.model.Questao;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long>{

}
