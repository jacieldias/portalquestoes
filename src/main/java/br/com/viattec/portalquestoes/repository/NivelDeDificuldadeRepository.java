package br.com.viattec.portalquestoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viattec.portalquestoes.model.NivelDeDificuldade;

@Repository
public interface NivelDeDificuldadeRepository extends JpaRepository<NivelDeDificuldade, Long>{

}
