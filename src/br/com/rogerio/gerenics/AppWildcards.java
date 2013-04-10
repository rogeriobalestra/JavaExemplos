package br.com.rogerio.gerenics;

import java.util.List;
import java.util.ArrayList;

public class AppWildcards {

	public static void main(String[] args) {

		List<Bebidas> bebidas = new ArrayList<Bebidas>();
		bebidas.add(new Cafe());
		bebidas.add(new Cha());

		preparar(bebidas); //testando metodo comum
		
		
		
		List<Bebidas> bebidas2 = new ArrayList<Bebidas>();
		bebidas2.add(new Cafe());
		bebidas2.add(new Cafe());
		
		preparar2(bebidas2); //testando metodo usando Gererics Wildcards
		
	}


	//Metodo padrão recebendo um lista declaro o tipo de bebidas
	private static void preparar(List<Bebidas> bebidas){
		for (Bebidas b : bebidas) {
			b.preparar();
		}
	}

	//Metodo padrão recebendo um lista declaro o tipo de bebidas
	private static void preparar2(List<?> bebidas){
		for (Object o : bebidas) {
			Cafe c = (Cafe) o;
			c.preparar();
		}
	}

	
	
	
	
}
