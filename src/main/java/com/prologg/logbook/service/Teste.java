package com.prologg.logbook.service;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Teste {
	
    public static void main(String[] args) {
        // Exemplo de uso
        LocalTime tempo1 = LocalTime.of(1, 10);

        Duration resultado = somarLocalTimes(tempo1);
        System.out.println("Resultado da soma: " + formatarDuration(resultado));
        
        LocalTime a = LocalTime.parse("23:00");
        LocalTime b = LocalTime.parse("04:00");
        
       System.out.println(formatarDuration( Duration.between(a, b).abs()));;
    }

    public static Duration somarLocalTimes(LocalTime... tempos) {
        Duration totalDuration = converterStringParaDuration("22:23:40");

        for (LocalTime tempo : tempos) {
            totalDuration = totalDuration.plus(Duration.between(LocalTime.MIDNIGHT, tempo));
        }

        return totalDuration;
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

}
