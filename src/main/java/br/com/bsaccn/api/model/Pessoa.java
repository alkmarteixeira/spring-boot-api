package br.com.bsaccn.api.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import lombok.Data;

/**
 * The persistent class for the "Pessoas" database table.
 * 
 */
@Data
@Entity
@Table(name="Pessoas")
public class Pessoa implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Pessoas_Id_seq", sequenceName="Pessoas_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Pessoas_Id_seq")
	@Column(name="Id")
	private Long id;

	@Column(name="cpf")
	private String cpf;

	@Column(name="de_profissao")
	private String deProfissao;

	@Column(name="ds_cidade_naturalidade")
	private String dsCidadeNaturalidade;

	@Column(name="ds_nome")
	private String dsNome;

	@Column(name="ds_observacao")
	private String dsObservacao;

	@Column(name="dt_nascimento")
	private LocalDate dtNascimento;

	@Column(name="email")
	private String email;

	@Column(name="imagem_foto")
	private String imagemFoto;

	@Column(name="nm_mae")
	private String nmMae;

	@Column(name="nm_pai")
	private String nmPai;

	@Column(name="nu_celular")
	private String nuCelular;

	@Column(name="nu_telefone")
	private String nuTelefone;
	
	@Column(name="sexo")
	private String sexo;

	@Column(name="uf_naturalidade")
	private String ufNaturalidade;
	
	@Column(name="data_registro")
	private LocalDateTime dataDegistro;
	

	public Pessoa() {
	}

	
	@ManyToOne(optional = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_biometria", referencedColumnName = "Id")
	private Biometria biometria;	
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_endereco", referencedColumnName = "Id")
	private Endereco endereco;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_documento", referencedColumnName = "Id")
	private Documento documento;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_ficha", referencedColumnName = "Id")
	private Ficha ficha;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_estado_civil", referencedColumnName = "Id")
	private EstadoCivil estadoCivil;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_naturalidade", referencedColumnName = "Id")
	private Cidade naturalidade;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_nacionalidade", referencedColumnName = "Id")
	private Pais nacionalidade;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_cartorio", referencedColumnName = "Id")
	private Cartorio cartorio;
	
	
	@Override public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}