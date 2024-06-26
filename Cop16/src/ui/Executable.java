package ui;
import java.util.Scanner;
import model.Controller; //asi unimos los archivos 

//se encarga de la interfaz grafica 

public class Executable{
	
	// atributos
	private Scanner lector; 
	
	private Controller controller; 

	
	public static void main(String [] args){
		Executable exe= new Executable(); 
		exe.menu(); // exe es el objeto, la instancia, y a partir de eso se le llama el metodo menu
		
		
		
	}
	
	/** 
	Descripcion: Este metodo permite inicializar el constructor.
	*/
	
	 
	public Executable () {
		lector= new Scanner(System.in); //Atributo, no variable global.
		
		controller = new Controller (); 
	}
	
	
	
	/** 
	Descripcion: Este metodo permite al usuario interactuar con la aplicacion por medio de menu
	*/
	
	public void menu(){
		boolean flag = true;
		do{
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("   ======================="+" BIENVENIDO AL COP16 "+"=======================");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("| 1) Panel Administrativo \n|");
			System.out.println("| 2) Consultar la información de un lugar \n|");
			System.out.println("| 3) Consultar la información de las comunidades de un departamento \n|");
			System.out.println("| 4) Consultar la información de las comunidades cuyos problemas son: \n|    Falta de un hospital o falta de una escuela. \n|");
			System.out.println("| 5) Consultar el nombre del lugar con mayor cantidad de especies.\n|");
			System.out.println("| 6) Consultar los tres lugares más grandes por kilómetro cuadrado.\n|");
			System.out.println("| 7) Salir");
			System.out.println("-------------------------------------------------------------------------");
			int option = lector.nextInt();
			switch(option){
				case 1:
					menuAdmin();
				break;
				
				case 2: 
					System.out.println("======================="+" LUGARES REGISTRADOS "+"=======================");
					System.out.println(controller.listPlaces());
					
					checkPlace();
				break;
				
				case 3: 
					consultComunityForDepartment();
				break;
				
				case 4: 
					consultComunityProblems();
				break;
				
				case 5: 
					System.out.println(":( Servicio aun no disponible, esperelo en la ultima entrega");
				break;
				
				case 6: 
					System.out.println(":( Servicio aun no disponible, esperelo en la ultima entrega");
				break;
				
				case 7: 
				flag=false;
				System.out.println("Gracias por usar nuestro servicio");
				break;
				
				default:
				System.out.println("Digite una opcion válida");
				break;
			}
			
		}while(flag);
		
	}
	
	public void menuAdmin(){
		boolean flag = true;
		do{
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("   ======================="+" BIENVENIDO ADMIN "+"=======================");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println(" 1) Ingresar una Comunidad.\n");
			System.out.println(" 2) Ingresar un Lugar \n");
			System.out.println(" 3) Ingresar y/o eliminar un producto a una comunidad. \n");
			System.out.println(" 4) Ingresar una especie a un lugar. \n");
			System.out.println(" 5) Modificar los datos de la especie en un lugar. \n");
			System.out.println(" 6) Salir");
			int option = lector.nextInt();
			switch(option){
				case 1:
					registerComunityOnPlace();
				break;
				
				case 2: 
					registerPlace();
				break;
				
				case 3: 
					
					System.out.println("-------------------------------------------------");
					System.out.println("¿Que deseas realizar?\n1)Ingresar un producto a una comunidad\n2)Eliminar un producto de una comunidad");
					int opcion = lector.nextInt();
					switch(opcion){
						case 1: 
							registerProductInComunity();
						break;
						case 2:
							deleteProductInComunity();
						break;
						default:
							System.out.println("Porfavor digita una opcion valida");
						break;
					}
					
				break;
				
				case 4: 
					registerSpecieOnPlace();
				break;
				
				case 5: 
					updateSpecieOnPlace();
				break;
				
				case 6: 
				flag=false;
				System.out.println("Gracias por usar nuestro servicio");
				break;
				
				default:
				System.out.println("Digite una opcion válida");
				break;
			}
			
		}while(flag);
		
	}
	
	/** 
	Descripcion: Este metodo permite registrar un lugar  
	*/
	
	public void registerPlace (){ 
		
			lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" REGISTRAR LUGAR "+"=======================\n");
		System.out.println("Digite el nombre del lugar");
		String name = lector.nextLine();
		
		
		System.out.println("Digite el departamento");
		System.out.println(controller.listDeparment());
		int deparm = lector.nextInt();
		
	
		System.out.println("Digite el area del lugar(escribelo en kilometros cuadrados)");
		double area = lector.nextDouble();

		
		System.out.println("Digite el tipo");
		System.out.println(controller.listTypePlace());
		int type = lector.nextInt();
		lector.nextLine();
		
		System.out.println("Digite la ruta del lugar ");
		String photo = lector.nextLine();
		
	
		
		System.out.println("Digite los recursos economicos necesarios para su sostenimiento(expreselo en dolares)");
		double resources = lector.nextDouble();
		
		boolean result=controller.storagePlace (name, deparm, area, type, photo, resources);  // tiene que ir en el mismo orden 
		if(result==true){
			System.out.println("Registro exitoso");
		}else{
			System.out.println("ha ocurrido un error");
		}
		
		
	}
	
	
	public void checkPlace() { 
	
		lector.nextLine(); //correción del bug del Scanner
		System.out.println("Digite el nombre del lugar que desea consultar a mas detalle");
		String name = lector.nextLine ();
	
		String msg = controller.showPlace (name);
		if(msg.equals("El Lugar no se encuentra")){
			System.out.println(msg);
		}else{
			System.out.println("-------------------------------");
			System.out.println("    INFORMACION DEL LUGAR \n" );
			System.out.println("-------------------------------");
			System.out.println(msg);
		}
			
	
	}
	
	
	public void registerSpecieOnPlace (){ 
		
			lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" REGISTRAR ESPECIE "+"=======================\n");
		
		System.out.println("======================="+" LUGARES REGISTRADOS "+"=======================");
		System.out.println(controller.listPlaces());
		System.out.println("Por favor digita el nombre del lugar al cual deseas agregar la especie:");
		String PlaceName = lector.nextLine();
		
		System.out.println("Digite el nombre de la especie: ");
		String name = lector.nextLine();
		

	
		System.out.println("Digite el tipo de especie:");
		System.out.println(controller.listTypeSpecie());
		int type = lector.nextInt();
		lector.nextLine();
		
		System.out.println("Digite la ruta de la imagen de la especie: ");
		String photo = lector.nextLine();
		

		
		System.out.println("Cuantas especies de este tipo se encuentran en el lugar?");
		int amount = lector.nextInt();
		
		boolean result=controller.registerSpecieInPlace (PlaceName,name,type,photo,amount);  
		if(result==true){
			System.out.println("Registro exitoso");
		}else{
			System.out.println("ha ocurrido un error");
		}	
		
	}
	public void updateSpecieOnPlace (){ 
		
			lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" ACTUALIZAR ESPECIE "+"=======================\n");
		
		System.out.println("======================="+" LUGARES REGISTRADOS "+"=======================");
		System.out.println(controller.listPlaces());
		System.out.println("Por favor digita el nombre del lugar al cual deseas modificar la especie:");
		String PlaceName = lector.nextLine();
		
		System.out.println("Digite el nombre de la especie que deseas actualizar: ");
		String name = lector.nextLine();
		
	
		System.out.println("Digite el tipo de especie:");
		System.out.println(controller.listTypeSpecie());
		int type = lector.nextInt();
		lector.nextLine();
		
		System.out.println("Digite la ruta de la imagen de la especie: ");
		String photo = lector.nextLine();
		
	
		
		System.out.println("Cuantas especies de este tipo se encuentran en el lugar?");
		int amount = lector.nextInt();
		
		boolean result=controller.updateSpecieInPlace(PlaceName,name,type,photo,amount);  
		if(result==true){
			System.out.println("Registro exitoso");
		}else{
			System.out.println("ha ocurrido un error");
		}	
		
	}
	public void registerComunityOnPlace (){ 
		
			lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" REGISTRAR COMUNIDAD "+"=======================\n");
		
		System.out.println("======================="+" LUGARES REGISTRADOS "+"=======================");
		System.out.println(controller.listPlaces());
		System.out.println("Por favor digita el nombre del lugar al cual deseas agregar la comunidad:");
		String PlaceName = lector.nextLine();
		
		System.out.println("Digite el nombre de la comunidad: ");
		String name = lector.nextLine();
		
		//lector.nextLine();
	
		System.out.println("Digite el tipo de comunidad:");
		System.out.println(controller.listTypeComunity());
		int type = lector.nextInt();
		
		
		System.out.println("Digite el numero de habitantes");
		int habitants = lector.nextInt();
		
		System.out.println("Digite el tipo de problema mas importante");
		System.out.println(controller.listProblemsComunity());
		int problems = lector.nextInt();
		
		lector.nextLine();
		
		System.out.println("Digite el nombre del representante de la comunidad ");
		String nameR = lector.nextLine();
		
		System.out.println("Digite el numero de telefono del representante");
		String phone = lector.nextLine();
		
		boolean result=controller.registerComunityInPlace(PlaceName,name,type,habitants,problems,nameR,phone);  
		if(result==true){
			System.out.println("Registro exitoso");
		}else{
			System.out.println("ha ocurrido un error");
		}	
		
	}
	
	
	public void registerProductInComunity (){ 
		
			lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" REGISTRAR PRODUCTO DE UNA COMUNIDAD "+"=======================\n");
		
		
		System.out.println("Digite el nombre de la comunidad: ");
		String nameComunity = lector.nextLine();
		
		System.out.println("Digite el nombre del producto ");
		String name = lector.nextLine();

		System.out.println("Porcentaje de productos naturales empleados en su fabricación: ");
		double percentage = lector.nextDouble();
		//lector.nextLine();
	
		System.out.println("Digite el tipo de producto:");
		System.out.println(controller.listTypeProduct());
		int type = lector.nextInt();

		System.out.println("El producto fue hecho a mano? \n1)Si\n2)No");
		int make = lector.nextInt();
		
		
		boolean result=controller.addProduct(nameComunity,name,percentage,type,make);  
		//String result=controller.addProducto(nameComunity,name,percentage,type,make);  
		//System.out.println(result);
		if(result==true){
			System.out.println("Registro exitoso");
		}else{
			System.out.println("ha ocurrido un error");
		}	
		
	}
	
	public void deleteProductInComunity (){ 
		
			lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" ELIMINAR PRODUCTO DE UNA COMUNIDAD "+"=======================\n");
		
		
		System.out.println("Digite el nombre de la comunidad: ");
		String nameComunity = lector.nextLine();
		
		System.out.println("Digite el nombre del producto ");
		String name = lector.nextLine();

		
		boolean result=controller.deleteProduct(nameComunity,name);  
		if(result==true){
			System.out.println("Se ha eliminado correctamente");
		}else{
			System.out.println("ha ocurrido un error en la eliminacion");
		}	
		
	}
	public void consultComunityForDepartment(){ 
		
		lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" CONSULTAR COMUNIDAD POR DEPARTAMENTO "+"=======================\n");
		System.out.println("Digite el departamento a consultar");
		System.out.println(controller.listDeparment());
		int deparm = lector.nextInt();
		
		
		String result=controller.consultDepartment(deparm);  
		System.out.println(result);
		
	
		
	}
	public void consultComunityProblems(){ 
		
		lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" CONSULTAR COMUNIDADES POR PROBLEMA "+"=======================\n");
		System.out.println("Digite el problema a consultar");
		System.out.println(controller.listProblemsComunity());
		int problem = lector.nextInt();
		
		
		String result=controller.consultProblem(problem);  
		System.out.println(result);
	}
	public void consultPlaceWithManySpecies(){ 
		
		lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" CONSULTAR LUGARES CON MAYOR CANTIDAD DE ESPECIES"+"=======================\n");
		
	}
	public void consultPlaceBiggest(){ 
		
		lector.nextLine(); //correción del bug del Scanner
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("   ======================="+" CONSULTAR LUGARES MAS GRANDES POR KILOMETRO CUADRADO"+"=======================\n");
		
	}
	
	
}