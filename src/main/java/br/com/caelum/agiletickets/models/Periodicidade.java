package br.com.caelum.agiletickets.models;

public enum Periodicidade {
	DIARIA(new Diaria()), SEMANAL(new Semanal());
	
	private IPeriodicidade periodicidade;

	Periodicidade(IPeriodicidade periodicidade) {
		this.periodicidade = periodicidade;
		
	}
	
	public IPeriodicidade getPeriodicidade(){
		return periodicidade;
	}
	
	
}
