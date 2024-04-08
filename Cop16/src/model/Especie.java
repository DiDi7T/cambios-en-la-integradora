package model;
import model.TipoEspecie;
public class Especie {

    private String nombre;
	private TipoEspecie tipo;
	private String foto;
	private int cantidad;

    public Especie(String nombre, TipoEspecie tipo, String foto, int cantidad ) {
        this.nombre = nombre;
		this.tipo = tipo;
		this.foto = foto;
		this.cantidad = cantidad;
    }

    

    public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		msg+= "Nombre:" + nombre;
		msg += "\nTipo: " + tipo;
		msg += "\nFoto: " + foto;
		msg += "\nCantidad: " + cantidad;
		return msg; 
	}
	
	public String getNombre() {
        return nombre;
    }
	public TipoEspecie getTipo() {
        return tipo;
    }
	public String getFoto() {
        return foto;
    }
	public int getCantidad() {
        return cantidad;
    }
}