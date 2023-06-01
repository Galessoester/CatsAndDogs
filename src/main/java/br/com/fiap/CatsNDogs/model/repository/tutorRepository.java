package br.com.fiap.CatsNDogs.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.CatsNDogs.model.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
