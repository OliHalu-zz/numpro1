package ode;

import java.util.Arrays;

/**
 * Das Einschrittverfahren von Heun
 * 
 * @author braeckle
 * 
 */
public class Heun implements Einschrittverfahren {

	@Override
	/**
	 * {@inheritDoc} 
	 * Nutzen Sie dabei geschickt den Expliziten Euler.
	 */
	public double[] nextStep(double[] y_k, double t, double delta_t, ODE ode) {
		//TODO: diese Methode ist zu implementieren
		double[] eulerApprox = (new ExpliziterEuler()).nextStep(y_k, t, delta_t, ode); 
		return RungeKutta4.addVectors(y_k, 
				RungeKutta4.multScalar(RungeKutta4.addVectors(ode.auswerten(t, y_k), ode.auswerten(t+delta_t, eulerApprox)), delta_t/2)
				);
	}

}
