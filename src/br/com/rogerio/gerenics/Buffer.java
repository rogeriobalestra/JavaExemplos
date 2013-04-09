package br.com.rogerio.gerenics;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {

	private List<T> lista = new ArrayList<T>();
	
	public void adicionar(T elemento){
		lista.add(elemento);
	}

	public List<T> getBuffer(){
		return lista;
	}
	
	
}
