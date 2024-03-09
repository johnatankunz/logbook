package com.prologg.logbook.dto;

import java.time.LocalDateTime;

public class MarcacaoDTO {

	private Integer codigo;

	private MarcacaoTipoDTO marcacaoTipo;

	private LocalDateTime dataHoraMarcacao;

	private ColaboradorDTO colaborador;

	private String tipoMarcacao;

	public String getTipoMarcacao() {
		return tipoMarcacao;
	}

	public void setTipoMarcacao(String tipoMarcacao) {
		this.tipoMarcacao = tipoMarcacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public MarcacaoTipoDTO getMarcacaoTipo() {
		return marcacaoTipo;
	}

	public void setMarcacaoTipo(MarcacaoTipoDTO marcacaoTipo) {
		this.marcacaoTipo = marcacaoTipo;
	}

	public LocalDateTime getDataHoraMarcacao() {
		return dataHoraMarcacao;
	}

	public void setDataHoraMarcacao(LocalDateTime dataHoraMarcacao) {
		this.dataHoraMarcacao = dataHoraMarcacao;
	}

	public ColaboradorDTO getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorDTO colaborador) {
		this.colaborador = colaborador;
	}

}
