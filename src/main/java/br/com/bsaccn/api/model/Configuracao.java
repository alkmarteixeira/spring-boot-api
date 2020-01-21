package br.com.bsaccn.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Configuracao")
public class Configuracao {
	
	@Id
	@Column(name="chave")
	private String chave;
	
	@Column(name="descricao")
	private String descricao;	
		
	@Column(name="valor")
	private String valor;
		
	public Configuracao() {
		
	}
		
}
