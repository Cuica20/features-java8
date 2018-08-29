package com.javier.Java8.lambda;

public class DefaultMethod implements PersonaA, PersonaB {
	


	@Override
	public void caminar() {
		System.out.println("Hola");
	}
	
	@Override
	public void hablar(){
		//PersonaA.super.hablar();
		//PersonaB.super.hablar();
		System.out.println("Las interfaces contienen una funcion default, la cual no necesita estar en la clase donde se implementa, para este caso: \n"+
		"Solo para este caso al tener ambos implement la funcion {hablar} se hace un override pa");
	}

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		//app.caminar();
		app.hablar();
	}

}
