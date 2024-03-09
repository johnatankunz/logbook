package com.prologg.logbook.dto;

import java.time.LocalTime;

public class LogBookPeriodDTO {

	private LocalTime inicio;

	private LocalTime termino;

	private String description;

	public LocalTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}

	public LocalTime getTermino() {
		return termino;
	}

	public void setTermino(LocalTime termino) {
		this.termino = termino;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
