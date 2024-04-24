package model;
import model.TypeProduct;

public class Product{
	private Comunity comunity;
	private String name;
	private double percentage;
	private TypeProduct type;
	private String making;
	
	
	public Product(Comunity comunity,String name, double percentage, TypeProduct type, String making){
		this.name=name;
		this.percentage=percentage;
		this.type=type;
		this.making=making;
		
	}
	public String toString() {
		String msg= "";
		
		
		msg+= "Nombre:" + name;
		msg += "\nPorcentaje de productos naturales empleados en su fabricación: %" +percentage;
		msg += "\nTipo: " + type;
		msg += "\nHecho a mano: " + making;
		
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
	public String getMaking () { //metodo analizador da el codigo 
		return this.making;
	}
}