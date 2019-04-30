package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Vertice> vertices = new ArrayList<>();
	
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
	
	public int getGrau(Vertice vertice) {
		return vertice.getGrau();
	}

	public boolean isIsolado(Vertice vertice) {
		return vertice.isIsolado();
	}
	
	public boolean isRegular() {
		int grau = vertices.get(0).getGrau();
		for(Vertice vertice: vertices) {
			if(grau != vertice.getGrau()) {
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
	
	public boolean isEuleriano() {
		for(Vertice vertice: vertices) {
			if(vertice.getGrau() != 2) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isUnicursal() {
		int qtdImpar = 0;
		
		for(Vertice vertice: vertices) {
			if(vertice.getGrau()%2!=0) {
				qtdImpar++;
			}
		}
		
		return qtdImpar == 2;
	}
	
	public Grafo getComplementar() {
		
		Grafo grafoComplementar = new Grafo();
		for(Vertice vertice: vertices) {
			for(Vertice verticeAdj: vertices) {
				if((vertice.isAdjacente(verticeAdj))) {
					if(!(grafoComplementar.vertices.contains(vertice))) {
						grafoComplementar.vertices.add(vertice);
					}
					if(!(grafoComplementar.vertices.contains(verticeAdj))) {
						grafoComplementar.vertices.add(verticeAdj);
					}
				}
			}
		}
		
		return grafoComplementar;
	}

	public Grafo getAGMPrim(Vertice vertice) {
		
		Grafo agm = new Grafo();
		int borda = 1;
		List<Vertice> verticeAdd = new ArrayList();
		Vertice[] verticesOrdenados = ordenarVertices(vertice);
		int[] custo = new int[vertices.size()];
		custo[0]=0;
		while(borda!=0) {
			Vertice verticeMenorBorda = verticesOrdenados.get(0);
			
		}
		
		return agm;
	}
	
	public Vertice[] ordenarVertices(Vertice verticeInicial){
		
		Vertice[] listaVertices = new Vertice[vertices.size()];
		listaVertices[0] = verticeInicial;
		Vertice vertice = verticeInicial;
		for(int i = 1; i<listaVertices.length;i++){
			vertice = getMenorAresta(vertice);
			listaVertices[i] = 
		}
		
		return listaVertices;
	}
	
	private Vertice getMenorAresta(Vertice vertice) {
		for(Aresta aresta: vertice.arestas) {
			
		}
		
		return vertice;
	}
	
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
		
}






























