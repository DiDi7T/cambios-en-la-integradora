package ui;

import model.Lugar; //asi unimos los archivos 

//se encarga de la interfaz grafica 

public class Ejecutable{
	
	// atributos
	//private Scanner lector; //Los atributos deben de ser privados.
	//relaciones ya que el ejecutable tiene una controladora 
	//private Controladora controller; 
	
	
	public static void main(String [] args){
		Ejecutable exe= new Ejecutable(); 		
		
	}
	
	public Ejecutable () {
		Lugar dodo = new Lugar("nombre","VALLE",23000,"tipo", "foto", 25,"departamento");
		System.out.println(dodo.toString());
	}
	
	
}