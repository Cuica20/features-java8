package com.javier.Java8.finterface;

@FunctionalInterface
public interface Operacion {

	double calcular(double n1, double n2);
	
}
/*Los lambda solo pueden tener una funcion dentro de su clase, la atonacion @FunctionalInterface viene a ser su estandar*/
