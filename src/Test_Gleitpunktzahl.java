public class Test_Gleitpunktzahl {

	public static void main(String[] argv) {
		//testBitFeld();
		 test_Gleitpunktzahl();
	}

	private static void testBitFeld() {
		System.out.println("-----------------------------------------");
		System.out.println("Test der Klasse BitFeld");

		/* Test der Addition mit BitFeld */
		try {
			BitFeld a;
			BitFeld b;
			BitFeld checkref;
			BitFeld erg;
			System.out.println("Test der Addition mit BitFeld");
			// Test: Bitweise Addition


			a = new BitFeld(8);
			b = new BitFeld(8);
			a.setInt(148);
			b.setInt(158);

			// Referenzwerte setzen
			checkref = new BitFeld(9);
			checkref.setInt(306);

			// Berechnung
			System.out.println("Test: Bitweise Addition");
			erg = a.add(b);

			// Test, ob Ergebnis korrekt
			if (erg.compareTo(checkref) != 0) {
				printAdd(a.toString(), b.toString());
				printErg(erg.toString(), checkref.toString());
			} else {
				System.out.println("    Richtiges Ergebnis\n");
			}

			/*************
			 * Eigene Tests einfuegen
			 */

		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}

		/* Test der Subtraktion mit BitFeld */
		System.out.println("Test der Subtraktion mit BitFeld");

		try {

			/*************
			 * Eigene Tests einfuegen
			 */

			System.out.println("Eigene Tests einfuegen!!!");
		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}
	}
	
	public static void checkResult(Gleitpunktzahl gleitref, Gleitpunktzahl gleiterg){
		if (gleiterg.compareAbsTo(gleitref) != 0
				|| gleiterg.vorzeichen != gleitref.vorzeichen) {
			//printAdd(x.toString(), y.toString());
			System.out.println("      Ihr Ergebnis lautet:           " + gleitref.toDouble() + " Bool:" + gleitref
					+ "\n      Das Korrekte Ergebnis lautet:  " + gleiterg.toDouble() + " Bool:" + gleiterg + "\n");
		} else {
			System.out.println("    Richtiges Ergebnis\n");
		}
	}
	
	public static void testGleitpunktzahlAdd(Gleitpunktzahl x, Gleitpunktzahl y, Gleitpunktzahl erg){
		try {
			// Berechnung
			Gleitpunktzahl gleiterg = x.add(y);
			checkResult(gleiterg, erg);
		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}
	}
	
	public static void testDoubleAdd(double fx, double fy){
		System.out.println("Test: Addition " + fx + " + " + fy);
		testGleitpunktzahlAdd(new Gleitpunktzahl(fx), new Gleitpunktzahl(fy), new Gleitpunktzahl(fx + fy));
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
		testDoubleAdd(19.462, 1.552);
		testDoubleAdd(13.571, 5.723);
		
		testDoubleAdd(-13, 9.123);
		testDoubleAdd(-13.57, -4.3);
		//testGleitpunktzahlAdd(Gleitpunktzahl.inf, y, erg)

		/* Subtraktion */
		try {
			System.out.println("Test der Subtraktion mit Gleitpunktzahl");

			/*************
			 * Eigene Tests einfuegen
			 */
			System.out.println("Test: Substraktion  x - y");
			x = new Gleitpunktzahl(13.57);
			y = new Gleitpunktzahl(5.723);

			// Referenzwerte setzen
			gleitref = new Gleitpunktzahl(7.847);

			// Berechnung
			//gleiterg = x.sub(y);

			// Test, ob Ergebnis korrekt
			

		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}

		/* Sonderfaelle */
		System.out.println("Test der Sonderfaelle mit Gleitpunktzahl");
		
		testGleitpunktzahlAdd(Gleitpunktzahl.getPosInfinite(), Gleitpunktzahl.getPosInfinite(), Gleitpunktzahl.getPosInfinite());
		testGleitpunktzahlAdd(Gleitpunktzahl.getNegInfinite(), Gleitpunktzahl.getPosInfinite(), Gleitpunktzahl.getPosInfinite());
		testGleitpunktzahlAdd(Gleitpunktzahl.getNegInfinite(), Gleitpunktzahl.getNegInfinite(), Gleitpunktzahl.getNegInfinite());
		testGleitpunktzahlAdd(Gleitpunktzahl.getNull(), new Gleitpunktzahl(1.34), new Gleitpunktzahl(1.34));
		testGleitpunktzahlAdd(new Gleitpunktzahl(0.0), new Gleitpunktzahl(1.0 / 0.0), Gleitpunktzahl.getPosInfinite());
		
		try {
			// Test: Sonderfaelle
			// 0 - inf
			System.out.println("Test: Sonderfaelle");
			x = new Gleitpunktzahl(0.0);
			y = new Gleitpunktzahl(1.0 / 0.0);
			
			boolean n = y.isNaN();
			boolean pi = y.isInfinite();

			// Referenzwerte setzen
			gleitref.mantisse.setInt(0);
			gleitref.exponent.setInt(63);
			gleitref.vorzeichen = true;
			
			boolean n1 = gleitref.isNaN();
			boolean pi1 = gleitref.isInfinite();

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
