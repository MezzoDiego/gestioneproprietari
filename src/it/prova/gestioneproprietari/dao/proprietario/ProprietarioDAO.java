package it.prova.gestioneproprietari.dao.proprietario;

import it.prova.gestioneproprietari.dao.IBaseDAO;
import it.prova.gestioneproprietari.model.Proprietario;

public interface ProprietarioDAO extends IBaseDAO<Proprietario>{
	
	public Proprietario getEagerAutomobili(Long id) throws Exception;

	public int countHowManyProprietariHaveCarsWithYearOfRegistrationSince(Integer anno) throws Exception;
}
