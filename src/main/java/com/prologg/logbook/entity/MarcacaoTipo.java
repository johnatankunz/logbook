package com.prologg.logbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "marcacao_tipo")
public class MarcacaoTipo {

	@Id
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "tempo_recomendado_minutos")
	private Integer tempoRecomendadoMinutos;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTempoRecomendadoMinutos() {
		return tempoRecomendadoMinutos;
	}

	public void setTempoRecomendadoMinutos(Integer tempoRecomendadoMinutos) {
		this.tempoRecomendadoMinutos = tempoRecomendadoMinutos;
	}

}
