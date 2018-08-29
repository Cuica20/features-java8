package com.javier.Java8.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsApp {
	
	private List<String> lista;
	private List<String> numeros;
	
	public StreamsApp(){
		lista = new ArrayList<>();
		lista.add("Javier");
		lista.add("Andres");
		lista.add("Araujo");
		lista.add("Cuadros");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");
		numeros.add("4");
		
	}
	
	public void filtrar(){
		//lista.stream().filter(x -> x.startsWith("A")).forEach(x -> System.out.println(x));
		lista.stream().filter(x -> x.startsWith("A")).forEach(System.out::println);
	}
	
	public void ordenar(){
		//lista.stream().sorted().forEach(System.out::println);//ascendente
		lista.stream().sorted((x,y) -> y.compareTo(x)).forEach(System.out::println);
	}
	
	public void transformar(){
		//lista.stream().map(String::toUpperCase).forEach(System.out::println);
		//---------------------------------------------------------------------//
		/*for(String x : numeros){
			int num = Integer.parseInt(x)+1;
			System.out.println(num);
		}*/
		numeros.stream().map(x -> Integer.parseInt(x)+1).forEach(System.out::println);
		//---------------------------------------------------------------------//
		
		
	}
	
	public void limitar(){
		lista.stream().limit(2).forEach(System.out::println);
	}
	
	public void contar(){
		long x = lista.stream().count();
		System.out.println(x);
	}

	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
		//app.filtrar();
		//app.ordenar();
		//app.transformar();
		//app.limitar();
		app.contar();
		
	}

}
