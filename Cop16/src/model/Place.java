package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import model.Specie;
import model.Comunity;


public class Place {
	
	private String name;
	private Department department;
	private double area;
	private TypePlace type; //Pendiente hacer clase numeracion para ripo y para departamento
	private Calendar date;//queda pendiente definir como tomar la fecha usando calendar
	private String photo; 
	private Comunity[] comunity;
	private double resources;
	
	private Specie[] species;
	private int numSpecies = 0;
	
	
	//constructor
	public Place (String name,Department department, double area, TypePlace type, String photo, double resources ) {        
	                                                                 
	
		this.name= name; 
		this.area = area;
		this.type= type;
		this.date = Calendar.getInstance();
		this.photo = photo;
		this.resources = resources;
		this.department = department;
		species = new Specie[50];
		comunity = new Comunity[1];
		
		
	}
	
	public Specie[] getSpecies() {
        return species;
    }
	public Comunity[] getComunity() {
        return comunity;
    }
	
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		
		msg+= "Nombre:" + name;
		msg += "\nDepartamento:" + department;
		msg += "\nArea: " + area;
		msg += "\nTipo: " + type;
		msg += "\nDate: " + new SimpleDateFormat("dd-MM-yyyy").format(date.getTime());
		msg += "\nFoto:" + photo;
		
		msg += "\nComunidad que la cuida: \n"+" Nombre de la comunidad: "comunity.getName()+"\n Tipo de comunidad: "+comunity.getType()+"\n Representante: "+comunity.getRepresentant()
		msg += "\nRecursos:" + resources;
		
		String list = "";
		for(int i=0;i<species.length;i++){
			if (species[i]!=null){
				list+=(i+1)+". "+species[i].getName()+" "+species[i].getAmount()+"\n";
			}
		}
		msg += "\nEspecies: \n" + String.format("%3s %-5s %-5s","N°", "Nombre", "Cantidad de especies","\n")+"\n "+ list;
		
		return msg; 
		
	}
	
	
	public String getName () { //metodo analizador da el codigo 
		return this.name;
	}
	public double getArea () { //metodo analizador da el codigo 
		return this.area;
	}
	public TypePlace getType () { //metodo analizador da el codigo 
		return this.type;
	}
	public Calendar getDate () { //metodo analizador da el codigo 
		return this.date;
	}
	public String getPhoto () { //metodo analizador da el codigo 
		return this.photo;
	}
	public double getResources () { //metodo analizador da el codigo 
		return this.resources;
	}
	public Department getDepartment () { //metodo analizador da el codigo 
		return this.department;
	}
	
	

    // public int getNumberSpecie(Specie species) {
        // int cantidad = 0;
        // for (Specie e : Specie) {
            // if (e != null && e.equals(species)) {
                // cantidad++;
            // }
        // }
        // return cantidad;
    // }
	public int getNumberSpecie() {
        return numSpecies;
    }
	
	
	 /**
     * Descripcion: Añade un nuevo apartamento al arreglo apartamentos
     * pre: El arreglo apartamentos debe estar inicializado
     * pos: El arreglo apartamentos queda modificado con el nuevo apartamento
     * agregado
     * 
     * @param nuevoApartamento Apartamento El apartamento que se va a añadir
     * @return boolean True si se logra añadir el apartamento, False en caso
     *         contrario
     */
    public boolean addSpecie(Specie newSpecie) {

		for (int i = 0; i<species.length; i++) {
			
			if (species[i] == null ){
				
				species[i] = newSpecie;
				
				return true; 
			}
			
		}
			
        return false;
    }
	 /**
     * Descripcion: Calcula el numero de apartamentos disponibles en el Edificio
     * pre: El arreglo apartamentos debe estar inicializado
     * 
     * @return int El numero de apartamentos disponibles en el Edificio
     */
    public int calculateNumberSpecies() {
		
		int amount = 0;
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) { 
				amount+=1;
			}
		}
		return amount;

    }
	
		/**
		Description: This method allows you to search for a place through its name, comparing the entered string with the name
		from the place stored in the array
		pre: the storage array is initialized
		@param name String The name of the place to search
		@return place The searched place
		*/
		
		public Comunity searchComunity (String name) {
			
			for ( int i = 0; i<comunity.length; i++) { 
			
				Comunity temporal = comunity[i]; 
				
				if(temporal!=null){
					
					if (name.equalsIgnoreCase(temporal.getName())) {    
				
						return temporal; 
				
					}
				}
				
			}
			
			return null;  
		}
		
		/**
		 * Descripcion: Añade un nuevo apartamento al arreglo apartamentos
		 * pre: El arreglo apartamentos debe estar inicializado
		 * pos: El arreglo apartamentos queda modificado con el nuevo apartamento
		 * agregado
		 * 
		 * @param nuevoApartamento Apartamento El apartamento que se va a añadir
		 * @return boolean True si se logra añadir el apartamento, False en caso
		 *         contrario
		 */
		public boolean addComunity(Comunity newComunity) {

			for (int i = 0; i<comunity.length; i++) {
				
				if (comunity[i] == null ){
					
					comunity[i] = newComunity;
					
					return true; 
				}
				
			}
		}
      
}


