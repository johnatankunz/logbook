package com.prologg.logbook.dto;

import java.util.ArrayList;
import java.util.List;

public class LogBookDescriptionDTO {

	private String tituloRelatorio;

	private String subTituloRelatorio;

	private String periodo;

	private String colaborador;

	private String geradoEm;

	private List<LogBookDTO> logBook = new ArrayList<>();

	private List<TotalPeriodoDTO> totalPeriodo = new ArrayList<>();

	public List<TotalPeriodoDTO> getTotalPeriodo() {
		return totalPeriodo;
	}

	public void setTotalPeriodo(List<TotalPeriodoDTO> totalPeriodo) {
		this.totalPeriodo = totalPeriodo;
	}

	public String getTituloRelatorio() {
		return tituloRelatorio;
	}

	public void setTituloRelatorio(String tituloRelatorio) {
		this.tituloRelatorio = tituloRelatorio;
	}

	public String getSubTituloRelatorio() {
		return subTituloRelatorio;
	}

	public void setSubTituloRelatorio(String subTituloRelatorio) {
		this.subTituloRelatorio = subTituloRelatorio;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getColaborador() {
		return colaborador;
	}

	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}

	public String getGeradoEm() {
		return geradoEm;
	}

	public void setGeradoEm(String geradoEm) {
		this.geradoEm = geradoEm;
	}

	public List<LogBookDTO> getLogBook() {
		return logBook;
	}

	public void setLogBook(List<LogBookDTO> logBook) {
		this.logBook = logBook;
	}

}
