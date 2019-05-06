package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	private List<Vertice> vertices = new ArrayList<>();
	private List<Aresta> arestasPrim = new ArrayList<>();
	private boolean isDirigido;
	
	public void showGrafo() {
		String mensagem = isDirigido?"dirigido ":"nao dirigido ";
		for(Vertice vertice: vertices) {
			mensagem +=  vertice.toString();
		}
		System.out.println(mensagem);
	}
	
	public boolean isAdjacente(Vertice vertice, Vertice terminal) {
		for(Aresta aresta: vertice.getArestas()) {
			if(aresta.getNoTerminal().equals(terminal)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isIsolado(Vertice vertice) {
		return vertice.getArestas().isEmpty();
	}
	
	public boolean isIsolado() {
		for(Vertice vertice: vertices) {
			if(vertice.isIsolado()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPendente(Vertice vertice) {
		return vertice.getArestas().size() == 1;
	}
	
	public boolean isPendente() {
		for(Vertice vertice: vertices) {
			if(vertice.getAdjacente().size() == 1) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isRegular() {
		boolean isRegular = true;
		for(int i = 0;i<vertices.size()-1;i++) {
			for(Vertice vertice: vertices) {
				if(!vertices.get(i).equals(vertice)) {
					if(vertice.getArestas().size() != vertices.get(i).getArestas().size()) {
						isRegular = false;
					}
				}
			}
		}
		return isRegular;
	}
	
	public boolean isNulo() {
		
		for(Vertice vertice: vertices) {
			if(vertice.getArestas().size() != 0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isCompleto() {
		boolean isCompleto = true;
		for(Vertice vertice: vertices) {
			for(Vertice terminal: vertices) {
				if(!terminal.equals(vertice)) {
					if(!isAdjacente(vertice,terminal)) {
						isCompleto = false;
					}
				}
			}
		}
		return isCompleto;
	}

	public boolean isConexo() {
		boolean isConexo = true;
		for(Vertice vertice: vertices) {
			if(vertice.getArestas().size() == 0) {
				isConexo = false;			
			}
		}
		return isConexo;
	}
	
	public boolean isEuleriano() {
		for(Vertice vertice : vertices) {
			if(vertice.getGrau()%2!=0) {
				return false;
			}
		}
		return true;
	}

	public Grafo aGMPrim() {
		
		Grafo grafo = new Grafo();
		List<Vertice> verticesCopy = new ArrayList<>();
		
		Aresta[] arestasCopy = copyArestas(vertices);
		ordenarArestas(arestasCopy);      
		
		for(int i = 0;i<arestasCopy.length;i++) {
			
			Vertice terminal = arestasCopy[i].getNoTerminal();
			Vertice vertice = arestasCopy[i].getNoTerminal0();
		
			if(!grafo.getVertices().contains(vertice)||!grafo.getVertices().contains(terminal)) {
				grafo.getVertices().add(vertice);
				grafo.getVertices().add(terminal);
				grafo.arestasPrim.add(arestasCopy[i]);
			}
		}
		grafo.setVertices(verticesCopy);
		return grafo;
				
	}
		
	public void ordenarArestas(Aresta[] arestas) {
		for(int i =0;i<arestas.length-1;i++) {
			for(int j =0;j<arestas.length-1;j++) {
				if(arestas[i].getPeso()<arestas[j].getPeso()) {
					Aresta arestaAux = arestas[i];
					arestas[i] = arestas[j];
					arestas[j] = arestaAux;
				}
			}
		}
	}
	
	public Aresta[] copyArestas(List<Vertice> verticesList){
		
		List<Aresta>  arestasList = new ArrayList<Aresta>();
		for(Vertice vertice: vertices) {
			for(Aresta aresta: vertice.getArestas()) {
				Aresta arestaCopy = new Aresta(aresta.getNoTerminal(),getVerticeByName(vertice.getNome(), verticesList),aresta.getPeso());
				if(verificarAresta(arestaCopy, arestasList)) {
					arestasList.add(arestaCopy);
				}
			}
		}

		Aresta[] arestas = new Aresta[arestasList.size()];
		int i = 0;
		for(Aresta aresta: arestasList) {
			arestas[i] = aresta;
			i++;
		}
		return arestas;
	}
	
	private boolean verificarAresta(Aresta arestaV, List<Aresta> arestaList) {
		for(Aresta aresta: arestaList) {
			if(aresta.getNoTerminal().equals(arestaV.getNoTerminal())||aresta.getNoTerminal().equals(arestaV.getNoTerminal0())) {
				if(aresta.getNoTerminal0().equals(arestaV.getNoTerminal0())||aresta.getNoTerminal().equals(arestaV.getNoTerminal0())) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void showGrafoAGMKruskal() {
		String mensagem = isDirigido?"dirigido ":"nao dirigido ";
		for(Aresta aresta: arestasPrim) {
			mensagem += "\n"+aresta.toString();
		}
		System.out.println(mensagem);
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
		
		Grafo grafoComplemetar = new Grafo();
		
		List<Vertice> verticesComplementares = copyVertices(vertices);
				
		grafoComplemetar.setVertices(verticesComplementares);
		
		for(Vertice vertice: vertices) {
			
			for(Vertice verticeAjd: vertices) {
				
				if(!vertice.equals(verticeAjd)) {
					
					Vertice verticeComplementar = grafoComplemetar.getVerticeByName(vertice.getNome());
					Vertice verticeAdjComplementar = grafoComplemetar.getVerticeByName(verticeAjd.getNome());
					
					if(!verticeComplementar.getAdjacente().contains(verticeAdjComplementar)) {
						
						verticeComplementar.getAdjacente().add(verticeAdjComplementar);
						verticeAdjComplementar.getArestas().add(new Aresta(verticeComplementar));
					
						verticeComplementar.getArestas().add(new Aresta(verticeAdjComplementar));
						verticeAdjComplementar.getAdjacente().add(verticeComplementar);
						
					}
				}
			}
		}
		
		return grafoComplemetar;
	
	}
	
	public boolean isDirigido() {
		return isDirigido;
	}

	private List<Vertice> copyVertices(List<Vertice> verticeList){
		Grafo grafoCopy = new Grafo();
		List<Vertice> verticesCopy = new ArrayList<Vertice>();
		
		for(Vertice vertice: verticeList) {
			Vertice verticeCopy = new Vertice(vertice.getNome());
			verticesCopy.add(verticeCopy);
		}
		
		copyAdj(verticeList,verticesCopy);

		grafoCopy.setVertices(verticesCopy);
		return verticesCopy;
	}
	
	private void copyAdj(List<Vertice> verticeList,  List<Vertice> copyList){
		
		for(Vertice vertice: verticeList) {
			for(Vertice verticeCopy: copyList) {
				if(vertice.getNome().equals(verticeCopy.getNome())) {
					for(Vertice verticeAdj: vertice.getAdjacente()) {
						verticeCopy.getAdjacente().add(getVerticeByName(verticeAdj.getNome(), copyList));
					}
				}
			}
		}
		
	}
	
	public void setDirigido(boolean isDirigido) {
		this.isDirigido = isDirigido;
	}

	public List<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}
	public int getGrauEntrada(Vertice vertice) {
		return vertice.getGrauEntrada();
	}

	public int getGrauSaida(Vertice vertice) {
		return vertice.getGrauSaida();
	}

	public boolean hasCiclo(){
			for(Vertice vertice: vertices) {
					for(Aresta aresta: vertice.getArestas()) {
						if(aresta.getNoTerminal().getNome() == aresta.getNoTerminal0().getNome()){
							return true;
						}
					}
			}
			return false;			
	}
		
	public int getGrau(Vertice vertice) {
		return vertice.getGrau();
	}
	
	public int getGrau() {
		int grau = 0;
		for(Vertice vertice: vertices) {
			grau += vertice.getGrau();
		}
		return grau;
	}
	
	private Vertice getVerticeByName(String nome) {
		for(Vertice vertice: vertices){
			if(vertice.getNome().equals(nome)) {
				return vertice;
			}
		}
		return null;
	}
	
	private Vertice getVerticeByName(String nome, List<Vertice> verticeList) {
		for(Vertice vertice: verticeList){
			if(vertice.getNome().equals(nome)) {
				return vertice;
			}
		}
		return null;
	}
	
}