package br.com.rogerio.printStream;

import java.io.*;

public class PSDemo {

	public static void main(String args[]) {
		FileOutputStream out;
		PrintStream ps; // declare a print stream object
		try {
			// Create a new file output stream
			out = new FileOutputStream("myfile.txt");

			// Connect print stream to the output stream
			ps = new PrintStream(out);

			ps.println("texto dentro do arquivo");
			System.err.println("Write successfully");
			ps.close();
		} catch (Exception e) {
			System.err.println("Error in writing to file");
		}
	}
}
