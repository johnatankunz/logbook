package com.prologg.logbook.dto;

public class MarcacaoVinculoInicioFimDTO {

	private Integer codigo;

	private MarcacaoDTO marcacaoInicio;

	private MarcacaoDTO marcacaoFim;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public MarcacaoDTO getMarcacaoInicio() {
		return marcacaoInicio;
	}

	public void setMarcacaoInicio(MarcacaoDTO marcacaoInicio) {
		this.marcacaoInicio = marcacaoInicio;
	}

	public MarcacaoDTO getMarcacaoFim() {
		return marcacaoFim;
	}

	public void setMarcacaoFim(MarcacaoDTO marcacaoFim) {
		this.marcacaoFim = marcacaoFim;
	}

}
