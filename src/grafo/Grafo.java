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
	
	public int getGrau() {
		int grau = 0;
		for(Vertice vertice : vertices) {
			grau +=vertice.getGrau();
		}
		return grau;
	}
	
	public boolean isEuleriano() {
		
		boolean isEuleriano = true;
		for() {
			
		}
		return true;
	}
	
	public boolean isCompleto() {
		for(Vertice vertice: vertices) {
			if(vertice.getGrau() == (vertices.size()-1)) {
				for(Aresta aresta: vertice.arestas) {
					for(Vertice vertice2: vertices) {
						if(!(aresta.getNoTerminal1().equals(vertice) && aresta.getNoTerminal2().equals(vertice2) || 
						  (aresta.getNoTerminal2().equals(vertice)&& aresta.getNoTerminal1().equals(vertice2)))) {
							return false;
						}
					}
				}
			}else {
				return false;
			}
		}
		return false;
	}
	
	public boolean isConexo() {
		for(Vertice vertice: vertices ) {
			if(vertice.getGrau() == 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isNulo() {
		for(Vertice vertice: vertices ) {
			if(vertice.getGrau() > 0) {
				return false;
			}
		}
		return true;
	}
	
}






























