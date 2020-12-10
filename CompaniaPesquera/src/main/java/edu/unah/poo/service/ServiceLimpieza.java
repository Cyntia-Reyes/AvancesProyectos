package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.IdLimpieza;
import edu.unah.poo.model.Limpieza;
import edu.unah.poo.repository.RepositoryLimpieza;

@Service
public class ServiceLimpieza {

	@Autowired 
	RepositoryLimpieza repositoryLimpieza;
	
	public void crearLimpieza(Limpieza limpieza) {
		this.repositoryLimpieza.save(limpieza);
	}
	
	public List<Limpieza> mostrarLimpieza() {
		return this.repositoryLimpieza.findAll();
	} 
	
	public Limpieza verLimpieza(IdLimpieza idLimpieza){
		return this.repositoryLimpieza.getOne(idLimpieza);
	}
}
