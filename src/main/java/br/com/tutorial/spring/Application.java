package br.com.tutorial.spring;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import br.com.tutorial.spring.dao.PessoaRepository;
import br.com.tutorial.spring.model.Pessoa;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Transactional(readOnly = true)
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("DataSource = " + dataSource);
		
		System.out.println("\n1. findAll()...");
		for(Pessoa pessoa : pessoaRepository.findAll()){
			System.out.println(pessoa);
		}
		
		System.out.println("\n1. findByNome()...");
		for(Pessoa pessoa : pessoaRepository.findByNome("Alexandre Uczak")){
			System.out.println(pessoa);
		}
		
		System.out.println("\n1. findByNomeReturnStream()...");
		try(Stream<Pessoa> pessoa = pessoaRepository.findByNomeReturnStream("Bryan Uczak")){
			pessoa.forEach(System.out::println);
		}
		
		
	}

}
