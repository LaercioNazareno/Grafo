package grafo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import arquivo.Leitor;
class VerticeTest {
	
	@Test
	public void getGrau() {
		Leitor.escrever();
		Grafo grafo = Leitor.ler();
		assertTrue(grafo.isConexo());
		assertEquals(2, grafo.getVertices().get(0).getGrau());
	}
	
}
















