public class Test_Gleitpunktzahl {

	public static void main(String[] argv) {
		//testBitFeld();
		 test_Gleitpunktzahl();
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
			
			/** Test4 */
			a.erweitern(10);
			b.erweitern(10);
			a.setInt(13451);
			b.setInt(53179);
			checkref = new BitFeld(19);
			checkref.setInt(66630);
			System.out.println("Test #4: Bitweise Addition");
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
			
			/** Test5 */
			a.erweitern(15);
			b.erweitern(15);
			a.setInt(938190);
			b.setInt(31487);
			checkref = new BitFeld(23);
			checkref.setInt(906703);
			erg = a.sub(b);
			System.out.println("Test #5: Bitweise Subtraktion");
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
	
	public static void checkResult(Gleitpunktzahl gleitref, Gleitpunktzahl gleiterg){
		if (gleiterg.compareAbsTo(gleitref) != 0
				|| gleiterg.vorzeichen != gleitref.vorzeichen) {
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
	
	public static void testGleitpunktzahlSub(Gleitpunktzahl x, Gleitpunktzahl y, Gleitpunktzahl erg){
		try {
			// Berechnung
			Gleitpunktzahl gleiterg = x.sub(y);
			checkResult(gleiterg, erg);
		} catch (Exception e) {
			System.out.print("Exception bei der Auswertung des Ergebnis!!\n");
		}
	}
	
	public static void testDoubleAdd(double fx, double fy){
		System.out.println("Test: Addition " + fx + " + " + fy);
		testGleitpunktzahlAdd(new Gleitpunktzahl(fx), new Gleitpunktzahl(fy), new Gleitpunktzahl(fx + fy));
	}
	
	public static void testDoubleSub(double fx, double fy){
		System.out.println("Test: Substraktion " + fx + " - " + fy);
		testGleitpunktzahlSub(new Gleitpunktzahl(fx), new Gleitpunktzahl(fy), new Gleitpunktzahl(fx - fy));
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
		Gleitpunktzahl.setAnzBitsMantisse(9);
		Gleitpunktzahl.setAnzBitsExponent(8);

		System.out.println((new Gleitpunktzahl(90.6)).toDouble());
		/* Addition */
		System.out.println("Test der Addition mit Gleitpunktzahl");
		
		testDoubleAdd(19.462, 1.552);
		testDoubleAdd(13.571, 5.723);
		testDoubleAdd(-13, 9.123);
		testDoubleAdd(-13.57, -4.3);
		testDoubleAdd(100.999, 10.56);

		System.out.println("Test der Substraktion mit Gleitpunktzahl");
		
		/* Sunstraktion */
		testDoubleSub(45.40, 100.5);
		testDoubleSub(233.43, 10.3);
		testDoubleSub(-45.55, 10.3);
		testDoubleSub(88.3, -10.1);

		/* Sonderfaelle */
		System.out.println("Test der Sonderfaelle mit Gleitpunktzahl");
		
		testGleitpunktzahlAdd(Gleitpunktzahl.getPosInfinite(), Gleitpunktzahl.getPosInfinite(), Gleitpunktzahl.getPosInfinite());
		testGleitpunktzahlAdd(Gleitpunktzahl.getNegInfinite(), Gleitpunktzahl.getPosInfinite(), Gleitpunktzahl.getPosInfinite());
		testGleitpunktzahlAdd(Gleitpunktzahl.getNegInfinite(), Gleitpunktzahl.getNegInfinite(), Gleitpunktzahl.getNegInfinite());
		testGleitpunktzahlAdd(Gleitpunktzahl.getNull(), new Gleitpunktzahl(1.34), new Gleitpunktzahl(1.34));
		testGleitpunktzahlAdd(new Gleitpunktzahl(0.0), new Gleitpunktzahl(1.0 / 0.0), Gleitpunktzahl.getPosInfinite());
		testGleitpunktzahlSub(new Gleitpunktzahl(0.0), new Gleitpunktzahl(1.0 / 0.0), Gleitpunktzahl.getNegInfinite());
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
