package model;
import model.TypeComunity;
import model.Problems;
import model.Product;
import model.Representant;

public class Comunity {
	
	private Place place;
	private String name;
	private TypeComunity type;
	private Representant representant;
	private int habitants; 
	private Problems problems;
	private Product[] products;
	
	//constructor
	public Comunity (Place PlaceName, String name, TypeComunity type, int habitants, Problems problems,String nameR, String phone) {        
	                                                             
		this.name = name; 
		this.type = type;
		this.habitants= habitants;
		this.problems = problems;
		representant=new Representant(nameR, phone);
		products=new Product[20];
		
	}
	public Representant getRepresentant() {
        return representant;
    }
	public Product[] getProduct() {
        return products;
    }
	public String listRepresent(){
		String list = "Nombre: "+representant.getName()+". Telefono del representante: "+representant.getPhone();
		
		// return Name: representant.getName() representant.getPhone();
		return list;
	}
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		
		msg+= "Nombre:" + name;
		msg += "\nTipo: " + type;
		
		msg += "\nRepresentante: " + representant;
		msg += "\nHabitantes" + habitants;
		msg += "\nProblemas" + problems;
		String list = "";
		for(int i=0;i<products.length;i++){
			if (products[i]!=null){
				list+="\n "+(i+1)+products[i].toString();
			}
		}
		msg += "\nProductos: " + list;
		
		
		return msg; 
	
	}
	
	
	public String getName () { //metodo analizador da el codigo 
		return this.name;
	}
	public TypeComunity getType () { //metodo analizador da el codigo 
		return this.type;
	}

	public int getHabitants () { //metodo analizador da el codigo 
		return this.habitants;
	}
	public Problems getProblems () { //metodo analizador da el codigo 
		return this.problems;
	}
	
	
	
    // public boolean addRepresentant(Representant newRepresentant) {

		// for (int i = 0; i<representant.length; i++) {
			
			// if (representant[i] == null ){
				
				// representant[i] = newRepresentant;
				
				// return true; 
			// }else{
				// return false;
			// }
			
		// }
			
        // return false;
    // }
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
    public boolean addProduct(Product newProduct) {

		for (int i = 0; i<products.length; i++) {
			
			if (products[i] == null ){
				
				products[i] = newProduct;
				
				return true; 
			}else{
				return false;
			}
			
		}
			
        return false;
    }
  
	
}