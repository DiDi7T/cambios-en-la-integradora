package model;



public class Controller{
	
  //relacion
	private Place [] storage;  
	
	
	
	public Controller () {
		
	
		storage= new Place [200];
		createTestCases();
		
	}
	
	/** 
		Description: This method allows you to list the places 
		that are stored in the array, returning a list with the name and area of each place
		pre: the storage array is initialized
		@return list with registered places showing name and area of the place
	*/
	public String listPlaces(){
		String list = "";
		for(int i=0;i<storage.length;i++){
			if (storage[i]!=null){
				list+="| "+(i+1)+".  "+storage[i].getName()+"   "+storage[i].getArea()+ " |\n";
			}
		}
		return list;
	}
	
	/** 
		Description: This method allows you to list the departments in which a place can be
		@return list with departments
	*/
	public String listDeparment(){
	
		Department[] departmentArray = Department.values();
	
		String list = "";
	
		for (int i = 0; i < departmentArray.length; i++){
			
			list += "\n" + (i+1) + "-" + departmentArray[i];
		}
		
		return list;
	}
	
	/** 
		Description: This method allows you to list the types of places
		@return list of place types
	*/
	
	public String listTypePlace(){
	
		TypePlace[] typePlaceArray = TypePlace.values();
	
		String list = "";
	
		for (int i = 0; i < typePlaceArray.length; i++){
			
			list += "\n" + (i+1) + "-" + typePlaceArray[i];
		}
		
		return list;
	}
	/** 
		Description: This method allows you to list the types of species
		@return list of species types
	*/
	public String listTypeSpecie(){
	
		TypeSpecie[] typeSpecieArray = TypeSpecie.values();
	
		String list = "";
	
		for (int i = 0; i < typeSpecieArray.length; i++){
			
			list += "\n" + (i+1) + "-" + typeSpecieArray[i];
		}
		
		return list;
	}
	
	/**
		Description: This method allows you to store a place in the system
		pre: the storage array is initialized

		@param name String The name of the place to search
		@param Department The associated department
		@param area The dimension of the place
		@param TypePlace The type of place
		@param photo The url of the photo of the place
		@param resources The resources used in the place
		@return boolean If the place was saved correctly it will be True, if not it will be False.
	*/ 
	 
	public boolean storagePlace (String name,int department, double area, int type, String photo, double resources) {
		
		Department newDepartment = Department.CHOCO;
		TypePlace newTypePlace = TypePlace.AREA_PROTEGIDA;
		
		switch(department){
			
			case 1:
				newDepartment = Department.CHOCO;
			break;
			
			case 2:
				newDepartment = Department.VALLE;
			break;
			
			case 3:
				newDepartment = Department.CAUCA;
			break;
			
			case 4:
				newDepartment = Department.NARIÑO;
			break;
		}
		switch(type){
			
			case 1:
				newTypePlace = TypePlace.AREA_PROTEGIDA;
			break;
			
			case 2:
				newTypePlace = TypePlace.PARQUE_NACIONAL;
			break;
			
			case 3:
				newTypePlace = TypePlace.AREA_PRIVADA;
			break;
			
		}
		
		
		Place newPlace = new  Place (name, newDepartment, area, newTypePlace, photo, resources);
		
		for (int i = 0; i<storage.length; i++) {
			
			if (storage[i] == null ){
				
				storage[i] = newPlace;
				
				return true; 
			}else if(storage[i].getName().equals(name)){
				return false;
			}
			
		}
		
		return false; 
		
	}
	

	
		/**
		Description: This method allows you to search for a place through its name, comparing the entered string with the name
		from the place stored in the array
		pre: the storage array is initialized
		@param name String The name of the place to search
		@return place The searched place
		*/
		
		public Place searchPlace (String name) {
			
			for ( int i = 0; i<storage.length; i++) { 
			
				Place temporal = storage[i]; 
				
				if(temporal!=null){
					
					if (name.equalsIgnoreCase(temporal.getName())) {    
				
						return temporal; 
				
					}
				}
				
			}
			
			return null;  
		}
		
		
		/**
		Description: This method allows displaying the place that the user requested by name, also validates if the place exists

		@param name The name of the place to search
		@return String The information of the searched place
		*/
		
		public String showPlace ( String name){
		
		
			Place temporal = searchPlace(name);
			
			
			if (temporal== null) {
				
				return "el lugar no se encuentra";
				
			}
			
			return temporal.toString (); 
			
			
			
			
		}
		
	/**
	* Descripcion: Permite crear y añadir un Apartamento a un Edificio en el
	* sistema
	* 
	* @return boolean True si se logra añadir el Apartamento al Edificio, False en
	*         caso contrario
	*/
    public boolean registerSpecieInPlace(String PlaceName, String name, int type, String photo, int amount ) {
		
		TypeSpecie newType = TypeSpecie.FAUNA;
			
			switch(type){
				
				case 1:
					newType = TypeSpecie.FAUNA;
				break;
				
				case 2:
					newType = TypeSpecie.FLORA;
				break;
				
			}
					
			Place temporal=searchPlace(PlaceName);
			if(temporal!=null){
				Specie newSpecie = new  Specie (temporal,name,newType,photo,amount);
				
				return temporal.addSpecie(newSpecie);
				
			}

        return false;
    }
		
		public void createTestCases(){
			storagePlace("Las hermosas", 2, 34, 2, "foto", 4323453);
			registerSpecieInPlace("Las hermosas","mariposa", 1,"mariposa.com",34);
			
		}
		
		
		
		
}