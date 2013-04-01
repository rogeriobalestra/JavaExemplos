package br.com.rogerio.scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LerArquivo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = null;
		
		try {

			sc = new Scanner(new FileReader("c:/lixo/teste.txt")).useDelimiter(";");
			
			while(sc.hasNext()){
				String coluna1 = sc.next();
				String coluna2 = sc.next();
				
				System.out.println(coluna1);
				System.out.println(coluna2);
				
			}	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		
		

	}

}
