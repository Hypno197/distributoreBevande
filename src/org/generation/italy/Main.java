package org.generation.italy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String sceltaBevanda, sceltaBeneficenza, conferma = "no", password, codiceSicurezza = "ciao123.", adminSel,
				continua;
		String[] bevandeCalde = { "Caffè", "Cioccolata calda", "Cioccolata fondente", "Ginseng", "Ginseng amaro",
				"Orzo", "Cappuccino", "Caffèlatte", "Latte macchiato", "Caffè alla nocciola", "The al limone",
				"The alla pesca", "The verde", "Acqua calda" };
		int[] giacenzaBevCalde = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 0, 50, 50, 50, 1000 };
		double[] prezziBevandeCalde = { 0.5, 1, 1, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 0.5, 0.5, 0.5, 0.3 };
		String[] bevandeFredde = { "Loca-Coca", "Loca Zero", "Sprint", "Fantasy", "Primathè Limone", "Primathè Pesca",
				"Acqua Liscia", "Acqua Frizzante", "Bed Rull", "Chin9", "Birra Analcolica", "Ratogade Mirtillo&Pesca",
				"Ratogade Arancia" };
		ArrayList<String> vendite = new ArrayList<String>();
		int[] giacenzaBevFredde = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 0, 50, 50, 50 };
		double[] prezziBevandeFredde = { 1.5, 1.5, 1.5, 1.5, 1.2, 1.2, 0.5, 0.5, 3, 1.5, 3, 2, 2 };
		int codiceUser = 0, venditaNum = 0;
		double importo = 0;
		float creditoInserito = 0;
		double creditoResiduo = 0;
		double donazione = 0;
		boolean checkPw = false;
		// inizio codice
		// scelta bevanda calda/fredda
		do {
			System.out.println("Benvenuto al distributore di bevande");
			System.out.println("\r\n"
					+ "     _______..___  ___.      ___      .______      .___________..______    __  .___________. _______      _______.\r\n"
					+ "    /       ||   \\/   |     /   \\     |   _  \\     |           ||   _  \\  |  | |           ||   ____|    /       |\r\n"
					+ "   |   (----`|  \\  /  |    /  ^  \\    |  |_)  |    `---|  |----`|  |_)  | |  | `---|  |----`|  |__      |   (----`\r\n"
					+ "    \\   \\    |  |\\/|  |   /  /_\\  \\   |      /         |  |     |   _  <  |  |     |  |     |   __|      \\   \\    \r\n"
					+ ".----)   |   |  |  |  |  /  _____  \\  |  |\\  \\----.    |  |     |  |_)  | |  |     |  |     |  |____ .----)   |   \r\n"
					+ "|_______/    |__|  |__| /__/     \\__\\ | _| `._____|    |__|     |______/  |__|     |__|     |_______||_______/    \r\n"
					+ "                                                                                                                  \r\n"
					+ "");
			System.out.println("Prova la nuova Ratogade al mirtillo e pesca!");
			do { // scelta bevanda un'altra
				do { // verifica input bevanda calda/fredda
					System.out.println("Scegli fra bevanda calda o fredda!");
					sceltaBevanda = sc.nextLine();
					if (sceltaBevanda.equalsIgnoreCase("calda") || sceltaBevanda.equalsIgnoreCase("fredda"))
						System.out.println("Perfetto! Ora scegli la tua bevanda!");

					// scelta gestore e inserimento password
					else if (sceltaBevanda.equalsIgnoreCase("gestore420")) {
						do {
							System.out.println("Inserire password");
							password = sc.nextLine();
							if (password.equals(codiceSicurezza))
								checkPw = true;
						} while (!checkPw);
						// lettura giacenze bevande e avviso
						for (int i = 0; i < giacenzaBevCalde.length; i++)
							if (giacenzaBevCalde[i] < 10)
								System.out.println(bevandeCalde[i] + " è in esaurimento.");
						for (int i = 0; i < giacenzaBevFredde.length; i++)
							if (giacenzaBevFredde[i] < 10)
								System.out.println(bevandeFredde[i] + " è in esaurimento.");
						// lettura registro malfunzionamenti?
						System.out.println("Benvenuto nel menù di gestione del distributore.");
						do {
							System.out.println("Scegli fra: Prezzi, Giacenze, Vendite, Fiscale, Esci.");
							adminSel = sc.nextLine();
							if (adminSel.equalsIgnoreCase("prezzi")) {
								for (int i = 0; i < bevandeCalde.length; i++)
									System.out.println(bevandeCalde[i] + "prezzo: " + prezziBevandeCalde[i]);
								for (int i = 0; i < bevandeFredde.length; i++)
									System.out.println(bevandeFredde[i] + "prezzo: " + prezziBevandeFredde[i]);
								System.out.println("C'è bisogno di effettuare modifiche?");
								String select = sc.nextLine();
								if (select.equalsIgnoreCase("si")) {
									do {
										System.out.println("Scegliere la bevanda da modificare");
										String bevMod = sc.nextLine();
										System.out.println("Prezzo da inserire");
										int prezzoMod = sc.nextInt();
										sc.nextLine();
										for (int i = 0; i < bevandeCalde.length; i++)
											if (bevMod.equalsIgnoreCase(bevandeCalde[i]))
												prezziBevandeCalde[i] = prezzoMod;
										for (int i = 0; i < bevandeFredde.length; i++)
											if (bevMod.equalsIgnoreCase(bevandeFredde[i]))
												prezziBevandeFredde[i] = prezzoMod;
										System.out.println("Continuare con le modifiche?");
										continua = sc.nextLine();
									} while (continua.equals("si"));
								}

							}
							if (adminSel.equalsIgnoreCase("giacenze")) {
								for (int i = 0; i < giacenzaBevCalde.length; i++)
									System.out
											.println(bevandeCalde[i] + " " + giacenzaBevCalde[i] + " unità rimanenti.");
								for (int i = 0; i < giacenzaBevFredde.length; i++)
									System.out.println(
											bevandeFredde[i] + " " + giacenzaBevFredde[i] + " unità rimanenti.");
								do {
									System.out.println("Scegliere la bevanda da caricare");
									String bevCar = sc.nextLine();
									System.out.println("Quantità caricata:");
									int giacMod = sc.nextInt();
									sc.nextLine();
									for (int i = 0; i < bevandeCalde.length; i++)
										if (bevCar.equals(bevandeCalde[i]))
											giacenzaBevCalde[i] += giacMod;
									for (int i = 0; i < bevandeFredde.length; i++)
										if (bevCar.equals(bevandeFredde[i]))
											giacenzaBevFredde[i] += giacMod;
									System.out.println("Continuare con i carichi?");
									continua = sc.nextLine();
								} while (continua.equals("si"));
							}
							if (adminSel.equalsIgnoreCase("vendite")) {
								System.out.println("registro vendite" + vendite.toString());
							}
						} while (!adminSel.equalsIgnoreCase("esci"));

					} else
						System.out.println("Selezione non valida!");

				} while (!sceltaBevanda.equalsIgnoreCase("calda") && !sceltaBevanda.equalsIgnoreCase("fredda"));
				// mostra listino bevande
				if (sceltaBevanda.equalsIgnoreCase("calda")) {
					for (int i = 0; i < bevandeCalde.length; i++) {
						System.out.print("Codice Prodotto " + (i + 1) + " :\n" + bevandeCalde[i]);
						System.out.println(" Prezzo: " + prezziBevandeCalde[i] + "€");
					}

				} else {
					for (int i = 0; i < bevandeFredde.length; i++) {
						System.out.print("Codice Prodotto " + (i + 1) + " :\n" + bevandeFredde[i]);
						System.out.println(" Prezzo: " + prezziBevandeFredde[i] + "€");
					}
				}
				// selezione prodotto
				do { // bevanda terminata
					do { // ciclo verifica codice inserito
						System.out.println("Scegli la tua bevanda");
						codiceUser = sc.nextInt();
						sc.nextLine();
						if (sceltaBevanda.equalsIgnoreCase("calda") && codiceUser > bevandeCalde.length
								|| sceltaBevanda.equalsIgnoreCase("fredda") && codiceUser > bevandeFredde.length)
							System.out.println("Codice non corretto!!");
					} while (sceltaBevanda.equalsIgnoreCase("calda") && codiceUser > bevandeCalde.length
							|| sceltaBevanda.equalsIgnoreCase("fredda") && codiceUser > bevandeFredde.length);

					if (sceltaBevanda.equalsIgnoreCase("calda") && giacenzaBevCalde[codiceUser - 1] > 0) {
						System.out.println("Hai scelto " + bevandeCalde[codiceUser - 1] + ". Inserisci "
								+ (prezziBevandeCalde[codiceUser - 1] - creditoResiduo) + "€");
						importo = prezziBevandeCalde[codiceUser - 1] - creditoResiduo;
						giacenzaBevCalde[codiceUser - 1]--;

					} else if (giacenzaBevFredde[codiceUser - 1] > 0) {
						System.out.println("Hai scelto " + bevandeFredde[codiceUser - 1] + ". Inserisci "
								+ (prezziBevandeFredde[codiceUser - 1] - creditoResiduo) + "€");
						importo = prezziBevandeFredde[codiceUser - 1] - creditoResiduo;
						giacenzaBevFredde[codiceUser - 1]--;
					} else if (giacenzaBevFredde[codiceUser - 1] == 0 || giacenzaBevCalde[codiceUser - 1] == 0)
						System.out.println("La bevanda è terminata!");
					else
						System.out.println("Selezione non valida!");
				} while (giacenzaBevFredde[codiceUser - 1] == 0 || giacenzaBevCalde[codiceUser - 1] == 0);
				// pagamento
				do {
					System.out.print("Credito inserito: ");
					creditoInserito = sc.nextFloat() + creditoInserito;
					sc.nextLine();
					creditoResiduo = creditoInserito - importo;
					System.out.println("Importo residuo: " + creditoResiduo + "€");
				} while (creditoResiduo < 0);
				creditoInserito = 0;
				System.out.println("Ecco la tua bevanda!");
				if (sceltaBevanda.equalsIgnoreCase("calda")) {
					vendite.add("vendita num " + venditaNum + " prodotto: " + bevandeCalde[codiceUser - 1]
							+ " importo: " + prezziBevandeCalde[codiceUser - 1]);
					venditaNum++;
				}
				if (sceltaBevanda.equalsIgnoreCase("fredda")) {
					vendite.add("vendita num " + venditaNum + " prodotto: " + bevandeFredde[codiceUser - 1]
							+ " importo: " + prezziBevandeFredde[codiceUser - 1]);
					venditaNum++;
				}

				System.out.println("Vuoi prendere un'altra bevanda?");
				conferma = sc.nextLine();
			} while (conferma.equalsIgnoreCase("si"));
			// resto/beneficenza
			if (creditoResiduo > 0) {
				System.out.println("Vuoi donare il resto in beneficenza?");
				sceltaBeneficenza = sc.nextLine();
				if (sceltaBeneficenza.equalsIgnoreCase("si")) {
					System.out.println("Grazie per la tua donazione!");
					donazione = donazione + creditoResiduo;
					creditoResiduo = 0;
				} else
					System.out.println("Hai ricevuto " + creditoResiduo + "€ di resto.");
				creditoResiduo = 0;
			}
			System.out.println("Arrivederci!");
		} while (!conferma.equalsIgnoreCase("si"));
	}
}
