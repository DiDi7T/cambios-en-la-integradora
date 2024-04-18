package model;
import model.TypeProduct;

public class Product{
	private Comunity comunity;
	private String name;
	private double percentage;
	private TypeProduct type;
	private boolean making;
	
	
	public Product(Comunity comunity,String name, double percentage, TypeProduct type, boolean making){
		this.name=name;
		this.percentage=percentage;
		this.type=type;
		this.making=making;
		
	}
	public String toString() {
		String msg= "";
		
		
		msg+= "Nombre:" + name;
		msg += "\nPorcentaje: " + percentage;
		msg += "\nTipo: " + type;
		msg += "\nFabricacion: " + making;
		
		return msg;
	}
	public String getName () { //metodo analizador da el codigo 
		return this.name;
	}
	public double getPercentage () { //metodo analizador da el codigo 
		return this.percentage;
	}
	public TypeProduct getType () { //metodo analizador da el codigo 
		return this.type;
	}
	public boolean getMaking () { //metodo analizador da el codigo 
		return this.making;
	}
}