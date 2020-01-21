package br.com.bsaccn.api.model;

import java.io.Serializable;
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
@Table(name="Session")
public class Session implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private String id;	
	
	@ManyToOne(optional = true, fetch=FetchType.EAGER)
	@NotFound(action=NotFoundAction.IGNORE)
	@JoinColumn(name = "id_cartorio", referencedColumnName = "Id", nullable = true)
	private Cartorio cartorio;
	
	@Column(name="data")
	private LocalDateTime data;
	
	@Column(name="data_idle")
	private LocalDateTime dataIdle;
	
	@Column(name="host")
	private String host;

}

