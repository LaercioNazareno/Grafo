package arquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

public class Leitor {

	private static List<String> nomes = new ArrayList<String>(); 
	private static FileReader file;
	private static BufferedReader leitor;
	
	public static Grafo ler(String nome) {
		
		Grafo grafo = new Grafo();
		try {
			abrirArquivo(nome);    
			
			String linha = leitor.readLine();
			int qtdVertices = Integer.parseInt(linha);
			
			while(linha!=null) {
				
				linha = leitor.readLine();
				
				if(linha!= null) {
					construirGrafo(linha.split(";"), grafo);
				}
			}
			
			conferir(qtdVertices, grafo);
						
			fecharArquivo();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grafo;
	}
	
	private static boolean conferir(int qtdVertices, Grafo grafo) {
		int tamGrafo = grafo.getVertices().size();
		
		int qtdFalta = qtdVertices-tamGrafo;
		for(int i = 0;i<qtdFalta;i++) {
			grafo.getVertices().add(new Vertice(createNome(qtdFalta)));
		}
		return true;
	}
	
	private static String createNome(int limite) {
		String nome = sortingNome(limite);
		while(nomes.contains(nome)){
			nome = sortingNome(limite);
		}	
		nomes.add(nome);
		return nome;
	}
	
	private static String sortingNome(int limite) {
		Random random = new Random(); 					
		
		StringBuffer sb = new StringBuffer();
		int charInt = random.nextInt(limite)+65;
		char c = (char) charInt;
		return sb.append(c).toString();
	}
	
	
	
	
	
	
	private static void construirGrafo(String[] caract, Grafo grafo) {
		if(grafo.isDirigido()) {
			//TODO construir dirigido
		}else {
			construirVerticeNaoDirigido(caract, grafo);
			
		}
	}
	
	private static void construirVerticeNaoDirigido(String[] caract, Grafo grafo) {
		
		Vertice vertice,terminal;
		
		vertice = getVertice(caract[0], grafo);		
		
		terminal = getVertice(caract[1], grafo);
		
		if(!grafo.getVertices().contains(terminal)) {
			grafo.getVertices().add(terminal);
		}
		terminal.getArestas().add(construirAresta(terminal,vertice, Integer.parseInt(caract[2])));
		terminal.getAdjacente().add(vertice);
		
		if(!grafo.getVertices().contains(vertice)) {
			grafo.getVertices().add(vertice);
		}
		
		vertice.getArestas().add(construirAresta(vertice,terminal, Integer.parseInt(caract[2])));
		vertice.getAdjacente().add(terminal);
	}
	
	private static Aresta construirAresta(Vertice vertice,Vertice terminal, int peso) {
		return new Aresta(vertice,terminal,peso);
	}
	
	private static Vertice getVerticeByName(String string, Grafo grafo) {
		for(Vertice vertice: grafo.getVertices()){
			if(vertice.getNome().equals(string)) {
				return vertice;
			}
		}
		return null;
	}
	
	private static Vertice getVertice(String nome, Grafo grafo) {
		Vertice vertice;
		if(isNewVertice(nome, grafo)) {
			vertice = new Vertice(nome);
		}else {
			vertice = getVerticeByName(nome, grafo);
		}
		return vertice;
	}
	
	private static boolean isNewVertice(String nome, Grafo grafo) {
		if(grafo.getVertices().size() > 0) {
			for(Vertice vertice: grafo.getVertices()){
				if(vertice.getNome().equals(nome)) {
					return false;
				}
			}
		}
		return true;
	}


	private static void setOrientacao(String[] caract, Grafo grafo) {
		if(caract.length == 3) {
			grafo.setDirigido(true);
		}else {
			grafo.setDirigido(false);
		}
		
		
	}
	
	private static void abrirArquivo(String nome) throws IOException{
		file = new FileReader(nome);
		leitor = new BufferedReader(file);
		
	}
	
	private static void fecharArquivo()  throws IOException{
		leitor.close();
	    file.close();
	}
	
}
