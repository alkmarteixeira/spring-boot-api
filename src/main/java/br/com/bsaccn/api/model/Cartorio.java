package br.com.bsaccn.api.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Base64;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;


/**
 * The persistent class for the "Cartorios" database table.
 * 
 */
@Data
@Entity
@Table(name="Cartorios")
public class Cartorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Id")
	private Long id;

//	@Column(name="cd_cidade")
//	private Long cdCidade;

	@Column(name="cd_cnj")
	private Long cdCnj;
	
	@Column(name="fl_ativo")
	private Boolean flAtivo;

	@Column(name="nm_cartorio")
	private String nmCartorio;

	@Column(name="nm_oficial_tabeliao")
	private String nmOficialTabeliao;
	
	@Column(name="token")
	private String token;
	
	@Column(name="role_consulta")
	private Boolean roleConsulta;
	
	@Column(name="role_insere")
	private Boolean roleInsere;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="host")
	private String host;
	
	
	public void setSenhaEncrypt(String senha) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(senha.getBytes());
        String encoded = Base64.getEncoder().encodeToString(hash);
		this.senha = encoded;
	
	}
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_cidade", referencedColumnName = "Id")
	private Cidade cidade;
	

	public Cartorio() {
	}


}