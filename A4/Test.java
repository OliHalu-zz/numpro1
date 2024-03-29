import java.util.Arrays;

import ode.ExpliziterEuler;
import ode.Funktion;
import ode.Heun;
import ode.ImpliziterEuler;
import ode.ODE;
import ode.RungeKutta4;
import planeten.PlanetenGUI;
import freierfall.FastTransportGui;

public class Test {

	/**
	 * Hier werden die GUIs fuer die Freie-Fall- und die
	 * Planetensystemsimulation gestartet, und einzelne Testfaelle
	 * durchgefuehrt.
	 */
	public static void main(String[] args) {

		/**************************************/
		boolean startPlanetensystem = false;
		boolean startFreierFall = false;

		boolean testExpliziteVerfahren = true;
		boolean testNewton = false;
		boolean testImplEuler = false;
		/**************************************/

		if (startPlanetensystem) {
			new PlanetenGUI().setVisible(true);
		}

		if (startFreierFall) {
			new FastTransportGui().setVisible(true);
		}

		if (testExpliziteVerfahren)
			testExpliziteVerfahren();

		if (testNewton)
			testNewton();

		if (testImplEuler)
			testImplEuler();
	}

	public static void testExpliziteVerfahren() {
		System.out.println("Es folgen ein paar Beispiele, wie Tests aussehen könnten.\n");


		/* Bsp-ODE */
		ODE ode = new ODE() {

			@Override
			public double[] auswerten(double t, double[] y) {
				double[] v = new double[y.length];
				v[0] = 0;
				v[1] = 0 - 9.81 * t; //Fall mit Startgeschwindigkeit 0.
				return v;
			}
		};

		/* Bsp-Startwerte */
		double delta_t = 1;
		double t0 = 0;
		double[] y0 = { 0, 1000 }; // Freier Fall aus 1000m Höhe.



		/* Expl Euler */
		System.out.println("Teste Expliziten Euler.");
		ExpliziterEuler euler = new ExpliziterEuler();
		double[] y = Arrays.copyOf(y0, y0.length);
		double t = t0;
		for (int k = 1; k <= 4; k++) { // 4 Euler Schritte
			y = euler.nextStep(y, t, delta_t, ode);
			System.out.println("y" + k + " = " + y[0]);
			t = t + delta_t;
		}
		System.out.println("Richtig waere: Eigene Beispiele überlegen" );
		

		/* Heun */
		System.out.println("\nTeste Heun.");
		Heun heun = new Heun();
		y = Arrays.copyOf(y0, y0.length);
		t = t0;
		for (int k = 1; k <= 4; k++) {
			y = heun.nextStep(y, t, delta_t, ode);
			System.out.println("y" + k + " = " + y[0]);
			t = t + delta_t;
		}
		System.out.println("Richtig waere: Eigene Beispiele überlegen" );

		
		/* Runge Kutta4 */
		System.out.println("\nTeste Runge-Kutta4.");
		RungeKutta4 rk4 = new RungeKutta4();
		y = Arrays.copyOf(y0, y0.length);
		t = t0;
		for (int k = 1; k <= 4; k++) {
			y = rk4.nextStep(y, t, delta_t, ode);
			System.out.println("y" + k + " = " + y[1]);
			t = t + delta_t;
		}
		System.out.println("Exakt richtig waere: 995.095, 980.38, 960.76, 921.52" );


		System.out.println("*************************************\n");
	}

	public static void testNewton() {

		System.out.println("\nTeste Newton.");

		Funktion f = new Funktion(1, 1) {

			@Override
			public double[] auswerten(double[] x) {
				double[] y = new double[1];
				y[0] = x[0];
				return y;
			}
		};

		double[] x0 = { 0 };
		double eps = 0;
		for (int k = 1; k <= 4; k++) {
			double[] x = ImpliziterEuler.newtonMethod(f, x0, eps, k);
			System.out.println("x" + k + " = " + x[0] + "\tf(x" + k + ") = "
					+ f.auswerten(x)[0]);
		}
		System.out.println("Richtig waere: Eigene Beispiele überlegen" );
		System.out.println("*************************************\n");

	}

	public static void testImplEuler() {

		ODE ode = new ODE() {

			@Override
			public double[] auswerten(double t, double[] y) {
				double[] v = new double[1];
				v[0] = 0;
				return v;
			}
		};

		double delta_t = 0.5;
		double t0 = 1;
		double[] y0 = { 42 };

		/* Impl Euler */
		System.out.println("\nTeste Impliziten Euler.");
		ImpliziterEuler euler = new ImpliziterEuler();
		double[] y = Arrays.copyOf(y0, y0.length);
		double t = t0;
		for (int k = 1; k <= 4; k++) {
			y = euler.nextStep(y, t, delta_t, ode);
			System.out.println("y" + k + " = " + y[0]);
			t = t + delta_t;
		}
		System.out.println("Richtig waere: Eigene Beispiele überlegen" );
		System.out.println("*************************************\n");

	}

}

