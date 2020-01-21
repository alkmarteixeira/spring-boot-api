package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the "Paises" database table.
 * 
 */
@Data
@Entity
@Table(name="Paises")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PAISES_ID_GENERATOR", sequenceName="PAISES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAISES_ID_GENERATOR")
	@Column(name="Id")
	private Long id;

	@Column(name="de_nacionalidade_fem")
	private String deNacionalidadeFem;

	@Column(name="de_nacionalidade_masc")
	private String deNacionalidadeMasc;

	@Column(name="de_pais")
	private String dePais;

	@Column(name="sg_pais")
	private String sgPais;

	public Pais() {
	}

	public Pais(Long id) {
		this.id = id;
	}
	
	public Pais(String sigla) {
		this.sgPais = sigla;
	}

}