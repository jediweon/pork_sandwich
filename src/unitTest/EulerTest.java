package unitTest;

import static org.junit.Assert.*;

import model.Euler;
import model.Expression;
import org.junit.Before;
import org.junit.Test;

public class EulerTest {
	Expression euler;

	@Before
	public void setUp() throws Exception {
		euler = new Euler();
	}

	@Test
	public void testCalc() throws Exception {
		assertEquals(Math.E, euler.calc(), 0.0000001);
	}

	@Test
	public void testderiv() throws Exception {
		assertEquals(0.0, euler.derivative(null).calc(), 0.0000001);
	}
}
