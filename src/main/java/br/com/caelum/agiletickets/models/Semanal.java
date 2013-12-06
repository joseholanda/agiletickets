package br.com.caelum.agiletickets.models;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Weeks;

public class Semanal implements IPeriodicidade {

	@Override
	public List<Sessao> criaSessao(Espetaculo espetaculo, LocalDate inicio,
			LocalDate fim, LocalTime horario) {
		int quantidade = Weeks.weeksBetween(inicio, fim).getWeeks();
		
		List<Sessao> sessoes = new ArrayList<Sessao>();
		for (int i = 0; i <= quantidade; i++) {
			Sessao sessao = new Sessao();
			sessao.setTotalIngressos(10);
			sessao.setEspetaculo(espetaculo);
			sessao.setInicio(inicio.toDateTime(horario).plusWeeks(i));
			sessoes.add(sessao);
		}
		return sessoes;
		
	}

}
