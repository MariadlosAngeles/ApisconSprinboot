package com.maria.demo.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maria.demo.utilidades.PersonasUtilidades;
import com.maria.demo.vo.PersonaVo;

@Service
public class PersonaDao {

	public PersonaDao() {
		PersonasUtilidades.iniciarLista();
		
	}

	public PersonaVo consultarPersonaIdProfesion(String documento, String profesion) {
		PersonaVo personaVo=null;
		for (PersonaVo p : PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(documento) && p.getProfesion().equals(profesion)) {
				personaVo=new PersonaVo();
				personaVo.setDocumento(p.getDocumento());
				personaVo.setNombre(p.getNombre());
				personaVo.setTelefono(p.getTelefono());
				personaVo.setEdad(p.getEdad());
				personaVo.setProfesion(p.getProfesion());
				personaVo.setProfesion(p.getPassword());
				personaVo.setTipo(p.getTipo());
			}
		}
		return personaVo;
	}
	
	public List<PersonaVo> obtenerListaPersonas(){
		return PersonasUtilidades.listaPersonas;
	}
	
	public PersonaVo registraarPersona(PersonaVo personaVo) {
		boolean existe=false;
		
		for (PersonaVo obj:PersonasUtilidades.listaPersonas) {
			if(obj.getDocumento().equals(personaVo.getDocumento())) {
				existe=true;
				break;
			}
		}
		
		if(existe==false) {
			personaVo.setPassword(personaVo.getDocumento());
			PersonasUtilidades.listaPersonas.add(personaVo);
			return personaVo;
		}else {
			return null;
		}
	}

	public PersonaVo consultarPersonaIndividual(String documento) {
		PersonaVo personaVo=null;
		for (PersonaVo p : PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(documento) ) {
				personaVo=new PersonaVo();
				personaVo.setDocumento(p.getDocumento());
				personaVo.setNombre(p.getNombre());
				personaVo.setTelefono(p.getTelefono());
				personaVo.setEdad(p.getEdad());
				personaVo.setProfesion(p.getProfesion());
				personaVo.setPassword(p.getPassword());
				personaVo.setTipo(p.getTipo());
			}
		}
		return personaVo;
	}
	
	public PersonaVo consultarLogin(String documento, String pass) {
		PersonaVo persona=null;
		
		for(PersonaVo p: PersonasUtilidades.listaPersonas) {
			if(p.getDocumento().equals(documento)&&p.getPassword().equals(pass)) {
				persona=p;
				break;
			}
		}
		return persona;
	}
	
	public PersonaVo actualizarPersona(PersonaVo persona) {
		PersonaVo personaVo=null;
		for(PersonaVo obj:PersonasUtilidades.listaPersonas) {
			if(obj.getDocumento().equals(persona.getDocumento())) {
				personaVo.setDocumento(persona.getDocumento());
				personaVo.setNombre(persona.getNombre());
				personaVo.setTelefono(persona.getTelefono());
				personaVo.setEdad(persona.getEdad());
				personaVo.setProfesion(persona.getProfesion());				personaVo.setProfesion(persona.getPassword());
				personaVo.setPassword(persona.getPassword());
				personaVo.setTipo(persona.getTipo());
				break;
			}
		}
		return personaVo;
	}
	
	public void eliminarPersona(PersonaVo persona) {
		for(PersonaVo obj: PersonasUtilidades.listaPersonas) {
			if(obj.getDocumento().equals(persona.getDocumento())) {
				PersonasUtilidades.listaPersonas.remove(obj);
				break;
			}
		}
	}
}
