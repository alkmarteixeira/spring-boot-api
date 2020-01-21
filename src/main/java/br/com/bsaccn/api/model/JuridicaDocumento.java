package br.com.bsaccn.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.Data;

/**
 * The persistent class for the "Documentos" database table.
 * 
 */
@Data
@Entity
@Table(name="DocumentosPJ")
public class JuridicaDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DocumentosPJ_Id_seq", sequenceName="DocumentosPJ_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DocumentosPJ_Id_seq" )
	@Column(name="Id")
	private Long id;

	@Column(name="id_pessoa_juridica")
	private String idPessoaJuridica;

	@Column(name="datadocumento")
	private LocalDate dataDocumento;

	@Column(name="imagemdocumento")
	private String imagemDocumento;

	@Column(name="descricaodocumento")
	private String descricaodocumento;
	
//	@ManyToOne(optional = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@NotFound(action=NotFoundAction.IGNORE)
//	@JoinColumn(name = "id_pessoa_juridica", referencedColumnName = "Id")
//	private Juridica juridica;
		

	public JuridicaDocumento() {
	}

}