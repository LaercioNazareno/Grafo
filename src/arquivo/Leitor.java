package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

public class Leitor {
	
	private static String nome = "grafo.txt";
			
	public static Grafo ler() {
		Grafo grafo = new Grafo();
		try {
			
			FileReader file = new FileReader(nome);
			BufferedReader leitor = new BufferedReader(file);	
		    
			String linha = leitor.readLine();
		    linha = leitor.readLine();
		    
			while(linha != null) {
				construirGrafo(linha, grafo);
				linha = leitor.readLine();
			}
						
			leitor.close();
		    file.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grafo;
	}
	
	private static void construirGrafo(String caract,Grafo grafo) {
		
		String[] aresta = caract.split(";");
		if(aresta.length == 4 ) {
			grafoDirigido(aresta, grafo);
		}else {
			grafoNaoDirigido(aresta, grafo);
		}
	}
	
	private static void addVertice(Grafo grafo, Vertice vertice1, Aresta aresta) {
		
		boolean canAdd = true;
		int index = 0;
		vertice1.arestas.add(aresta);
		
		for(Vertice vertice: grafo.getVertices()) {
			if(vertice.getNome().equals(vertice1.getNome())){
				canAdd = false;
			}
			if(canAdd)
				index++;
		}
		
		if(canAdd) {
			grafo.getVertices().add(vertice1);
		}else {
			grafo.getVertices().get(index).arestas.add(aresta);
		}
		
	}
	
	private static void grafoNaoDirigido(String[] caracteAresta, Grafo grafo) {
		
		Vertice vertice1 = new Vertice("v"+caracteAresta[0]);
		Vertice vertice2 = new Vertice("v"+caracteAresta[1]);
		Aresta aresta = new Aresta(vertice1, vertice2, Integer.parseInt(caracteAresta[2]));
		
		addVertice(grafo, vertice1, aresta);
		addVertice(grafo, vertice2,aresta);

			
	}
	
	private static void grafoDirigido(String[] caracteAresta, Grafo grafo) {
				
	}
	
	public static void escrever() {

		try {
			File file = new File("grafo.txt");
			OutputStream  output = new FileOutputStream(file);
						
			output.write("3\n1;2;4\n1;3;7\n2;3;10".getBytes());
			output.flush();
			
			output.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}