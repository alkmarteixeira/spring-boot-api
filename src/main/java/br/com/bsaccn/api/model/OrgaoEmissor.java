package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the "OrgaosEmissores" database table.
 * 
 */
@Data
@Entity
@Table(name="OrgaosEmissores")
public class OrgaoEmissor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column(name="Id") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="ds_orgao_emissor")
	private String dsOrgaoEmissor;

	@Column(name="ds_sigla_orgao_emissor")
	private String dsSiglaOrgaoEmissor;

	public OrgaoEmissor() {
	}

	public OrgaoEmissor(Long id, String dsOrgaoEmissor, String dsSiglaOrgaoEmissor) {
		super();
		this.id = id;
		this.dsOrgaoEmissor = dsOrgaoEmissor;
		this.dsSiglaOrgaoEmissor = dsSiglaOrgaoEmissor;
	}


}