package com.prologg.logbook.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "marcacao")
public class Marcacao {

	@Id
	@Column(name = "codigo")
	private Integer codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_tipo_marcacao", referencedColumnName = "codigo")
	private MarcacaoTipo marcacaoTipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cpf_colaborador", referencedColumnName = "cpf")
	private Colaborador colaborador;

	@Column(name = "data_hora_marcacao")
	private LocalDateTime dataHoraMarcacao;

	@Column(name = "tipo_marcacao")
	private String tipoMarcacao;

	public String getTipoMarcacao() {
		return tipoMarcacao;
	}

	public void setTipoMarcacao(String tipoMarcacao) {
		this.tipoMarcacao = tipoMarcacao;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public MarcacaoTipo getMarcacaoTipo() {
		return marcacaoTipo;
	}

	public void setMarcacaoTipo(MarcacaoTipo marcacaoTipo) {
		this.marcacaoTipo = marcacaoTipo;
	}

	public LocalDateTime getDataHoraMarcacao() {
		return dataHoraMarcacao;
	}

	public void setDataHoraMarcacao(LocalDateTime dataHoraMarcacao) {
		this.dataHoraMarcacao = dataHoraMarcacao;
	}

}
