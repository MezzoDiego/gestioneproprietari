package it.prova.gestioneproprietari.test;

import it.prova.gestioneproprietari.service.MyServiceFactory;
import it.prova.gestioneproprietari.service.automobile.AutomobileService;
import it.prova.gestioneproprietari.service.proprietario.ProprietarioService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import it.prova.gestioneproprietari.dao.EntityManagerUtil;
import it.prova.gestioneproprietari.model.Automobile;
import it.prova.gestioneproprietari.model.Proprietario;

public class TestProprietarioAutomobile {

	public static void main(String[] args) {

		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();

		try {

			System.out.println("------------------------------------------------------------");
			// testInserisciProprietario(proprietarioService);
			System.out.println("------------------------------------------------------------");
			// testInserisciAutomobile(proprietarioService, automobileService);
			System.out.println("------------------------------------------------------------");
			//testRimozioneAutomobile(proprietarioService, automobileService);
			System.out.println("------------------------------------------------------------");
			//testUpdateProprietario(proprietarioService);
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("------------------------------------------------------------");

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	private static void testInserisciProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testInserisciProprietario inizio.............");

		// creo nuovo proprietario
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2022");
		Proprietario nuovoProprietario = new Proprietario("Diego", "Mezzo", "MZZDGI02R01I608P", dataNascita);
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente ");

		// salvo
		proprietarioService.inserisciNuovo(nuovoProprietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito ");

		// check visivo
		System.out.println("\n ################ TEST VISIVO ###############");
		System.out.println("\n " + proprietarioService.listAllProprietari());
		System.out.println("\n ############################################");

		// reset tabella
		proprietarioService.rimuovi(nuovoProprietario);

		System.out.println(".......testInserisciProprietario fine: PASSED.............");
	}

	private static void testInserisciAutomobile(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testInserisciAutomobile inizio.............");

		// creo nuova automobile ma prima mi serve un proprietario
		// creo nuovo proprietario
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2022");
		Proprietario nuovoProprietario = new Proprietario("Diego", "Mezzo", "MZZDGI02R01I608P", dataNascita);
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente ");

		// salvo
		proprietarioService.inserisciNuovo(nuovoProprietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito ");

		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if (listaProprietariPresenti.isEmpty())
			throw new RuntimeException("testInserisciAutomobile fallito: non ci sono proprietari a cui collegarci ");

		Automobile nuovaAutomobile = new Automobile("Nissan", "Qashqai", "DX407FR", 2010);
		// la lego al primo proprietario che trovo
		nuovaAutomobile.setProprietario(listaProprietariPresenti.get(0));

		// salvo la nuova automobile
		automobileService.inserisciNuovo(nuovaAutomobile);

		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovaAutomobile.getId() == null)
			throw new RuntimeException("testInserisciAutomobile fallito ");

		// il test fallisce anche se non è riuscito a legare i due oggetti
		if (nuovaAutomobile.getProprietario() == null)
			throw new RuntimeException("testInserisciAutomobile fallito: non ha collegato il proprietario ");

		// check visivo
		System.out.println("\n ################ TEST VISIVO ###############");
		System.out.println("\n " + automobileService.listAllAutomobili());
		System.out.println("\n ############################################");

		// reset tabella
		automobileService.rimuovi(nuovaAutomobile.getId());
		proprietarioService.rimuovi(nuovoProprietario);

		System.out.println(".......testInserisciAutomobile fine: PASSED.............");
	}

	private static void testRimozioneAutomobile(ProprietarioService proprietarioService,
			AutomobileService automobileService) throws Exception {
		System.out.println(".......testRimozioneAutomobile inizio.............");

		// inserisco un automobile che rimuoverò
		// creo nuova automobile ma prima mi serve un proprietario

		// creo nuovo proprietario
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2022");
		Proprietario nuovoProprietario = new Proprietario("Diego", "Mezzo", "MZZDGI02R01I608P", dataNascita);
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente ");

		// salvo
		proprietarioService.inserisciNuovo(nuovoProprietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito ");

		List<Proprietario> listaProprietariPresenti = proprietarioService.listAllProprietari();
		if (listaProprietariPresenti.isEmpty())
			throw new RuntimeException("testRimozioneAutomobile fallito: non ci sono proprietari a cui collegarci ");

		Automobile nuovaAutomobile = new Automobile("Nissan", "Qashqai", "DX407FR", 2010);
		// lo lego al primo proprietario che trovo
		nuovaAutomobile.setProprietario(listaProprietariPresenti.get(0));

		// salvo la nuova automobile
		automobileService.inserisciNuovo(nuovaAutomobile);

		// check visivo before delete
		System.out.println("\n ################ TEST VISIVO ###############");
		System.out.println("\n BEFORE DELETE:... " + automobileService.listAllAutomobili());
		Long idAutomobileInserito = nuovaAutomobile.getId();
		automobileService.rimuovi(idAutomobileInserito);
		// proviamo a vedere se è stato rimosso
		if (automobileService.caricaSingolaAutomobile(idAutomobileInserito) != null)
			throw new RuntimeException("testRimozioneAutomobile fallito: record non cancellato ");

		// check visivo after delete
		System.out.println("\n AFTER DELETE:... " + automobileService.listAllAutomobili());
		System.out.println("\n ############################################");

		// reset tabella
		proprietarioService.rimuovi(nuovoProprietario);

		System.out.println(".......testRimozioneAutomobile fine: PASSED.............");
	}

	private static void testUpdateProprietario(ProprietarioService proprietarioService) throws Exception {
		System.out.println(".......testUpdateProprietario inizio.............");

		// creo nuovo proprietario
		Date dataNascita = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2022");
		Proprietario nuovoProprietario = new Proprietario("Diego", "Mezzo", "MZZDGI02R01I608P", dataNascita);
		if (nuovoProprietario.getId() != null)
			throw new RuntimeException("testInserisciProprietario fallito: record già presente ");

		// salvo
		proprietarioService.inserisciNuovo(nuovoProprietario);
		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
		// (NOVITA' RISPETTO AL PASSATO!!!)
		if (nuovoProprietario.getId() == null)
			throw new RuntimeException("testInserisciProprietario fallito ");

		// esecuzione query update
		nuovoProprietario.setNome("Mario");
		System.out.println("\n ################ TEST VISIVO ###############");
		System.out.println("\n BEFORE UPDATE:... " + proprietarioService.listAllProprietari());

		proprietarioService.aggiorna(nuovoProprietario);

		System.out.println("\n AFTER UPDATE:... " + proprietarioService.listAllProprietari());
		System.out.println("\n ############################################");

		// reset tabella
		proprietarioService.rimuovi(nuovoProprietario);

		System.out.println(".......testUpdateProprietario fine.............");

	}

}
