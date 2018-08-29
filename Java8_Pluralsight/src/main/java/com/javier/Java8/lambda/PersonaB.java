package com.javier.Java8.lambda;

public interface PersonaB {
	
	default public void hablar(){
		System.out.println("hablando - PersonaB");
	}

}
