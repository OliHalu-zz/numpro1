package ode;

import java.util.Arrays;

/**
 * Das Einschrittverfahren "Expliziter Euler"
 * 
 * @author braeckle
 * 
 */

public class ExpliziterEuler implements Einschrittverfahren {

	public double[] nextStep(double[] y_k, double t, double delta_t, ODE ode) {
		return RungeKutta4.addVectors(y_k, RungeKutta4.multScalar(ode.auswerten(t, y_k), delta_t));
	}

}