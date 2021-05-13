class Persona {
	var nombre
	var diaNacimiento
	var mesNacimiento
	var anioNacimiento
	
	method getNombre(){
		return nombre
	}
	method getFechaNacimiento(){
		return diaNacimiento + "/" + mesNacimiento + "/" + anioNacimiento
	}
	
	method setNombre(n){
		nombre = n
	}
	method setFechaNacimiento(dia, mes, anio){
		diaNacimiento = dia
		mesNacimiento = mes
		anioNacimiento = anio
	}
	
	method getEdad(anio){
		//podria hacer esto mas preciso de la misma forma q en java
		return anio - anioNacimiento
	}
	method <(persona, anio){
		return self.getEdad(anio) < persona.getEdad(anio)
	}
	
}
