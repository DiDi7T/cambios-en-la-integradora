package model;
import model.TypeComunity;

public class Comunity {
	
	private String nombre;
	private TypeComunity tipo;
	private Representant representante;
	private int habitantes; //Pendiente hacer clase numeracion para ripo y para departamento
	private String[] problemas = new String[4];
	private Product[] producto = new Product[20];
	

	
	
	//constructor
	public Comunity (String nombre, TypeComunity tipo, Representant representante, int habitantes, String[] problemas ) {        
	                                                                 
	
		this.nombre = nombre; 
		this.tipo = tipo;
		this.representante = representante;
		this.habitantes= habitantes;
		this.problemas = problemas;
		
		
		
		
	}
	
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		
		msg+= "Nombre:" + nombre;
		msg += "\nTipo: " + tipo;
		msg += "\nRepresentante: " + representante;
		msg += "\nHabitantes" + habitantes;
		msg += "\nProblemas" + problemas;
		
		
		return msg; 
	
	}
	
	
	public String getNombre () { //metodo analizador da el codigo 
		return this.nombre;
	}
	public TypeComunity getTipo () { //metodo analizador da el codigo 
		return this.tipo;
	}
	public Representant getRepresentante () { //metodo analizador da el codigo 
		return this.representante;
	}
	public int getHabitantes () { //metodo analizador da el codigo 
		return this.habitantes;
	}
	// public problemas getProblemas () { //metodo analizador da el codigo 
		// return this.problemas;
	// }
	
	

  
	
}