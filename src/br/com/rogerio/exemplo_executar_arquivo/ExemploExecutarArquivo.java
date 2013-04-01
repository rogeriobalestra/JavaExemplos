package br.com.rogerio.exemplo_executar_arquivo;

import java.io.File;

//EXEMPLO EXECUTA ARQUIVO JAVA

public class ExemploExecutarArquivo {

	//main teste
	public static void main(String[] args) {

		try {
			File arquivo = new File("c:/temp/arquivo_teste.txt"); 
			Runtime.getRuntime().exec("cmd.exe /c \"" +arquivo.getAbsolutePath() +"\""); 
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	
}





