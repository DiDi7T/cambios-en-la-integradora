package model;

public class Product{
	private String nombre;
	private double porcentaje;
	private TypeProduct tipo;
	private boolean fabricacion;
	
	
	public Product(String nombre, double porcentaje, TypeProduct tipo, boolean fabricacion){
		this.nombre=nombre;
		this.porcentaje=porcentaje;
		this.tipo=tipo;
		this.fabricacion=fabricacion;
		
	}
	public String toString() {
		String msg= "";
		
		
		msg+= "Nombre:" + nombre;
		msg += "\nPorcentaje: " + porcentaje;
		msg += "\nTipo: " + tipo;
		msg += "\nFabricacion: " + fabricacion;
	}
	public String getNombre () { //metodo analizador da el codigo 
		return this.nombre;
	}
	public double getPorcentaje () { //metodo analizador da el codigo 
		return this.porcentaje;
	}
	public TypeProduct getTipo () { //metodo analizador da el codigo 
		return this.tipo;
	}
	public boolean getFabricacion () { //metodo analizador da el codigo 
		return this.fabricacion;
	}
}