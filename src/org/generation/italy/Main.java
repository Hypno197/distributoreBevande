package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String sceltaBevanda, sceltaBeneficenza;
		String conferma = "no";
		String[] bevandeCalde = { "Caffè", "Cioccolata calda", "Cioccolata fondente", "Ginseng", "Ginseng amaro",
				"Orzo", "Cappuccino", "Caffèlatte", "Latte macchiato", "Caffè alla nocciola", "The al limone",
				"The alla pesca", "The verde", "Acqua calda" };
		int[] giacenzaBevCalde = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 0, 50, 50, 50, 1000 };
		double[] prezziBevandeCalde = { 0.5, 1, 1, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 0.8, 0.5, 0.5, 0.5, 0.3 };
		String[] bevandeFredde = { "Loca-Coca", "Loca Zero", "Sprint", "Fantasy", "Primathè Limone", "Primathè Pesca",
				"Acqua Liscia", "Acqua Frizzante", "Bed Rull", "Chin9", "Birra Analcolica", "Ratogade Mirtillo&Pesca",
				"Ratogade Arancia" };
		int[] giacenzaBevFredde = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 0, 50, 50, 50 };
		double[] prezziBevandeFredde = { 1.5, 1.5, 1.5, 1.5, 1.2, 1.2, 0.5, 0.5, 3, 1.5, 3, 2, 2 };
		int codiceUser = 0;
		double importo = 0;
		float creditoInserito = 0;
		double creditoResiduo = 0;
		double donazione = 0;

		// inizio codice
		// scelta bevanda calda/fredda
		System.out.println("Benvenuto al distributore di bevande");
		System.out.println("Prova la nuova ratogade al mirtillo e pesca!");
		do {
			do {
				System.out.println("Scegli fra bevanda calda o fredda!");
				sceltaBevanda = sc.nextLine();
				if (sceltaBevanda.equalsIgnoreCase("calda") || sceltaBevanda.equalsIgnoreCase("fredda"))
					System.out.println("Perfetto! Ora scegli la tua bevanda!");
				else
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
			do {
				do {
					System.out.println("Scegli la tua bevanda");
					codiceUser = sc.nextInt();
					sc.nextLine();
				} while (sceltaBevanda.equalsIgnoreCase("calda") && codiceUser > bevandeCalde.length
						|| sceltaBevanda.equalsIgnoreCase("fredda") && codiceUser > bevandeCalde.length);

				if (sceltaBevanda.equalsIgnoreCase("calda") && giacenzaBevCalde[codiceUser - 1] > 0) {
					System.out.println("Hai scelto " + bevandeCalde[codiceUser - 1] + ". Inserisci "
							+ (prezziBevandeCalde[codiceUser - 1] - creditoResiduo) + "€");
					importo = prezziBevandeCalde[codiceUser - 1] - creditoResiduo;

				} else if (giacenzaBevFredde[codiceUser - 1] > 0) {
					System.out.println("Hai scelto " + bevandeFredde[codiceUser - 1] + ". Inserisci "
							+ (prezziBevandeFredde[codiceUser - 1] - creditoResiduo) + "€");
					importo = prezziBevandeFredde[codiceUser - 1] - creditoResiduo;
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
			System.out.println("Vuoi prendere un'altra bevanda?");
			conferma = sc.nextLine();
		} while (conferma.equalsIgnoreCase("si"));

		if (creditoResiduo > 0) {
			System.out.println("Vuoi donare il resto in beneficenza?");
			sceltaBeneficenza = sc.nextLine();
			if (sceltaBeneficenza.equalsIgnoreCase("si")) {
				System.out.println("Grazie per la tua donazione!");
				donazione = donazione + creditoResiduo;
				creditoResiduo = 0;
			} else
				System.out.println("Hai ricevuto " + creditoResiduo + "€ di resto.");
		}
	}
}
