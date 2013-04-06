package br.com.rogerio.socket2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(25000);

		Socket clientSocket = serverSocket.accept();
		

		
		InputStream in = clientSocket.getInputStream();
		OutputStream out = clientSocket.getOutputStream();
		
		DataInputStream dis = new DataInputStream(in);
		DataOutputStream dos = new DataOutputStream(out);
		

		
		int valor = dis.readInt();
		System.out.println(valor);
		valor++;
		dos.writeInt(valor);
		
		//Fecha
		clientSocket.close();
		serverSocket.close();
		

	}

}
