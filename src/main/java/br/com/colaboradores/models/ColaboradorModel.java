package br.com.colaboradores.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_colaborador")
public class ColaboradorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@NotNull
	private String cargo;

	public ColaboradorModel(String nome, String cargo, String email) {
		this.nome = nome;
		this.cargo = cargo;
		this.email = email;
	}

	public void editar(ColaboradorModel model) {
		this.nome = model.getNome();
		this.email = model.getEmail();
		this.cargo = model.getCargo();
	}

	protected ColaboradorModel() {
	}
}
