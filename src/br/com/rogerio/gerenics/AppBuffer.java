package br.com.rogerio.gerenics;

import java.util.List;
import java.util.ArrayList;

public class AppBuffer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//Aqui instancio dizendo que tipo vai ser meu Buffer que no caso String
		//Ficando assim minha classe de Buffer Generica.
		Buffer<String> buffer = new Buffer<String>();
		
		buffer.adicionar("ABC");
		buffer.adicionar("DEF");
		buffer.adicionar("GHI");
		
		List<String> lista = new ArrayList<String>();
		lista = buffer.getBuffer();
		
		
		for (String s : lista) {
			System.out.println(s);
		}
		
		
	}

}
