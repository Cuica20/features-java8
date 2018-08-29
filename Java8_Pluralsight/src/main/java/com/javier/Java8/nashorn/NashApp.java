package com.javier.Java8.nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashApp {
	
	private ScriptEngineManager m;
	private ScriptEngine e;
	private Invocable invocador;
	
	public NashApp(){
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");/*nombre del motor de nashorn*/
		invocador = (Invocable)e;
	}
	
	/*
	 * No se puede manipular el DOM ni usar alert
	 * */
	
	public void llamarFunciones() throws Exception {
		//e.eval("print('JS desde Java')");
		e.eval(new FileReader("src/main/java/com/javier/Java8/nashorn/archivo.js"));
		
		String rpta = (String) invocador.invokeFunction("calcular", "2","3");
		System.out.println(rpta);
		
		double rpta2 = (double) invocador.invokeFunction("calcular", 2,3);
		System.out.println(rpta2);
	}
	
	public void implementarInterfaz() throws Exception {
		e.eval(new FileReader("src/main/java/com/javier/Java8/nashorn/archivo.js"));
		
		Object implementacion = e.get("hiloImpl");
		Runnable r = invocador.getInterface(implementacion, Runnable.class);
		
		Thread th1 = new Thread(r);
		th1.start();
		
		Thread th2 = new Thread(r);
		th2.start();
	}	
	/*
	 * nashorn es la utilizacion del motor de javascript mediante Java
	 * */

	public static void main(String[] args) throws Exception {
		NashApp app = new NashApp();
		//app.llamarFunciones();
		app.implementarInterfaz();
	}

}
