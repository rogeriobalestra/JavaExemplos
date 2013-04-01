package br.com.rogerio.ExemploLog4J;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.apache.log4j.*;

public class ExemploLogFile {
	
	
	static Logger logger = Logger.getLogger(ExemploLogFile.class);

	
	//Main Testez
	public static void main(String[] args) throws Exception {
		FileAppender fileappender = new FileAppender(new SimpleLayout(),"SimpleLog.log");

		/*
		logger.addAppender(fileappender);
		logger.info("First Log");  
		logger.info("Second Log");  
		logger.info("Third Log");  
		logger.info("Fourth Log");  
		logger.info("See your SimpleLog.log");
		logger.info("Exiting from the Main method  ");
		logger.warn("Teste Warning");
		logger.error("Testando Erro!");
		*/

		//Pega data
		GregorianCalendar calendar = new GregorianCalendar(); 
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:MM:ss"); 
		String dataAtual = formatador.format(calendar.getTime());
		System.out.println(dataAtual); 
		try {
			
			int x = 100 /0;
			System.out.println(x);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.addAppender(fileappender);//tem que adcionar.
			logger.error(dataAtual + " #### " + e.getMessage());
		}
		

	}
}