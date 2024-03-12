package com.prologg.logbook.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prologg.logbook.dto.LogBookDTO;
import com.prologg.logbook.dto.LogBookDescriptionDTO;
import com.prologg.logbook.dto.LogBookPeriodDTO;
import com.prologg.logbook.dto.TotalPeriodoDTO;
import com.prologg.logbook.entity.MarcacaoVinculoInicioFim;
import com.prologg.logbook.mapper.MarcacaoVinculoInicioFimMapper;
import com.prologg.logbook.repository.MarcacaoVinculoInicioFimRepository;

@Service
public class MarcacaoVinculoInicioFimService {

	@Autowired
	MarcacaoVinculoInicioFimRepository repository;

	@Autowired
	MarcacaoVinculoInicioFimMapper mapper;

	private List<MarcacaoVinculoInicioFim> findLogBook() {
		return repository.findLogbook();
	}

	public LogBookDescriptionDTO logBook() {

		List<MarcacaoVinculoInicioFim> listVinculo = findLogBook();

		LogBookDescriptionDTO logBookDescription = new LogBookDescriptionDTO();
		logBookDescription.setColaborador("João da Silva");
		logBookDescription.setGeradoEm(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:s")));
		logBookDescription.setPeriodo("01/03/2019 - 10/03/2019");
		logBookDescription.setTituloRelatorio("DIÁRIO DE BORDO");
		logBookDescription.setSubTituloRelatorio("Controle de viagem de Motorista Próprio");

		List<LogBookDTO> listLogBook = new ArrayList<>();
		LogBookDTO logBook = null;

		for (MarcacaoVinculoInicioFim objVinculo : listVinculo) {

			if (logBook == null || !logBook.getDia().equals(objVinculo.getMarcacaoInicio().getDataHoraMarcacao().toLocalDate())) {
				logBook = createLogBook(logBook, objVinculo);
				
				listLogBook.add(logBook);
			} 
			logBook = createPeriod(logBook, objVinculo, logBookDescription);
		}

		logBookDescription.setLogBook(listLogBook);

		return logBookDescription;
	}

	private LogBookDTO createLogBook(LogBookDTO logBook, MarcacaoVinculoInicioFim objVinculo) {
		logBook = new LogBookDTO();
		logBook.setDia(objVinculo.getMarcacaoInicio().getDataHoraMarcacao().toLocalDate());
		return logBook;
	}

	private LogBookDTO createPeriod(LogBookDTO logBook, MarcacaoVinculoInicioFim objVinculo,
			LogBookDescriptionDTO logBookDescription) {

		LogBookPeriodDTO logBookPeriod = new LogBookPeriodDTO();
		logBookPeriod.setDescription(objVinculo.getMarcacaoInicio().getMarcacaoTipo().getCodigo() + " - " + objVinculo.getMarcacaoInicio().getMarcacaoTipo().getNome());
		logBookPeriod.setInicio(objVinculo.getMarcacaoInicio().getDataHoraMarcacao().toLocalTime());
		logBookPeriod.setTermino(objVinculo.getMarcacaoFim().getDataHoraMarcacao().toLocalTime());
		logBook.getPeriodos().add(logBookPeriod);

		totalPeriodo(logBookPeriod, objVinculo.getMarcacaoInicio().getMarcacaoTipo().getCodigo(),
				objVinculo.getMarcacaoInicio().getMarcacaoTipo().getNome(), logBookDescription,
				objVinculo.getMarcacaoInicio().getMarcacaoTipo().getTempoRecomendadoMinutos());

		return logBook;
	}

	private void totalPeriodo(LogBookPeriodDTO logBookPeriod, Integer codigo, String descricao,
			LogBookDescriptionDTO logBookDescription, Integer tempoRecomendado) {

		TotalPeriodoDTO totalPeriodo = null;

		if (logBookDescription.getTotalPeriodo().isEmpty()) {
			totalPeriodo = new TotalPeriodoDTO();
			createTotalPeriodo(totalPeriodo, codigo, descricao, tempoRecomendado, logBookPeriod);

			logBookDescription.getTotalPeriodo().add(totalPeriodo);
		} else {
			Optional<TotalPeriodoDTO> optTotalPeriodo = logBookDescription.getTotalPeriodo().stream().filter(i -> codigo.equals(i.getCodigo())).findFirst();
			if (optTotalPeriodo.isPresent()) {
				totalPeriodo = optTotalPeriodo.get();
				updateTotalPeriodo(totalPeriodo, logBookPeriod);
			} else {
				totalPeriodo = new TotalPeriodoDTO();
				createTotalPeriodo(totalPeriodo, codigo, descricao, tempoRecomendado, logBookPeriod);
				logBookDescription.getTotalPeriodo().add(totalPeriodo);
			}
		}

	}

	private TotalPeriodoDTO createTotalPeriodo(TotalPeriodoDTO totalPeriodo, Integer codigo, String descricao,
			Integer tempoRecomendado, LogBookPeriodDTO logBookPeriod) {

		long minutes = diferencaTempo(logBookPeriod);

		Duration dTempoRecomendado = Duration.ZERO.plusMinutes(tempoRecomendado);
		Duration dTotalPeriodo = Duration.ZERO.plusMinutes(minutes);

		totalPeriodo.setCodigo(codigo);
		totalPeriodo.setDescricao(descricao);
		totalPeriodo.setTempoRecomendado(formatarDuration(dTempoRecomendado));
		totalPeriodo.setTotalPeriodo(formatarDuration(dTotalPeriodo));
		
		long tempoNoturno = calcularTempoNoturnoEmMinutos(logBookPeriod);
		Duration dTempoNoturno = Duration.ZERO.plusMinutes(tempoNoturno);
		
		totalPeriodo.setHorasNoturnasClt(formatarDuration(dTempoNoturno));

		return totalPeriodo;
	}

	private TotalPeriodoDTO updateTotalPeriodo(TotalPeriodoDTO totalPeriodo, LogBookPeriodDTO logBookPeriod) {

		long minutes = diferencaTempo(logBookPeriod);

		Duration dTotalPeriodo = converterStringParaDuration(totalPeriodo.getTotalPeriodo()).plusMinutes(minutes);

		totalPeriodo.setTotalPeriodo(formatarDuration(dTotalPeriodo));
		
		long tempoNoturno = calcularTempoNoturnoEmMinutos(logBookPeriod);
		
		totalPeriodo.setHorasNoturnasClt(formatarDuration(converterStringParaDuration(totalPeriodo.getHorasNoturnasClt()).plusMinutes(tempoNoturno)));

		return totalPeriodo;
	}

	public static String formatarDuration(Duration duration) {
		long horas = duration.toHours();
		long minutos = duration.toMinutesPart();
		long segundos = duration.toSecondsPart();

		return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}

	public static Duration converterStringParaDuration(String duracaoString) {
		String[] partes = duracaoString.split(":");

		long horas = Long.parseLong(partes[0]);
		long minutos = Long.parseLong(partes[1]);
		long segundos = Long.parseLong(partes[2]);

		return Duration.ofHours(horas).plusMinutes(minutos).plusSeconds(segundos);
	}

	private static Long diferencaTempo(LogBookPeriodDTO logBookPeriodo) {
		Duration diferenca;
		if (logBookPeriodo.getInicio().isAfter(logBookPeriodo.getTermino())) {
			diferenca = Duration.between(logBookPeriodo.getInicio(), LocalTime.MAX).plus(Duration.between(LocalTime.MIN, logBookPeriodo.getTermino()));
		} else {
			diferenca = Duration.between(logBookPeriodo.getInicio(), logBookPeriodo.getTermino());
		}

		return diferenca.abs().toMinutes();
	}
	

    public static long calcularTempoNoturnoEmMinutos(LogBookPeriodDTO logBookPeriodo) {
        if ((logBookPeriodo.getInicio().isAfter(LocalTime.of(22, 0)) || logBookPeriodo.getInicio().isBefore(LocalTime.of(5, 0))) ||
            (logBookPeriodo.getTermino().isAfter(LocalTime.of(22, 0)) || logBookPeriodo.getTermino().isBefore(LocalTime.of(5, 0)))) {
           
            return diferencaTempo(logBookPeriodo);
        } else {
            
            return 0;
        }
    }

}
