package br.com.rogerio.exemplo_data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExemploData {

	
	//Main teste
	public static void main(String[] args) {
		Date data = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = df.format(data);
		
		
		System.out.println("Sem formata��o: " + data);
		System.out.println("Formatada: " + dataFormatada);
	}
	
	
	
	
	
}
