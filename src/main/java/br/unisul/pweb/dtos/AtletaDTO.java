package br.unisul.pweb.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.unisul.pweb.domain.Atleta;

public class AtletaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer idade;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private char sexo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String equipe;
	
	public AtletaDTO() {
	}
	
	public AtletaDTO(Atleta obj) {
		id = obj.getId();
		nome = obj.getNome();
		idade = obj.getIdade();
		sexo = obj.getSexo();
		equipe = obj.getEquipe();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEquipe() {
		return equipe;
	}

	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	
}
