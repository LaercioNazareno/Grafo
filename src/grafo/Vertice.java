package grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	private String nome;
	private String chefe;
	private List<Vertice> adjacente = new ArrayList<>();
	private List<Aresta> arestas = new ArrayList<>();
	
	public Vertice(String nome) {
		this.nome = nome;
	}
	
	public Vertice(String nome, List<Aresta> arestas) {
		this.nome = nome;
		this.arestas = arestas;
	}
	
	public Vertice(String nome, Aresta aresta) {
		this.nome = nome;
		this.arestas.add(aresta);
	}
	
	
	
	public String getChefe() {
		return chefe;
	}

	public void setChefe(String chefe) {
		this.chefe = chefe;
	}

	public Aresta getArestaByTerminal(Vertice terminal) {
		for(Aresta aresta: arestas) {
			if(aresta.getNoTerminal().equals(terminal)) {
				return aresta;
			}
		}
		return null;
	}
	
	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Aresta> getArestas() {
		return arestas;
	}
	
	public boolean isIsolado() {
		return arestas.size() == 0;
	}
	
	public boolean isPendente() {
		return arestas.size() == 1;
		
	}
	
	public int getGrau() {
		return arestas.size();
	}
	
	

	public List<Vertice> getAdjacente() {
		return adjacente;
	}

	public void setAdjacente(List<Vertice> adjacente) {
		this.adjacente = adjacente;
	}

	@Override
	public String toString() {
		
		String mensagem;
		if(chefe==null) {
			mensagem = "\n\nvertice: "+getNome()+ "\tgrau: "+getGrau()+"\n\tarestas";
		
		}else {
			mensagem = "\n\nvertice: "+getNome()+ "\tgrau: "+getGrau()+" chefe: "+getChefe()+"\n\tarestas";
		}			
			
		
		for(Aresta aresta: arestas) {
			mensagem += "\n "+aresta.toString();
		}
		
		return mensagem;
	}
	
	
	
}