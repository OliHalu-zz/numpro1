import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GaussTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBackSubstutions() {
		double[][] r = {{5,3,6},{0,2,3},{0,0,5}};
		double[] b = {1.,2.,15};
		double[] expect = {-1.3,-3.5,3};
		double[] res = Gauss.backSubst(r, b);
		
		assertTrue("Result: "+res+"\nShould: "+expect, Util.vectorCompare(expect, res));
	}
	
	@Test
	public void testGaussElimination(){
		double[][] r = {{7,3,-5},
						{-1,-2,4},
						{-4,1,-3}};
		double[] b = {-12,5,1};
		double[] expect = {-1,0,1};
		double[] res = Gauss.solve(r, b);
		
		assertTrue("Result: "+res+"\nShould: "+expect, Util.vectorCompare(expect, res));
	}
	
	@Test
	public void testGaussEliminationWithoutPivotSearch(){
		double[][] r = {{5,3,6},{0,2,3},{0,0,5}};
		double[] b = {1.,2.,15};
		double[] expect = {-1.3,-3.5,3};
		double[] res = Gauss.solve(r, b);
		
		assertTrue("Result: "+res+"\nShould: "+expect, Util.vectorCompare(expect, res));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testUnsolvableSystem(){
		double[][] r = {{0,3,6},{0,2,3},{0,0,5}};
		double[] b = {1.,2.,15};
		Gauss.solve(r, b);
	}
	
	@Test
	public void testSingularMatrixSolve(){
		double[][] r = {{2, 2, 3}, 
						{6, 6, 9}, 
						{1, 4, 8}};
		double[] expect = {0.6666666666666666,-2.1666666666666666,1};
		double[] res = Gauss.solveSing(r);
		
		assertTrue("Result: "+res+"\nShould: "+expect, Util.vectorCompare(expect, res));
	}

}
