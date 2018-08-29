package com.javier.Java8.lambda;

public interface PersonaA {
	
	public void caminar();
	
	default public void hablar(){
		System.out.println("hablando - PersonaA");
	}

}
