package cpm.javier.Java8.methodReference;

import java.util.Arrays;
import java.util.Comparator;

public class MeRefApp {
	
	public static void referenciarMetodoStatic(){
		System.out.println("Método referido static");
	}
	
	public void referenciarMetodoInstanciaObjetoArbitrario(){
		
		String[] nombres = {"Javier","Araujo","Cuadros"};
		
		/*Arrays.sort(nombres,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {				
				return o1.compareToIgnoreCase(o2);
			}
			
		});*/
		
		/*Arrays.sort(nombres,(s1,s2) -> s1.compareToIgnoreCase(s2));*/
		
		Arrays.sort(nombres,String::compareToIgnoreCase);
		System.out.println(Arrays.toString(nombres));
		
	}
	
	public void referenciarMetodoInstanciaObjetoParticular(){
		System.out.println("Método referido instancia de clase");
	}
	
	public void referenciarConstructor(){
		
		/*IPersona iper = new IPersona(){

			@Override
			public Persona crear(int id, String nombre) {
				return new Persona(id,nombre);
			}
			
		};
		iper.crear(1, "Javier");*/
		
		/*IPersona iper2 = (x,y) -> (new Persona(x,y));
		Persona per = iper2.crear(1, "Javier Araujo");*/
		
		IPersona iper3 = Persona::new;
		Persona per = iper3.crear(2, "Javier Araujo");
		System.out.println(per.getId()+"-"+per.getNombre());
		
	}

	public void operar(){
		/*Operacion op = () -> MeRefApp.referenciarMetodoStatic();
		op.saludar();*/
		
		Operacion op2 = MeRefApp::referenciarMetodoStatic;
		op2.saludar();
	}
	
	public static void main(String[] args) {
		MeRefApp app = new MeRefApp();
		app.operar();
		app.referenciarMetodoInstanciaObjetoArbitrario();
		
		Operacion op = app::referenciarMetodoInstanciaObjetoParticular;
		op.saludar();
		
		app.referenciarConstructor();

	}

}
