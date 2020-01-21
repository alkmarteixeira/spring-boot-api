package br.com.bsaccn.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

/**
 * The persistent class for the "Documentos" database table.
 * 
 */
@Data
@Entity
@Table(name="Documentos")
public class Documento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Documentos_Id_seq", sequenceName="Documentos_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Documentos_Id_seq" )
	@Column(name="Id")
	private Long id;

//	@Column(name="cd_orgao_emissor")
//	private Long cdOrgaoEmissor;

	@Column(name="doc_identidade")
	private String docIdentidade;

	@Column(name="ds_orgao_emissor")
	private String dsOrgaoEmissor;

	@Column(name="dt_emissao")
	private LocalDate dtEmissao;

	@Column(name="imagem_documento")
	private String imagemDocumento;

	@Column(name="uf_orgao_emissor")
	private String ufOrgaoEmissor;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_orgao_emissor", referencedColumnName = "Id", updatable=false, insertable=false)
	private OrgaoEmissor orgaoEmissor;
	

	public Documento() {
	}

}