package grafo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import arquivo.Leitor;

class GrafoTest {
//
////
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
//    }
////	
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
//    }
//	
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
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		System.out.println("\n\nComplementar\n");
//		for(int i = 0; i< 1000;i++) {
//			System.out.print("/////");
//		}
//		grafo.getComplementar().showGrafo();
//    }
	
	@Test
	public void AGMKruscal() {
		Grafo grafo = Leitor.ler("completo.txt");
		grafo.aGMKruskal().showGrafo();
	}

	
}