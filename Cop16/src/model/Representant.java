package model;

public class Representant{
	//private Comunity comunity;
	private String name;
	private String phone;
	
	
	public Representant(String name,String phone){
		this.name = name; 
		this.phone = phone;
	}
	
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		msg+= "Nombre:" + name;
		msg += "\nTelefono: " + phone;
		
		return msg;
		
	}
	public String getName () { //metodo analizador da el codigo 
		return this.name;
	}
	public String getPhone () { //metodo analizador da el codigo 
		return this.phone;
	}
}