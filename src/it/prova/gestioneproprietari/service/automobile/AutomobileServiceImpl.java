package it.prova.gestioneproprietari.service.automobile;

import java.util.List;

import it.prova.gestioneproprietari.dao.automobile.AutomobileDAO;
import it.prova.gestioneproprietari.model.Automobile;

public class AutomobileServiceImpl implements AutomobileService {

	private AutomobileDAO automobileDAO;

	@Override
	public void setAutomobileDAO(AutomobileDAO automobileDAO) {
		this.automobileDAO = automobileDAO;

	}

	@Override
	public List<Automobile> listAllAutomobili() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automobile caricaSingolaAutomobile(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Automobile automobileInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idAutomobileInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Automobile> voglioListaAutomobiliConProprietariIlCuiCodiceFiscaleIniziaPer(String input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Automobile> voglioListaConErrori() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
