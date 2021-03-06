package br.com.tutorial.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "apelido")
	private String apelido;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	@Override
	public String toString() {

		return "{ codigo: " + this.getCodigo().toString() + ", " + "nome: " + this.getNome() + ", " + "apelido: "
				+ this.getApelido() + " }";
	}
}
