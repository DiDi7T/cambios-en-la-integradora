package ui;
import java.util.Scanner;
import model.Controladora; //asi unimos los archivos 
import model.Departamento;
//se encarga de la interfaz grafica 

public class Main{
	
	// atributos
	private Scanner lector; //Los atributos deben de ser privados.
	//relaciones ya que el ejecutable tiene una controladora 
	private Controladora controller; 
	private Departamento deparm;
	
	public static void main(String [] args){
		Main exe= new Main(); 
		exe.menu(); // exe es el objeto, la instancia, y a partir de eso se le llama el metodo menu
		
		
		
	}
	
	
	
	 
	public Main () {
		lector= new Scanner(System.in); //Atributo, no variable global.
		
		controller = new Controladora (); 
	}
	
	public void menu(){
		boolean flag = true;
		do{
			System.out.println("Bienvenido al COP16");
			System.out.println("1) Registrar Lugar");
			System.out.println("2) Mostrar los lugares registrados");
			System.out.println("3) consultar Lugar por nombre ");
			System.out.println("4) Salir");
			int option = lector.nextInt();
			switch(option){
				case 1:
				
				registrarLugar(); 
				break;
				
				case 2: 
					System.out.println(controller.listarLugares());
				break;
				
				case 3: 
				consultarLugar();
				break;
				
				case 4: 
				flag=false;
				System.out.println("Gracias por usar nuestro servicio");
				break;
				
				default:
				System.out.println("Digite una opcion válida");
				break;
			}
			
		}while(flag);
		
	}
	
	
	public void registrarLugar (){ 
		
			lector.nextLine(); //correción del bug del Scanner
	
		System.out.println("Digite el nombre del lugar");
		String nombre = lector.nextLine ();
		
		System.out.println("Digite el departamento \nVALLE");
		Departamento.deparm = lector.nextLine ();
		
		lector.nextLine();
		System.out.println("Digite el area del lugar(escribelo en kilometros cuadrados)");
		double area = lector.nextDouble ();
		lector.nextLine();
		
		System.out.println("Digite el tipo");
		String tipo = lector.nextLine ();
		
		System.out.println("Digite la ruta del lugar \nPARQUE_NATURAL");
		String foto = lector.nextLine ();
		
		lector.nextLine();
		
		System.out.println("Digite los recursos economicos necesarios para su sostenimiento(expreselo en dolares)");
		double recursos = lector.nextDouble ();
		
		boolean resultado=controller.almacenarLugar (nombre, deparm, area, tipo, foto, recursos);  // tiene que ir en el mismo orden 
		if(resultado==true){
			System.out.println("Registro exitoso");
		}else{
			System.out.println("ha ocurrido un error");
		}
		
		
	}
	
	
	public void consultarLugar() { 
	
		lector.nextLine(); //correción del bug del Scanner
		
		
	
		System.out.println("Digite el nombre del lugar");
		String nombre = lector.nextLine ();
	
		
		
		String msg = controller.mostrarLugar (nombre);
		if(msg.equals("El Lugar no se encuentra")){
			System.out.println(msg);
		}else{
			System.out.println("los datos del lugar son: \n" + msg );
		}
		
		 
		
		
		
	
	}
}