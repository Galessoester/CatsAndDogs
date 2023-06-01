package br.com.fiap.CatsNDogs.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.CatsNDogs.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	@Query(value = "select c.id, a.nome, c.data, p.nome, t.nome from consulta c join animal a on c.animal = a.id join profissional p on c.profissional = p.id join tutor t on c.tutor = t.id", nativeQuery = true)
	List<Consulta> findByIdConsultas();
}
