package com.javier.Java8.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {

	private List<String> lista;
	
	public void llenarLista(){		
		lista = new ArrayList<>();
		
		lista.add("Javier");
		lista.add("Araujo");
		lista.add("Cuadros");
		
	}
	
	public void usarForEach(){
		
		//jdk <=1.7
//		for(String elemento: lista){
//			System.out.println(elemento);
//		}
		
//		lista.forEach(x -> System.out.println(x));
		lista.forEach(System.out::println);
		
	}
	
	public void usarRemoveIf(){
		
		/*Iterator<String> it = lista.iterator();
		while(it.hasNext()){
			if(it.next().equalsIgnoreCase("Araujo")){
				it.remove();
			}
		}*/
		
		lista.removeIf(x -> x.equalsIgnoreCase("Cuadros"));
		
	}
	
	public void usarSort(){
		lista.sort((x,y)->x.compareToIgnoreCase(y));
	}
	
	public static void main(String[] args) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();		
		//app.usarRemoveIf();		
		app.usarSort();
		app.usarForEach();
	}

}
