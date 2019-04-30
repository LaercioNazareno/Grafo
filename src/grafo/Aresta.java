package grafo;

public class Aresta {
	
	private Vertice noTerminal1;
	private Vertice noTerminal2;
	private int peso;
	private int direcao;
	
	public Aresta(Vertice noTerminal1, Vertice noTerminal2, int peso) {
		this.noTerminal1 = noTerminal1;
		this.noTerminal2 = noTerminal2;
		this.peso = peso;
	}
	
	public Aresta(Vertice noTerminal1, Vertice noTerminal2, int peso, int direcao) {
		this.noTerminal1 = noTerminal1;
		this.noTerminal2 = noTerminal2;
		this.peso = peso;
		this.direcao = direcao;
	}
	
	

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public Vertice getNoTerminal1() {
		return noTerminal1;
	}

	public void setNoTerminal1(Vertice noTerminal1) {
		this.noTerminal1 = noTerminal1;
	}

	public Vertice getNoTerminal2() {
		return noTerminal2;
	}

	public void setNoTerminal2(Vertice noTerminal2) {
		this.noTerminal2 = noTerminal2;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
	
}
