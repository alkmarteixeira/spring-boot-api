package br.com.bsaccn.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

/**
 * The persistent class for the "Pessoas" database table.
 * 
 */
@Data
@Entity
@Table(name="PessoasJuridicas")
public class Juridica implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PessoasJuridicas_Id_seq", sequenceName="PessoasJuridicas_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PessoasJuridicas_Id_seq")
	@Column(name="Id")
	private Long id;

	@Column(name="cnpj")
	private String cnpj;	

	@Column(name="razao_social")
	private String razaoSocial;
	
	@Column(name="nome_fantasia")
	private String nomeFantasia;

	@Column(name="observacao")
	private String observacao;

	@Column(name="email")
	private String email;

	@Column(name="nu_celular")
	private String nuCelular;

	@Column(name="nu_telefone")
	private String nuTelefone;
	
	@Column(name="data_criacao")
	private LocalDateTime data_criacao;
	
	@Column(name="data_registro")
	private LocalDate dataRegistro;
	
	@Column(name="data_alteracao")
	private LocalDateTime dataAlteracao;
		
	@ManyToOne(optional = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_endereco", referencedColumnName = "Id")
	private Endereco endereco;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_ficha", referencedColumnName = "Id")
	private Ficha ficha;	
		
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_cartorio", referencedColumnName = "Id")
	private Cartorio cartorio;		
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "id_pessoa_juridica", referencedColumnName = "Id")
	private List<JuridicaIntegrante> integrantes;
		
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name = "id_pessoa_juridica", referencedColumnName = "Id")
	private List<JuridicaDocumento> documentos;
	
	
	@Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	public Juridica() {
	}

}