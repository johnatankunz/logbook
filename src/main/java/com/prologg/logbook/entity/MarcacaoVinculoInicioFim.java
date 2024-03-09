package com.prologg.logbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "marcacao_vinculo_inicio_fim")
public class MarcacaoVinculoInicioFim {

	@Id
	@Column(name = "codigo")
	private Integer codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_marcacao_inicio", referencedColumnName = "codigo")
	private Marcacao marcacaoInicio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_marcacao_fim", referencedColumnName = "codigo")
	private Marcacao marcacaoFim;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Marcacao getMarcacaoInicio() {
		return marcacaoInicio;
	}

	public void setMarcacaoInicio(Marcacao marcacaoInicio) {
		this.marcacaoInicio = marcacaoInicio;
	}

	public Marcacao getMarcacaoFim() {
		return marcacaoFim;
	}

	public void setMarcacaoFim(Marcacao marcacaoFim) {
		this.marcacaoFim = marcacaoFim;
	}

}
