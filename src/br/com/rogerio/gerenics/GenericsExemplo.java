package br.com.rogerio.gerenics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericsExemplo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> lista = new ArrayList<String>();
		
		lista.add("joao");
		lista.add("maria");
		lista.add("jessica");

		
		for (String s : lista) {
			System.out.println(s);
		}
		

		
		
		
	}
	
}	


