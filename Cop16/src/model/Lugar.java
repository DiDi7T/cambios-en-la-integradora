package model;
import java.util.Calendar;


public class Lugar {
	
	private String nombre;
	private double area;
	private String tipo; //Pendiente hacer clase numeracion para ripo y para departamento
	private Calendar date;//queda pendiente definir como tomar la fecha usando calendar
	private String foto; 
	private double recursos;
	private String departamento;
	
	
	//constructor
	public Lugar (String nombre, double area, String tipo, String foto, double recursos, String departamento) {        
	                                                                       // en java el atributo no se puede llamar igual a los parametros para poder que funcione añadimos this. codigo o se cambia el nombre del parametro, this es el atributo 
	
		this.nombre = nombre; 
		this.area = area;
		this.tipo= tipo;
		this.date = Calendar.getInstance();
		this.foto = foto;
		this.recursos = recursos;
		this.departamento = departamento;
		
		
		
	}
	
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		
		msg+= "Nombre:" + nombre;
		msg += "\nArea: " + area;
		msg += "\nTipo: " + tipo;
		msg += "\nDate: " + date.getTime();
		msg += "\nFoto:" + foto;
		msg += "\nRecursos:" + recursos;
		msg += "\nDepartamento:" + recursos;
		
		return msg; 
	
	}
	
	public String getNombre () { //metodo analizador da el codigo 
		
		return this.nombre;
		
	}
	public double getArea () { //metodo analizador da el codigo 
		
		return this.area;
		
	}
	
	
}


