package grafo;

public class Aresta {
	
	private Vertice noTerminal;
	private Vertice noTerminal0;
	private int peso;
	private String nome;
	private int direcao;
	
	public Aresta(Vertice noTerminal, int peso, int direcao) {
		this.noTerminal = noTerminal;
		this.peso = peso;
		this.direcao = direcao;
	}

	public Aresta(Vertice noTerminal, int peso) {
		this.noTerminal = noTerminal;
		this.peso = peso;
	}
	
	public Aresta(Vertice noTerminal0,Vertice noTerminal, int peso) {
		this.noTerminal = noTerminal;
		this.noTerminal0 = noTerminal0;
		this.peso = peso;
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aresta(Vertice noTerminal) {
		this.noTerminal = noTerminal;
	}
		
	public Vertice getNoTerminal0() {
		return noTerminal0;
	}

	public void setNoTerminal0(Vertice noTerminal0) {
		this.noTerminal0 = noTerminal0;
	}

	public Vertice getNoTerminal() {
		return noTerminal;
	}

	public void setNoTerminal(Vertice noTerminal) {
		this.noTerminal = noTerminal;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	@Override
	public String toString() {
		
		return "\t\tpeso: "+getPeso()+ " \tnos Terminais: "+getNoTerminal0().getNome()+" "+getNoTerminal().getNome();
	}
	
	
	
	
}
