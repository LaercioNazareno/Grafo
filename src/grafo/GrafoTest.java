package grafo;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import arquivo.Leitor;

class GrafoTest {
	
	@Test
	public void isAdjacente() {
		Grafo grafo = Leitor.ler();
		assertTrue(grafo.isAdjacente(grafo.getVertices().get(0), grafo.getVertices().get(1)));
	}
	
	@Test
	public void isNotAdjacente() {
		Grafo grafo = Leitor.ler();
		assertTrue(grafo.isAdjacente(grafo.getVertices().get(0), grafo.getVertices().get(1)));
	}
	
	
	
}


















