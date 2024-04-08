package model;

public class Representant{
	private String nombre;
	private String telefono;
	
	
	public Representant(String nombre,String telefono){
		this.nombre = nombre; 
		this.telefono = telefono;
	}
	
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		msg+= "Nombre:" + nombre;
		msg += "\nTelefono: " + telefono;
		
	}
	public String getNombre () { //metodo analizador da el codigo 
		return this.nombre;
	}
	public String getTelefono () { //metodo analizador da el codigo 
		return this.telefono;
	}
}