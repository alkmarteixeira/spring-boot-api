package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the "EstadosCivil" database table.
 * 
 */
@Data
@Entity
@Table(name="EstadosCivil")
public class EstadoCivil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESTADOSCIVIL_ID_GENERATOR", sequenceName="ESTADOSCIVIL_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESTADOSCIVIL_ID_GENERATOR")
	@Column(name="Id")
	private Long id;

	@Column(name="cd_tj_sc")
	private Long cdTjSc;

	@Column(name="de_estado_civil_fem")
	private String deEstadoCivilFem;

	@Column(name="de_estado_civil_masc")
	private String deEstadoCivilMasc;

	public EstadoCivil() {
	}

	public EstadoCivil(Long id) {
		this.id = id;
	}

}