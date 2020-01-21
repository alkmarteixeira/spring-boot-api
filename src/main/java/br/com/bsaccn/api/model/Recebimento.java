package br.com.bsaccn.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Data
@Entity
@Table(name="Recebimento")
public class Recebimento {
	
	@Id
	@Column(name="Id")
	private String Id;
	
	@Column(name="data_recebimento")
	private LocalDateTime dataRecebimento;
	
	@Column(name="data_processamento")
	private LocalDateTime dataProcessamento;
		
	@Column(name="total_registros")
	private Integer totalRegistros;
	
	@Column(name="mensagem")
	private String mensagem;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="legado")
	private Boolean legado;
	
	@Column(name="operacao")
	private Integer operacao;
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "cd_cartorio", referencedColumnName = "Id")
	private Cartorio cartorio;
		
	public Recebimento() {
		
	}
		
}
