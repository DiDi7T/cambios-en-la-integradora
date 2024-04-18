package model;



public class Controller{
	
  //relacion
	private Place [] storage;  
	
	
	
	public Controller () {
		
	
		storage= new Place [200];
		createTestCases();
		
	}
	//---------------------------------------------------LISTS---------------------------------------------------------
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
		Description: This method allows you to list the types of comunity
		@return list of comunity types
	*/
	public String listTypeComunity(){
	
		TypeComunity[] typeComunityArray = TypeComunity.values();
	
		String list = "";
	
		for (int i = 0; i < typeComunityArray.length; i++){
			
			list += "\n" + (i+1) + "-" + typeComunityArray[i];
		}
		
		return list;
	}
	/** 
		Description: This method allows you to list the types of problems
		@return list of problems types
	*/
	public String listProblemsComunity(){
	
		Problems[] typeProblemsArray = Problems.values();
	
		String list = "";
	
		for (int i = 0; i < typeProblemsArray.length; i++){
			
			list += "\n" + (i+1) + "-" + typeProblemsArray[i];
		}
		
		return list;
	}
	
	
	//--------------------------------------------STORAGES------------------------------------------------------------
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
	* Descripcion: Permite crear y añadir un Apartamento a un Edificio en el
	* sistema
	* @param PlaceName name of place 
	* @param name is name of specie
	* @param type is the type specie 
	* @param photo is the url photo of specie
	* @param amount of specie
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
	
	/**
	* Descripcion: Permite crear y añadir una comunidad a un lugar en el
	* sistema
	* @param 
	* @param
	* @param 
	* @param 
	* @param 
	* @return boolean True si se logra añadir la comunidad al lugar, False en
	*         caso contrario
	*/
    public boolean registerComunityInPlace(String PlaceName, String name, int type, int habitants, int problems, String nameR, String phone ) {
		
		TypeComunity newTypeComunity = TypeComunity.AFROCOLOMBIANA;
			
			switch(type){
				
				case 1:
					newTypeComunity = TypeComunity.AFROCOLOMBIANA;
				break;
				
				case 2:
					newTypeComunity = TypeComunity.INDIGENA;
				break;
				
				case 3:
					newTypeComunity = TypeComunity.RAIZAL;
				break;
				
			}
		Problems newTypeProblem = Problems.FALTA_DE_HOSPITAL;
		
			switch(problems){
				
				case 1:
					newTypeProblem = Problems.FALTA_DE_HOSPITAL;
				break;
				
				case 2:
					newTypeProblem = Problems.FALTA_DE_ESCUELA;
				break;
				
				case 3:
					newTypeProblem = Problems.FALTA_DE_AGUA_POTABLE;
				break;
				
				case 4:
					newTypeProblem = Problems.FALTA_DE_ACCESO_A_UNA_ALIMENTACION_BASICA;
				break;
				
			}
					
			Place temporal=searchPlace(PlaceName);
			
			if(temporal!=null){
				Comunity newComunity = new  Comunity (temporal,name,newTypeComunity,habitants,newTypeProblem);
				return temporal.addComunity(newComunity);
			}
			Comunity temp=temporal.searchComunity(name);
			if(temp!=null){
				Representant newRepresentant = new  Representant (temp,nameR,phone);
				return temp.addRepresentant(newRepresentant);
			}

        return false;
    }
	
	//-------------------------------------------------OTHER-----------------------------------------------------
	
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
		
	
		
		public void createTestCases(){
			storagePlace("Las hermosas", 2, 34, 2, "foto", 4323453);
			registerSpecieInPlace("Las hermosas","mariposa", 1,"mariposa.com",34);
			registerComunityInPlace("Las hermosas","wayu", 2, 20, 1, "oscar", "39202920" );
		}
		
		
		
		
}