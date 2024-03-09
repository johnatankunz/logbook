package com.prologg.logbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prologg.logbook.dto.LogBookDescriptionDTO;
import com.prologg.logbook.service.MarcacaoVinculoInicioFimService;

@SpringBootApplication
@RestController
public class MarcacaoVinculoInicioFimController {

	@Autowired
	MarcacaoVinculoInicioFimService service;

	@GetMapping("/logbook")
	public LogBookDescriptionDTO logBook() {
		return service.logBook();
	}
}
