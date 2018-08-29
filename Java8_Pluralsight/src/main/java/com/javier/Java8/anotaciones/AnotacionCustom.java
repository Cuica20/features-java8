package com.javier.Java8.anotaciones;

public @interface AnotacionCustom {
	
	String nombre();
	boolean habilitado() default true;

}
