package br.com.tutorial.spring.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.tutorial.spring.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
	
	List<Pessoa> findByNome(String nome);
	
	@Query("select p from Pessoa p where p.nome = :nome")
	Stream<Pessoa> findByNomeReturnStream(@Param("nome") String nome);
}
