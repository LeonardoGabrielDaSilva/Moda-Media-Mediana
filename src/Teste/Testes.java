package Teste;

import junit.framework.TestCase;

public class Testes extends TestCase {
	Operacao op = new Operacao();
	
	public void testMedia1() {
		assertEquals(4.0, op.media());
	}

	public void testModa1() {
		assertEquals(4.0, op.moda());
	}

	public void testMediana1() {
		assertEquals(4.0, op.mediana());
	}


	public void testVariancia1() {
		assertEquals(4.64, op.variancia());
	}

	public void testDesvio1() {
		System.out.println(op.desvio());
		
	
	}

}
