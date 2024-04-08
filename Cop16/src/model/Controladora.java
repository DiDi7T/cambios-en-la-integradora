package model;
import model.TipoLugar;
import model.Departamento;

public class Controladora{
	
	  //relacion
		private Lugar [] almacenamiento;  
		
		
		
		public Controladora () {
			
		
			almacenamiento= new Lugar [200];
			crearCasosDePrueba();
			
		}
		
		public String listarLugares(){
			String lista = "";
			for(int i=0;i<almacenamiento.length;i++){
				if (almacenamiento[i]!=null){
					lista+="\n"+almacenamiento[i].getNombre()+"-"+almacenamiento[i].getArea();
				}
			}
			return lista;
		}
		
		 
		public boolean almacenarLugar (String nombre,Departamento departamento, double area, TipoLugar tipo, String foto, double recursos) {
			
			Lugar nuevoLugar = new  Lugar (nombre, departamento, area, tipo, foto, recursos);
			
			for (int i = 0; i<almacenamiento.length; i++) {
				
				if (almacenamiento[i] == null ){
					
					almacenamiento[i] = nuevoLugar;
					
					return true; 
				}else if(almacenamiento[i].getNombre().equals(nombre)){
					return false;
				}
				
			}
			
			return false; 
			
		}
		
	
		
			/** 
			Descripcion: Este metodo permite buscar un lugar a traves de su nombre, comparando el string ingresado con el nombre
			del lugar almacenado en el arreglo
			pre: el arreglo almacenamimento esta inicializado 
			@param nombre String El nombre del lugar a buscar 
			@return lugar El lugar buscado 
			*/
			
			public Lugar buscarLugar (String nombre) {
				
				for ( int i = 0; i<almacenamiento.length; i++) { //recorrido parcial de el arreglo
				
					Lugar temporal = almacenamiento[i]; //va tomar lo que sea que este en el almacenamiento en el espacio"i"
					
					if(temporal!=null){
						
						if (nombre.equalsIgnoreCase(temporal.getNombre())) {    
					
							return temporal; 
					
						}
					}
					
				}
				
				return null;  
			}
			
			
			
			
			public String mostrarLugar ( String nombre){
			
			
				Lugar temporal = buscarLugar(nombre);
				
				
				if (temporal== null) {
					
					return "el lugar no se encuentra";
					
				}
				
				return temporal.toString (); 
				
				
				
				
			}
			
			public void crearCasosDePrueba(){
				almacenarLugar("nombre", Departamento.VALLE, 34, TipoLugar.PARQUE_NATURAL, "foto", 4323453);
				
			}
			
		
		
		
}