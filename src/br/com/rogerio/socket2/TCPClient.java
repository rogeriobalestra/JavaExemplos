package br.com.rogerio.socket2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		Socket socket = new Socket("localhost", 25000);
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		
		DataInputStream dis = new DataInputStream(in);
		DataOutputStream dos = new DataOutputStream(out);
		
		dos.writeInt(5);
		int valorIncrementado = dis.readInt();
		
		System.out.println(valorIncrementado);
		
		socket.close();
		
		

	}

}
