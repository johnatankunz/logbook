package com.prologg.logbook.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LogBookDTO {

	private LocalDate dia;

	private List<LogBookPeriodDTO> periodos = new ArrayList<>();

	public List<LogBookPeriodDTO> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<LogBookPeriodDTO> periodos) {
		this.periodos = periodos;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

}
