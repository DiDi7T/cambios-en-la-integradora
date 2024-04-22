package model;
import model.TypeSpecie;
public class Specie {
	
	private Place place;
    private String name;
	private TypeSpecie type;
	private String photo;
	private int amount;

    public Specie(Place PlaceName, String name, TypeSpecie type, String photo, int amount ) {
        this.name = name;
		this.type = type;
		this.photo = photo;
		this.amount = amount;
    }

    

    public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		msg+= "Nombre:" + name;
		msg += "\nTipo: " + type;
		msg += "\nFoto: " + photo;
		msg += "\nCantidad: " + amount;
		return msg; 
	}
	
	public String getName() {
        return name;
    }
	public TypeSpecie getType() {
        return type;
    }
	public String getPhoto() {
        return photo;
    }
	public int getAmount() {
        return amount;
    }
	
	public void setPhoto(String photo){
		this.photo = photo;
		
	}
	public void setAmount(int amount){
		this.amount = amount;
		
	}
	public void setType(TypeSpecie type){
		this.type = type;
		
	}
	
}