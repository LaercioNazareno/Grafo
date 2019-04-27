package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Vertice> vertices = new ArrayList<>();
	
	public void showGrafo() {
		for(Vertice vertice: vertices) {
			System.out.println("vertice "+ vertice.getNome()+"\n\tarestas:");
			vertice.showArestas();
		}
	}
	
	public void listVertice() {
		for(Vertice vertice: vertices) {
			System.out.println(vertice.getNome());
		}
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}
	
	public boolean isAdjacente(Vertice vertice1, Vertice vertice2) {
		if(vertices.contains(vertice1)&& vertices.contains(vertice2)) {
			return vertice1.isAdjacente(vertice2);
		}
		return false;
	}
	
	
}






























