package com.platos.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.platos.desafio.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByEstiloContainingIgnoreCase (String estilo);
	
	public Postagem findFirstByTemperaturaMinLessThanEqualAndTemperaturaMaxGreaterThanEqual(int temperatura1, int temperatura2);
	
	
	
	
}
