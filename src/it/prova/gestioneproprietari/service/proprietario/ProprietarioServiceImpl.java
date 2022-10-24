package it.prova.gestioneproprietari.service.proprietario;

import java.util.List;

import it.prova.gestioneproprietari.dao.proprietario.ProprietarioDAO;
import it.prova.gestioneproprietari.model.Proprietario;

public class ProprietarioServiceImpl implements ProprietarioService {

	private ProprietarioDAO proprietarioDAO;

	@Override
	public void setProprietarioDAO(ProprietarioDAO proprietarioDAO) {
		this.proprietarioDAO = proprietarioDAO;

	}

	@Override
	public List<Proprietario> listAllProprietari() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietario caricaSingoloProprietario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietario caricaSingoloProprietarioConAutomobili(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Proprietario proprietarioInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Proprietario proprietarioInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Proprietario proprietarioInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public int contaQuantiProprietariPossiedonoAutomobileConAnnoImmatricolazioneDa(Integer anno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
