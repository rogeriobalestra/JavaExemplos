package br.com.rogerio.ExemploLog4J;


/** AQUI FIZ MINHA PRÓPRIA CLASSE PERSONALISADA USANDO LOG4J
    PARA USÁ-LA, SOMENTE INSTANCIAR A CLASSE E PASSAR OS PARÂMETROS NECESSÁRIOS 
    COMO PEDE O CONSTRUTOR
*/


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class MinhaClassePersonalisadaLog {

	private static Logger logger; 
	FileAppender fileappender;
	
	
	//Construtor
	public MinhaClassePersonalisadaLog(String mensangemLog, String nomeClasse){

		logger = Logger.getLogger(nomeClasse);
		
		try {
			fileappender = new FileAppender(new SimpleLayout(),"SimpleLog.log");
			logger.addAppender(fileappender);//tem que adcionar.
			logger.error(pegaDataAtual() + " [" + nomeClasse + "] " + " \n#### " + mensangemLog);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//Retorna data e hora atual
	private String pegaDataAtual(){
		Locale locale = new Locale("pt", "BR");
		Calendar calendar = Calendar.getInstance(locale); 
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		String dataAtual = formatador.format(calendar.getTime());
		System.out.println(dataAtual);
		
		return dataAtual;
		
	}
	
	
	
	
}
