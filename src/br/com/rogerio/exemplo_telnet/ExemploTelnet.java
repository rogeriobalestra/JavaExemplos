package br.com.rogerio.exemplo_telnet;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.concurrent.TimeoutException;

import org.apache.commons.net.telnet.TelnetClient;


public class ExemploTelnet {

	private TelnetClient telnet = new TelnetClient();
	private InputStream in;
	private PrintStream out;
	private String log;

	/** CONSTRUTOR */
	public ExemploTelnet() {

	}

	/** CONECTA TELNET */
	public void conectaTelnet() {

		try {
			this.telnet.setConnectTimeout(45000);
			this.telnet.setDefaultTimeout(120000);
			System.out.println("Conectando telnet 10.120.45.114");
			telnet.connect("10.120.45.114", 23);
			this.out = new PrintStream(telnet.getOutputStream());
			this.in = telnet.getInputStream();
			this.log = caracterParada(':');
			System.out.println(log);
			
			//AUTENTICANDO NO LINUX
			//login
			enviaComando("robocqc");
			log = caracterParada(':');
			System.out.print(log);
		
			//senha
			enviaComando("#allegro&");
			log = caracterParada('$');
			System.out.print(log);	
			
			conectaRouter(); //conecta router
			
			//desconectar(); //desconecta Linux e Telnet

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro: " + e);
		}

	}
	
	
	
	/** VARRE TEXTO ATÉ O CARACTER DE PARADA definido */ 
	public String caracterParada(char caracter){
		StringBuilder sb = new StringBuilder();
		try {
			char ch = 0;
			while(  (ch=(char)in.read()) != caracter){
				sb.append(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString() + caracter;
	}
	
	
	/** CONECTA ROUTER */
	public void conectaRouter(){

		try {
			this.telnet.setConnectTimeout(45000);
			this.telnet.setDefaultTimeout(120000);
			//System.out.println("telnet 10.120.44.112");
			telnet.connect("10.120.44.112", 23);
			this.out = new PrintStream(telnet.getOutputStream());
			this.in = telnet.getInputStream();
			this.log = caracterParada(':');
			System.out.print(log);
			
			//AUTENTICANDO NO router
			//login
			enviaComando("cisco");
			log = caracterParada(':');
			System.out.print(log);
		
			//senha
			enviaComando("cisco");
			log = caracterParada('>');
			System.out.print(log);	
			
			
			//envia en
			enviaComando("en");
			log = caracterParada(':');
			System.out.print(log);				
			
			//envia senha mais poder - administrator
			enviaComando("cisco");
			log = caracterParada('#');
			System.out.print(log);			
			
			
			//envia - show ip int brief
			enviaComando("sh ip int b");
			log = caracterParada('#');
			System.out.print(log);				

			//Enter
			enviaComando("");
			log = caracterParada('#');
			System.out.print(log);				

			//Enter
			enviaComando("");
			log = caracterParada('#');
			System.out.print(log);				
			
			desconectarRouter();
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro: " + e);
		}
	}
	
	

	/** ENVIA COMANDO TELNET */
	public void enviaComando(String value) {
		try {
			this.out.println(value);
			this.out.flush();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	
	/** DESCONECTAR */
	public void desconectar(){
		try {
			//LOGOUT LINUX
			enviaComando("");
			log = caracterParada('>');
			System.out.print(log);			
			
			//LOGOUT LINUX
			enviaComando("exit");
			log = caracterParada('\n');
			System.out.print(log);
			System.out.println("Desconectado Linux !");			
			
			//LOGOUT TELNET
			telnet.disconnect();
			System.out.println("Desconectado Telnet!");		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	
	/** DESCONECTAR */
	public void desconectarRouter(){
		try {
			//LOGOUT Router
			enviaComando("quit");
			enviaComando("");
			log = caracterParada('\n');
			System.out.print(log);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	
	
	
}
