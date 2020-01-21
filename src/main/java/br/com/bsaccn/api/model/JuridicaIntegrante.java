package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="PessoasJuridicasIntegrantes")
public class JuridicaIntegrante implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PessoasJuridicasIntegrantes_Id_seq", sequenceName="PessoasJuridicasIntegrantes_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PessoasJuridicasIntegrantes_Id_seq")
	@Column(name="Id")
	private Long id;
	
	@Column(name="id_pessoa_juridica")
	private Long idPessoaJuridica;

	@Column(name="cpf")
	private String cpf;	

	@Column(name="doc_identificacao")
	private String docIdentificacao;
	
	@Column(name="ds_orgao_emissor")
	private String dsOrgaoEmissor;

	@Column(name="nome")
	private String nome;

	@Column(name="tipo_integrante")
	private Integer tipoIntegrante;

	@Column(name="uf_orgao_emissor")
	private String ufOrgaoEmissor;
			
//	@ManyToOne	
//	@JoinColumn(name = "id_pessoa_juridica", referencedColumnName = "Id")
//	private Juridica juridica;
	
	
	@Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	public JuridicaIntegrante() {
	}

}