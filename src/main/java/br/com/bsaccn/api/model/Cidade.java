package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


/**
 * The persistent class for the "Cidades" database table.
 * 
 */
@Data
@Entity
@Table(name="Cidades")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CIDADES_ID_GENERATOR", sequenceName="CIDADES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CIDADES_ID_GENERATOR")
	@Column(name="Id")
	private Long id;

	@Column(name="cd_cep_cidade")
	private Long cdCepCidade;

	@Column(name="cd_ibge")
	private Long cdIbge;

	@Column(name="cep")
	private String cep;

	@Column(name="ds_nome")
	private String dsNome;

	@Column(name="uf")
	private String uf;
	

	public Cidade() {
	}

	public Cidade(Long id) {
		this.id = id;
	}
	
	public Cidade(Long id, Long ibge) {
		this.cdIbge = ibge;
	}

}