package model;
import java.util.Calendar;
import model.Especie;
import model.TipoLugar;
import model.Departamento;

public class Lugar {
	
	private String nombre;
	private Departamento departamento;
	private double area;
	private TipoLugar tipo; //Pendiente hacer clase numeracion para ripo y para departamento
	private Calendar date;//queda pendiente definir como tomar la fecha usando calendar
	private String foto; 
	private Comunity comunidad;
	private double recursos;
	
	private Especie[] especies = new Especie[50];
	private int numEspecies = 0;
	
	
	//constructor
	public Lugar (String nombre,Departamento departamento, double area, TipoLugar tipo, String foto, double recursos ) {        
	                                                                 
	
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
		msg += "\nDepartamento:" + departamento;
		
		return msg; 
	
	}
	
	
	public String getNombre () { //metodo analizador da el codigo 
		return this.nombre;
	}
	public double getArea () { //metodo analizador da el codigo 
		return this.area;
	}
	public TipoLugar getTipo () { //metodo analizador da el codigo 
		return this.tipo;
	}
	public Calendar getDate () { //metodo analizador da el codigo 
		return this.date;
	}
	public String getFoto () { //metodo analizador da el codigo 
		return this.foto;
	}
	public double getRecursos () { //metodo analizador da el codigo 
		return this.recursos;
	}
	public Departamento getDepartamento () { //metodo analizador da el codigo 
		return this.departamento;
	}
	
	

    public int getNumeroEspecie(Especie especie) {
        int cantidad = 0;
        for (Especie e : especies) {
            if (e != null && e.equals(especie)) {
                cantidad++;
            }
        }
        return cantidad;
    }
	public int getNumeroEspecies() {
        return numEspecies;
    }
	
}


