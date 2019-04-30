package grafo;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import arquivo.Leitor;

class GrafoTest {
	
	@Test
	public void grafoIsolado() {
		Grafo grafo = Leitor.ler();
		assertTrue(grafo.isAdjacente(grafo.getVertices().get(0), grafo.getVertices().get(1)));
	}
	
	@Test
	public void grafoRegular() {
		Grafo grafo = Leitor.ler();
		assertTrue(grafo.isAdjacente(grafo.getVertices().get(0), grafo.getVertices().get(1)));
	}
	
	@Test
	public void grafoCompleto() {
		
	}
	
	@Test
	public void grafoConexo() {
		
	}
	
	@Test
	public void grafoEuleriano() {
		
	}
	
	@Test
	public void grafoUnicursal() {
		
	}
	
	@Test
	public void grafoComplementar() {
		
	}
	
	
	
}