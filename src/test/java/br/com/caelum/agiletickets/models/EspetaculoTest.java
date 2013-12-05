package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;


import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Test;

public class EspetaculoTest {

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(5));
	}

	@Test
	public void deveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertTrue(ivete.Vagas(6));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoes() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(1));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(15));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(5, 3));
	}

	@Test
	public void DeveInformarSeEhPossivelReservarAQuantidadeExataDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(3));
		ivete.getSessoes().add(sessaoComIngressosSobrando(4));

		assertTrue(ivete.Vagas(10, 3));
	}

	@Test
	public void DeveInformarSeNaoEhPossivelReservarAQuantidadeDeIngressosDentroDeQualquerDasSessoesComUmMinimoPorSessao() {
		Espetaculo ivete = new Espetaculo();

		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));
		ivete.getSessoes().add(sessaoComIngressosSobrando(2));

		assertFalse(ivete.Vagas(5, 3));
	}

	private Sessao sessaoComIngressosSobrando(int quantidade) {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(quantidade * 2);
		sessao.setIngressosReservados(quantidade);

		return sessao;
	}
	@Test
	public void deveCriarUmaSessaoComInicioEFimNoMesmoDiaParaPeriodicidadeDiaria() {
	
		LocalDate inicio = new LocalDate().withDayOfMonth(4).withMonthOfYear(12).withYear(2013);
		
		LocalTime horario = new LocalTime().withHourOfDay(20).withMinuteOfHour(0);
		
		
		Espetaculo espetaculo = new Espetaculo();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, inicio, horario, Periodicidade.DIARIA);
		// Verifica se foi criada uma Sessão
		Assert.assertEquals(1, sessoes.size());
		// Verifica se Sessão foi criada com data e horário adequados
		Assert.assertEquals(inicio.toDateTime(horario), sessoes.get(0).getInicio());
		
	}
	
	@Test
	public void deveCriarUmaSessaoComInicioEFimNoMesmoDiaParaPeriodicidadeSemanal() {
	
		LocalDate inicio = new LocalDate().withDayOfMonth(4).withMonthOfYear(12).withYear(2013);
		
		LocalTime horario = new LocalTime().withHourOfDay(20).withMinuteOfHour(0);
		
		
		Espetaculo espetaculo = new Espetaculo();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, inicio, horario, Periodicidade.SEMANAL);
		// Verifica se foi criada uma Sessão
		Assert.assertEquals(1, sessoes.size());
		// Verifica se Sessão foi criada com data e horário adequados
		Assert.assertEquals(inicio.toDateTime(horario), sessoes.get(0).getInicio());
		
	}
	
	@Test
	public void deveCriarDuasSessoesParaPeriodoDeDoisDias() {
		LocalDate inicio = new LocalDate();
		LocalDate fim = new LocalDate().plusDays(1);
		LocalTime horario = new LocalTime();
					
		Espetaculo espetaculo = new Espetaculo();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		// Verifica se foi criada uma Sessão
		Assert.assertEquals(3, sessoes.size());
		// Verifica se Sessão foi criada com data e horário adequados
		Assert.assertEquals(inicio.toDateTime(horario), sessoes.get(0).getInicio());
		Assert.assertEquals(inicio.toDateTime(horario).plusDays(1), sessoes.get(1).getInicio());
	}
	
	@Test
	public void deveCriarDuasSessoesParaPeriodoDeCincoSemanas() {
		LocalDate inicio = new LocalDate();
		LocalDate fim = new LocalDate().plusWeeks(4);
		LocalTime horario = new LocalTime();
					
		Espetaculo espetaculo = new Espetaculo();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		// Verifica se foi criada uma Sessão
		Assert.assertEquals(5, sessoes.size());
		// Verifica se Sessão foi criada com data e horário adequados
		
		
		int i = 0;
		for(Sessao sessao: sessoes){
			Assert.assertEquals(sessao.getInicio(), inicio.plusWeeks(i).toDateTime(horario));
			Assert.assertEquals(sessao.getEspetaculo(), espetaculo);
			i++;
		}
	}
	
	@Test
	public void deveRetornarListaVaziaQuandoIncioMaiorQueFimDiario() {
		LocalDate fim = new LocalDate();
		LocalDate inicio = new LocalDate().plusDays(13);
		LocalTime horario = new LocalTime();
		
		Espetaculo espetaculo = new Espetaculo();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.DIARIA);
		Assert.assertEquals(0, sessoes.size());
	}
	
	
	@Test
	public void deveRetornarListaVaziaQuandoIncioMaiorQueFimSemanal() {
		LocalDate fim = new LocalDate();
		LocalDate inicio = new LocalDate().plusDays(13);
		LocalTime horario = new LocalTime();
		
		Espetaculo espetaculo = new Espetaculo();
		List<Sessao> sessoes = espetaculo.criaSessoes(inicio, fim, horario, Periodicidade.SEMANAL);
		Assert.assertEquals(0, sessoes.size());
	}
}
