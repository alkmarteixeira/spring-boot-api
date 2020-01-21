package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;


/**
 * The persistent class for the "Enderecos" database table.
 * 
 */
@Data
@Entity
@Table(name="Enderecos")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Enderecos_Id_seq", sequenceName="Enderecos_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Enderecos_Id_seq")
	@Column(name="Id")
	private Long id;

//	@Column(name="cd_cidade")
//	private Long cdCidade;

	@Column(name="cep")
	private String cep;

	@Column(name="ds_bairro")
	private String dsBairro;

	@Column(name="ds_complemento")
	private String dsComplemento;

	@Column(name="ds_endreco")
	private String dsEndreco;

	@Column(name="ds_numero_endereco")
	private String dsNumeroEndereco;

	@Column(name="ds_outra_cidade")
	private String dsOutraCidade;
	
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_cidade", referencedColumnName = "Id")
	private Cidade cidade;
	

	public Endereco() {
	}


}