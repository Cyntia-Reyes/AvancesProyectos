package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.unah.poo.model.InventarioPeces;
import edu.unah.poo.repository.RepositoryInventarioPeces;

@Service
public class ServiceInventarioPeces {

	@Autowired 
	RepositoryInventarioPeces repositoryInventarioPeces;
	
	//CREAR PECES
	public void crearPeces(InventarioPeces peces) {
		this.repositoryInventarioPeces.save(peces);
	}
	
	//OBTENER PECES
	public List<InventarioPeces> obtenerPeces() {
		return this.repositoryInventarioPeces.findAll();
	}
	
	//MOSTRAR PECES
	public InventarioPeces verPeces(int id) {
		return this.repositoryInventarioPeces.findById(id);
	}
	
	//ELIMINAR PECES
	public void eliminarPeces(int id) {
		this.repositoryInventarioPeces.deleteById(id);
	}
	
	//MODIFICAR PECES
	public void modificarPeces(int id,int cantidad) {
		InventarioPeces pez= verPeces(id);
		int cantidadNueva = pez.getCantidad()+cantidad;
		pez.setCantidad(cantidadNueva);
		this.repositoryInventarioPeces.save(pez);
		
	}
}
