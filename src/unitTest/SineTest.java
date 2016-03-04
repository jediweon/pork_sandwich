package unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.*;

public class SineTest {
	Variable x;
	Expression sin;

	@Before
	public void setUp() throws Exception {
		x = new Variable("x", Math.PI/4);
		sin = new Sine(new Power(x, new Value(1.0)));
	}

	@Test
	public void testCalc() throws Exception {
		System.out.println(sin.calc());
		assertEquals(sin.calc() , 0.7071067811865475, 0.0000001);
	}
	
	@Test
	public void testderiv() throws Exception {
		assertEquals(sin.derivative(null).calc(), 0.707106781186547524, 0.0000001);
	}

}