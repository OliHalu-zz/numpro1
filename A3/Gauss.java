import java.util.Arrays;



public class Gauss {

	/**
	 * Diese Methode soll die Loesung x des LGS R*x=b durch
	 * Rueckwaertssubstitution ermitteln.
	 * PARAMETER: 
	 * R: Eine obere Dreiecksmatrix der Groesse n x n 
	 * b: Ein Vektor der Laenge n
	 */
	public static double[] backSubst(double[][] R, double[] b) {
		//TODO: Diese Methode ist zu implementieren
		int n = b.length-1;
		
		double[] result = new double[n+1];
		result[n] = b[n]/R[n][n]; //init
		
		for(int i=n-1;i>=0;--i){
			
			double sum = 0.;
			for(int j=i+1;j<=n;++j){
				sum += R[i][j]*result[j];
			}
			
			result[i] = (b[i] - sum)/R[i][i];
		}
		
		return result;
	}
	
	/**
	 * @return True if matrix is not singular
	 */
	private static boolean triangulateMatrix(double[][] cA){
		for(int k=0; k<cA.length-1;++k){
			double max = 0.;
			int maxIndex = 0;
			for(int i=k;i<cA.length;++i){
				double candidate = Math.abs(cA[i][k]);
				if(candidate > max){
					max = candidate;
					maxIndex = i;
				}
			}
			if(Math.abs(max) <= Util.eps){
				return false;
			}
			
			//swap k and maxIndex:
			if(maxIndex != k){
				double[] tempA = cA[maxIndex];
				cA[maxIndex] = cA[k];
				cA[k] = tempA;
			}
			
			//elimination:
			for(int i=k+1;i<cA.length;i++){
				double mult = cA[i][k]/cA[k][k];
				
				for(int inner_col=k;inner_col<cA[0].length;++inner_col){
					cA[i][inner_col] = cA[i][inner_col] - mult*cA[k][inner_col];
				}
			}
		}
		return Math.abs(cA[cA.length-1][cA.length-1]) > Util.eps;
	}

	public static double[][] copyMatrix(double[][] A, int rowsCount, int columnsCount){	
		double[][] cA = new double[rowsCount][columnsCount];
		for(int i=0;i<Math.min(rowsCount, A.length);++i){
			for(int j=0;j<Math.min(columnsCount, A[0].length);++j){
				cA[i][j] = A[i][j];
			}
		}
		return cA;
	}
 	
	/**
	 * Diese Methode soll die Loesung x des LGS A*x=b durch Gauss-Elimination mit
	 * Spaltenpivotisierung ermitteln. A und b sollen dabei nicht veraendert werden. 
	 * PARAMETER: A:
	 * Eine regulaere Matrix der Groesse n x n 
	 * b: Ein Vektor der Laenge n
	 */
	public static double[] solve(double[][] A, double[] b) {
		//embed b vector into the a matrix 
		double[][] cA = copyMatrix(A, A.length, A.length+1);
		for(int i=0;i<b.length;++i){
			cA[i][A.length] = b[i];
		}
		
		if(!triangulateMatrix(cA)){
			throw new ArithmeticException("Not solvable");
		}
		
		//extract b and A from the combined matrix
		double[][] R = new double[A.length][A.length];
		double[] rB = new double[A.length];
		
		for(int i=0; i<A.length; ++i){
			R[i] = Arrays.copyOf(cA[i], A[i].length);
		}
		for(int i=0; i<cA.length; ++i){
			rB[i] = cA[i][cA[0].length-1];
		}
		
		return Gauss.backSubst(R, rB);
	}

	/**
	 * Diese Methode soll eine Loesung p!=0 des LGS A*p=0 ermitteln. A ist dabei
	 * eine nicht invertierbare Matrix. A soll dabei nicht veraendert werden.
	 * 
	 * Gehen Sie dazu folgendermassen vor (vgl.Aufgabenblatt): 
	 * -Fuehren Sie zunaechst den Gauss-Algorithmus mit Spaltenpivotisierung 
	 *  solange durch, bis in einem Schritt alle moeglichen Pivotelemente
	 *  numerisch gleich 0 sind (d.h. <1E-10) 
	 * -Betrachten Sie die bis jetzt entstandene obere Dreiecksmatrix T und
	 *  loesen Sie Tx = -v durch Rueckwaertssubstitution 
	 * -Geben Sie den Vektor (x,1,0,...,0) zurueck
	 * 
	 * Sollte A doch intvertierbar sein, kann immer ein Pivot-Element gefunden werden(>=1E-10).
	 * In diesem Fall soll der 0-Vektor zurueckgegeben werden. 
	 * PARAMETER: 
	 * A: Eine singulaere Matrix der Groesse n x n 
	 */
	public static double[] solveSing(double[][] A) {
		//TODO: Diese Methode ist zu implementieren
		double[][] cA = copyMatrix(A, A.length, A.length);
		double[] result = new double[A.length];
		
		if(triangulateMatrix(cA)){
			//invertible matrix case:
			return result;
		}
		System.out.println("Matrix cA after triangulation");
		Util.printMatrix(cA);
		
		int vIndex = 0; 
		for(;vIndex<cA.length;++vIndex){
			if(Math.abs(cA[vIndex][vIndex]) < Util.eps){
				break;
			}
		}
		
		double[][] T = copyMatrix(cA, vIndex, vIndex);
		double[] v = new double[vIndex];
		for(int i=0;i<v.length;++i){
			v[i] = -cA[i][vIndex];
		}
		System.out.println("Matrix T");
		Util.printMatrix(T);

		System.out.println("Vector v");
		Util.printVector(v);

		double[] vRes = backSubst(T, v);
		for(int i=0;i<vRes.length;++i){
			result[i] = vRes[i];
		}
		result[vRes.length] = 1;
		
		return result;
	}

	/**
	 * Diese Methode berechnet das Matrix-Vektor-Produkt A*x mit A einer nxm
	 * Matrix und x einem Vektor der Laenge m. Sie eignet sich zum Testen der
	 * Gauss-Loesung
	 */
	public static double[] matrixVectorMult(double[][] A, double[] x) {
		int n = A.length;
		int m = x.length;

		double[] y = new double[n];

		for (int i = 0; i < n; i++) {
			y[i] = 0;
			for (int j = 0; j < m; j++) {
				y[i] += A[i][j] * x[j];
			}
		}

		return y;
	}
}
