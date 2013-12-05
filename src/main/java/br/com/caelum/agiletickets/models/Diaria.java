package br.com.caelum.agiletickets.models;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class Diaria implements IPeriodicidade {

	@Override
	public List<Sessao> criaSessao(Espetaculo espetaculo, LocalDate inicio,
			LocalDate fim, LocalTime horario) {
		int quantidade = Days.daysBetween(inicio, fim).getDays();
		
		List<Sessao> sessoes = new ArrayList<Sessao>();
		for (int i = 0; i <= quantidade; i++) {
			Sessao sessao = new Sessao();
			sessao.setEspetaculo(espetaculo);
			sessao.setInicio(inicio.toDateTime(horario).plusDays(i));
			sessoes.add(sessao);
		}
		return sessoes;
	}

}
