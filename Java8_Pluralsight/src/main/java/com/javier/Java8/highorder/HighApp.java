package com.javier.Java8.highorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {
	
	private Function<String,String> convertirMayusculas = x -> x.toUpperCase();
	private Function<String,String> convertirMinusculas = x -> x.toLowerCase();

	public void imprimir(Function<String,String> funcion,String valor){
		System.out.println(funcion.apply(valor));
	}
	
	public Function<String,String> mostrar(String mensaje){
		return(String x) -> mensaje + x;
	}
	
	/*public void filtrar(List<String> lista,Consumer<String> consumidor,int longitud){
		lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);
	}*/
	public void filtrar(List<String> lista,Consumer<String> consumidor,int longitud,String cadena){
		lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);
	}
	
	/*Un predicate es una funion LAMBDA*/
	public Predicate<String> establecerLogicaFiltro(int longitud){
		return texto -> texto.length() < longitud;
	}
	
	public Predicate<String> establecerLogicaFiltro(String cadena){
		return texto -> texto.contains(cadena);
	}
	
	public static void main(String[] args) {

		HighApp app = new HighApp();
		//app.imprimir(app.convertirMayusculas, "javier araujo");
		//app.imprimir(app.convertirMinusculas, "JAVIER ARAUJO");
		String rpta = app.mostrar("hola ").apply("Javier");
		//System.out.println(rpta);
		List<String> lista = new ArrayList<>();
		lista.add("Javier Andres");
		lista.add("Araujo");
		lista.add("Cuadros");
		
		//app.filtrar(lista, System.out::println, 8);
		app.filtrar(lista, System.out::println, 0, "Javier");
	}

}
