public class Test_Gleitpunktzahl {

	public static void main(String[] argv) {
		testBitFeld();
		// test_Gleitpunktzahl();
	}

	private static void testBitFeld() {
		System.out.println("-----------------------------------------");
		System.out.println("Test der Klasse BitFeld");

		/**
		 * ##################
		 * ## Test Additon ##
		 * ##################
		 */
		try {
			BitFeld a;
			BitFeld b;
			BitFeld checkref;
			BitFeld erg;
			System.out.println("Test der Addition mit BitFeld");
			a = new BitFeld(8);
			b = new BitFeld(8);
			
			/** Test1 */
			a.setInt(148);
			b.setInt(158);
			checkref = new BitFeld(9);
			checkref.setInt(306);
			System.out.println("Test #1: Bitweise Addition");
			erg = a.add(b);
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}

			/** Test2 */
			a.setInt(39);
			b.setInt(255);
			checkref = new BitFeld(9);
			checkref.setInt(294);
			System.out.println("Test #2: Bitweise Addition");
			erg = a.add(b);
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}

			/** Test3 */
			a.setInt(255);
			b.setInt(255);
			checkref = new BitFeld(9);
			checkref.setInt(510);
			System.out.println("Test #3: Bitweise Addition");
			erg = a.add(b);
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}

		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}

		
		/**
		 * ######################
		 * ## Test Subtraction ##
		 * ######################
		 */
		try {

			BitFeld a;
			BitFeld b;
			BitFeld checkref;
			BitFeld erg;
			System.out.println("Test der Subktraktion mit BitFeld");
			a = new BitFeld(8);
			b = new BitFeld(8);
			
			/** Test1 */
			a.setInt(134);
			b.setInt(51);
			checkref = new BitFeld(8);
			checkref.setInt(83);
			erg = a.sub(b);
			System.out.println("Test #1: Bitweise Subtraktion");
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}
			
			/** Test2 */
			a.setInt(0);
			b.setInt(0);
			checkref = new BitFeld(8);
			checkref.setInt(0);
			erg = a.sub(b);
			System.out.println("Test #2: Bitweise Subtraktion");
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}
			
			/** Test3 */
			a.setInt(255);
			b.setInt(254);
			checkref = new BitFeld(8);
			checkref.setInt(1);
			erg = a.sub(b);
			System.out.println("Test #3: Bitweise Subtraktion");
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}
			
			/** Test4 */
			a.setInt(255);
			b.setInt(255);
			checkref = new BitFeld(8);
			checkref.setInt(0);
			erg = a.sub(b);
			System.out.println("Test #4: Bitweise Subtraktion");
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}

		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}
	}

	public static void test_Gleitpunktzahl() {

		/**********************************/
		/* Test der Klasse Gleitpunktzahl */
		/**********************************/

		System.out.println("-----------------------------------------");
		System.out.println("Test der Klasse Gleitpunktzahl");

		/*
		 * Verglichen werden die BitFelder fuer Mantisse und Exponent und das
		 * Vorzeichen
		 */
		Gleitpunktzahl.setAnzBitsMantisse(8);
		Gleitpunktzahl.setAnzBitsExponent(6);

		Gleitpunktzahl x;
		Gleitpunktzahl y;
		Gleitpunktzahl gleitref = new Gleitpunktzahl();
		Gleitpunktzahl gleiterg;

		/* Addition */
		System.out.println("Test der Addition mit Gleitpunktzahl");
		try {
			// Test: Addition
			System.out.println("Test: Addition  x + y");
			x = new Gleitpunktzahl(13.57);
			y = new Gleitpunktzahl(5.723);

			// Referenzwerte setzen
			gleitref.mantisse.setInt(155);
			gleitref.exponent.setInt(37);
			gleitref.vorzeichen = false;
			gleitref = new Gleitpunktzahl(19.293);

			// Berechnung
			gleiterg = x.add(y);

			// Test, ob Ergebnis korrekt
			if (gleiterg.compareAbsTo(gleitref) != 0
					|| gleiterg.vorzeichen != gleitref.vorzeichen) {
				printAdd(x.toString(), y.toString());
				printErg(gleiterg.toString(), gleitref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}

		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}

		/* Subtraktion */
		try {
			System.out.println("Test der Subtraktion mit Gleitpunktzahl");

			/*************
			 * Eigene Tests einfuegen
			 */

			System.out.println("Eigene Tests einfuegen!!!");

		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}

		/* Sonderfaelle */
		System.out.println("Test der Sonderfaelle mit Gleitpunktzahl");

		try {
			// Test: Sonderfaelle
			// 0 - inf
			System.out.println("Test: Sonderfaelle");
			x = new Gleitpunktzahl(0.0);
			y = new Gleitpunktzahl(1.0 / 0.0);

			// Referenzwerte setzen
			gleitref.mantisse.setInt(0);
			gleitref.exponent.setInt(63);
			gleitref.vorzeichen = true;

			// Berechnung mit der Methode des Studenten durchfuehren
			gleiterg = x.sub(y);

			// Test, ob Ergebnis korrekt
			if (gleiterg.compareAbsTo(gleitref) != 0
					|| gleiterg.vorzeichen != gleitref.vorzeichen) {
				printSub(x.toString(), y.toString());
				printErg(gleiterg.toString(), gleitref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}

		} catch (Exception e) {
			System.out
					.print("Exception bei der Auswertung des Ergebnis in der Klasse Gleitpunktzahl!!\n");
		}

	}

	private static void printAdd(String x, String y) {
		System.out.println("    Fehler!\n      Es wurde gerechnet:            "
				+ x + " + " + y);
	}

	private static void printSub(String x, String y) {
		System.out.println("    Fehler!\n      Es wurde gerechnet:            "
				+ x + " - " + y + " = \n");
	}

	private static void printErg(String erg, String checkref) {
		System.out.println("      Ihr Ergebnis lautet:           " + erg
				+ "\n      Das Korrekte Ergebnis lautet:  " + checkref + "\n");
	}
}