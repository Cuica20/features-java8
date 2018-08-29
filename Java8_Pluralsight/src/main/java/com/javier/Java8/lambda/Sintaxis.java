package com.javier.Java8.lambda;

public class Sintaxis {
	
	public double probarSintaxis(){
		//Operacion operacion = (double x ,double  y) -> (x + y) / 2;
		//Operacion operacion = (x , y) -> (x + y) / 2;
		//Operacion operacion = (double x,double y) -> {return (x + y) / 2;};
		//Operacion operacion = (x,y) -> {return (x + y) / 2;};
		Operacion operacion = (double x, double y) -> {
			double a = 2.0;
			System.out.println(a);
			return (x + y) /2 + a;
		};
		//Operacion operacion = () -> 2;
		/*Operacion operacion = () -> {
			int x = 2;
			int y = 3;
			return x + y;
		};*/
				
		return operacion.calcular(2, 3);
		//return operacion.calcularPromedio();
	}
	
	public static void main(String... args){
		Sintaxis sintaxis = new Sintaxis();
		System.out.println(sintaxis.probarSintaxis());
	}

}
