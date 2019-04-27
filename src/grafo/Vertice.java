package grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
	
	private String nome;
	
	public List<Aresta> arestas = new ArrayList<>();
	
	public Vertice(String nome) {
		this.nome = nome;
	}
	
	public void showArestas() {
		for(Aresta aresta : arestas) {
			System.out.println("\t\tpeso "+aresta.getPeso()+ " nos teriminais: "+ aresta.getNoTerminal1().nome+","+aresta.getNoTerminal2().nome);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isAdjacente(Vertice vertice) {
		for(Aresta aresta: arestas) {
			if(aresta.getNoTerminal2().getNome().equals(vertice.getNome())) {
				return true;
			}
		}
		return false;
	}
	
}