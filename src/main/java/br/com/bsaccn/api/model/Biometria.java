package br.com.bsaccn.api.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the "Biometrias" database table.
 * 
 */
@Data
@Entity
@Table(name="Biometrias")
public class Biometria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="Biometrias_Id_seq", sequenceName="Biometrias_Id_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Biometrias_Id_seq")
	@Column(name="Id")
	private Long id;

	@Column(name="cd_dedo")
	private Long cdDedo;

	@Column(name="imagem_biometria")
	private String imagemBiometria;

	@Column(name="iso_template")
	private String isoTemplate;

	public Biometria() {
	}
}