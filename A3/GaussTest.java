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
		double[][] r = {{5.,0,0},{3.,2.,0},{6.,3.,5.}};
		double[] b = {1.,2.,15};
		double[] expect = {-1.3,-3.5,3};
		double[] res = Gauss.backSubst(r, b);
		
		assertTrue("Result: "+res+"\nShould: "+expect, Util.vectorCompare(expect, res));
	}

}
