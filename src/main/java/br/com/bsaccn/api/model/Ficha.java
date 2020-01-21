package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import java.time.LocalDate;


/**
 * The persistent class for the "Fichas" database table.
 * 
 */
@Data
@Entity
@Table(name="Fichas")
public class Ficha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Fichas_Id_seq", sequenceName="Fichas_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Fichas_Id_seq")
	@Column(name="Id")
	private Long id;

	@Column(name="dt_ficha")
	private LocalDate dtFicha;

	@Column(name="imagem_ficha")
	private String imagemFicha;

	@Column(name="nu_ficha")
	private String nuFicha;

	public Ficha() {
	}

}