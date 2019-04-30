package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

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
		    
		    int qtdVertices = Integer.parseInt(linha);
			while(linha != null) {
				linha = leitor.readLine();
				if(linha != null) {
					construirGrafo(linha, grafo);
				}
			}
			
			conferir(grafo.getVertices().size(), qtdVertices, grafo);
			
			leitor.close();
		    file.close();
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grafo;
	}
	
	private static void conferir(int tamGrafo, int qtdVertices, Grafo grafo) {
		if(tamGrafo != qtdVertices) {
			
			int qtdFalta = qtdVertices-tamGrafo;
			Random random = new Random(); 					
			for(int i =0;i < qtdFalta; i++) {
				StringBuffer sb = new StringBuffer();
				int charInt = random.nextInt(9)+64;
				char c = (char) charInt;
				grafo.getVertices().add(new Vertice(sb.append(c).toString()));
			}
		}
		
		
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

		Vertice vertice1 = new Vertice("v"+caracteAresta[0]);
		Vertice vertice2 = new Vertice("v"+caracteAresta[1]);

		if(caracteAresta[3] = 1){

			addVertice(grafo, vertice1, new Aresta(vertice1, vertice2, Integer.parseInt(caracteAresta[2]), -1));
			addVertice(grafo, vertice2,new Aresta(vertice1, vertice2, Integer.parseInt(caracteAresta[2]), 1));
		}
		else{
			addVertice(grafo, vertice1, new Aresta(vertice1, vertice2, Integer.parseInt(caracteAresta[2]), 1));
			addVertice(grafo, vertice2,new Aresta(vertice1, vertice2, Integer.parseInt(caracteAresta[2]), -1));
		}
	}
	
	public static void escrever() {

		try {
			File file = new File("grafo.txt");
			OutputStream  output = new FileOutputStream(file);
						
			output.write("3".getBytes());
			output.flush();
			
			output.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
