package com.javier.Java8.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
	
	private List<Integer> numeros;
	
	public void llenar(){
		numeros = new ArrayList<>();
		for(int i = 0;i<=9; i++){
			numeros.add(i);
		}
	}
	
	public void probarStream(){
		numeros.stream().forEach(System.out::println);
	}
	
	public void probarParalelo(){
		numeros.parallelStream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		ParallelStream app = new ParallelStream();
		
		app.llenar();
		//app.probarStream();
		app.probarParalelo();/*lo hace de forma paralela en forma de hilos*/
	}

}
