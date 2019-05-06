package grafo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import arquivo.Leitor;

class GrafoTest {

//
//	@Test
//    public void grafoCompleto(){
//		Grafo grafo = Leitor.ler("completo.txt");
//		
//		grafo.showGrafo();
//		
//		assertTrue("Completo",grafo.isCompleto());
//		assertFalse("nulo",grafo.isNulo());
//		assertFalse("Pendente",grafo.isPendente());
//		assertTrue("regular",grafo.isRegular());
//		assertFalse("unicursal",grafo.isUnicursal());
//		System.out.println("\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		System.out.println("\n\nComplementar\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		grafo.getComplementar().showGrafo();
//
//		System.out.print("\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		System.out.print("\nÁrvore Geradora minima\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		grafo.aGMKruskal().showGrafoAGMKruskal();
//    }
//	
//	@Test
//    public void grafoNulo(){
//		Grafo grafo = Leitor.ler("nulo.txt");
//		
//		grafo.showGrafo();
//		
//		assertFalse("Completo",grafo.isCompleto());
//		assertTrue("nulo",grafo.isNulo());
//		assertFalse("Pendente",grafo.isPendente());
//		assertTrue("regular",grafo.isRegular());
//		assertFalse("unicursal",grafo.isUnicursal());
//		System.out.println("\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		System.out.println("\n\nComplementar\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		grafo.getComplementar().showGrafo();
//		
//
//		System.out.print("\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		System.out.print("\nÁrvore Geradora minima\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		grafo.aGMKruskal().showGrafoAGMKruskal();
//		
//    }
//	
//	@Test
//    public void grafoPendente(){
//		Grafo grafo = Leitor.ler("pendente.txt");
//		
//		grafo.showGrafo();
//		
//		assertFalse("Completo",grafo.isCompleto());
//		assertFalse("nulo",grafo.isNulo());
//		assertTrue("Pendente",grafo.isPendente());
//		assertFalse("regular",grafo.isRegular());
//		assertTrue("unicursal",grafo.isUnicursal());
//		System.out.println("\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		System.out.println("\n\nComplementar\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		grafo.getComplementar().showGrafo();
//		
//		System.out.print("\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		System.out.print("\nÁrvore Geradora minima\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		grafo.aGMKruskal().showGrafoAGMKruskal();
//			
//    }
	
//	@Test
//    public void grafoRegular(){
//		Grafo grafo = Leitor.ler("regular.txt");
//		
//		grafo.showGrafo();
//		
//		assertFalse("Completo",grafo.isCompleto());
//		assertFalse("nulo",grafo.isNulo());
//		assertFalse("Pendente",grafo.isPendente());
//		assertTrue("regular",grafo.isRegular());
//		assertFalse("unicursal",grafo.isUnicursal());
//		System.out.println("\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		System.out.println("\n\nComplementar\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		grafo.getComplementar().showGrafo();
//		
//		System.out.print("\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		System.out.print("\nÁrvore Geradora minima\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		grafo.aGMKruskal().showGrafoAGMKruskal();
//    }
//	
//	@Test
//    public void grafoUnicursal(){
//		Grafo grafo = Leitor.ler("unicursal.txt");
//		
//		grafo.showGrafo();
//		
//		assertFalse("Completo",grafo.isCompleto());
//		assertFalse("nulo",grafo.isNulo());
//		assertFalse("Pendente",grafo.isPendente());
//		assertFalse("regular",grafo.isRegular());
//		assertTrue("unicursal",grafo.isUnicursal());
//		System.out.println("\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		System.out.println("\n\nComplementar\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		grafo.getComplementar().showGrafo();
//		
//
//		System.out.print("\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		System.out.print("\nÁrvore Geradora minima\n");
//		for(int i = 0; i< 100;i++) {
//			System.out.print("/////");
//		}
//		grafo.aGMPrim().showGrafoAGMKruskal();
//    }
//	
	@Test
    public void grafoCiclico(){
		Grafo grafo = Leitor.ler("ciclico.txt");
		assertTrue(grafo.hasCiclo());
		grafo.showGrafo();
    }
	
	@Test
    public void grafoAciclico(){
		Grafo grafo = Leitor.ler("aciclico.txt");
		assertFalse(grafo.hasCiclo());
		grafo.showGrafo();
    }
}