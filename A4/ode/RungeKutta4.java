package ode;

import java.util.Arrays;

/**
 * Der klassische Runge-Kutta der Ordnung 4
 * 
 * @author braeckle
 * 
 */
public class RungeKutta4 implements Einschrittverfahren {

	@Override
	/**
	 * {@inheritDoc}
	 * Bei der Umsetzung koennen die Methoden addVectors und multScalar benutzt werden.
	 */
	public double[] nextStep(double[] y_k, double t, double delta_t, ODE ode) {
		//System.out.println("y_k: "+Arrays.toString(y_k));
		
		double[] k1 = 
				multScalar(
						ode.auswerten(t, y_k), 
						delta_t
						);
		
		//System.out.println("k1: "+Arrays.toString(k1));
		
		double[] k2 = 
				multScalar(
					ode.auswerten(
							t + 0.5 * delta_t, 
							addVectors(
									y_k, 
									multScalar(k1, 0.5)
									)
							),
					delta_t
					);
		
		//System.out.println("k2: "+Arrays.toString(k2));
		
		double[] k3 =
				multScalar(
					ode.auswerten(
							t + 0.5 * delta_t, 
							addVectors(
									y_k, 
									multScalar(k2, 0.5)
									)
							),
					delta_t
					);
		
		//System.out.println("k3: "+Arrays.toString(k3));
		
		double[] k4 = 
				multScalar(
					ode.auswerten(
							t + delta_t, 
							addVectors(
									y_k, 
									k3
									)
							),
					delta_t
					);
		
		//System.out.println("k4: "+Arrays.toString(k4));
		
		double[] multScalarKs = multScalar(
				addVectors(
						addVectors(
								addVectors(k1, 
										addVectors(k2, k2)),
								addVectors(k3, k3)),
						k4),
				1.0/6);
		
		//System.out.println("multScalarKs: "+Arrays.toString(multScalarKs));
		
		y_k = 
				addVectors(
						y_k, 
						multScalarKs
						);
		
		//System.out.println("y_k with delta: "+Arrays.toString(y_k));
		
		
		return Arrays.copyOf(y_k, y_k.length);
	}

	/**
	 * addiert die zwei Vektoren a und b
	 */
	public static double[] addVectors(double[] a, double[] b) {
		double[] erg = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			erg[i] = a[i] + b[i];
		}
		return erg;
	}

	/**
	 * multipliziert den Skalar scalar auf den Vektor a
	 */
	public static double[] multScalar(double[] a, double scalar) {
		double[] erg = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			erg[i] = scalar * a[i];
		}
		return erg;
	}

}
