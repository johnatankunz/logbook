package com.prologg.logbook.dto;

public class MarcacaoTipoDTO {

	private Integer codigo;

	private String nome;

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
