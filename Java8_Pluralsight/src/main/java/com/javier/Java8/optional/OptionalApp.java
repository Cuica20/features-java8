package com.javier.Java8.optional;

import java.util.Optional;

public class OptionalApp {
	
	public void probar(String valor){
		//System.out.println(valor.contains("ja"));
		
		try {
			Optional op = Optional.empty();
			op.get();//devuelve tipo de dato	
		} catch (Exception e) {
			System.out.println("No hay elemento");
		}
		
	}
	
	public void orElse(String valor){
		/*Optional<String> op = Optional.of(valor);
		String x = op.get();*/
		Optional<String> op = Optional.ofNullable(valor);
		String x = op.orElse("sin valor");
		System.out.println(x);
	}
	
	public void orElseThrow(String valor){
		Optional<String> op = Optional.ofNullable(valor);
		String x = op.orElseThrow(NumberFormatException::new);
	}
	
	public void isPresent(String valor){
		Optional<String> op = Optional.ofNullable(valor);
		System.out.println(op.isPresent());
	}
	
	public static void main(String[] args){
		OptionalApp app = new OptionalApp();
		//app.probar(null);
		//app.orElse(null);
		//app.orElseThrow(null);
		app.isPresent(null);
	}

}
