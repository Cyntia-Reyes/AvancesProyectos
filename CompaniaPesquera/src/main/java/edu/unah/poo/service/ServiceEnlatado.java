package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Enlatado;
import edu.unah.poo.repository.RepositoryEnlatado;

@Service
public class ServiceEnlatado {

	@Autowired 
	RepositoryEnlatado repositoryEnlatado;
	
	public void crearEnlatado(Enlatado enlatado) {
		this.repositoryEnlatado.save(enlatado);
	}
	
	public List<Enlatado> obtenerEnlatado() {
		return this.repositoryEnlatado.findAll();
	} 
	
	public Enlatado verEnlatado(int id){
		return this.repositoryEnlatado.findById(id);
	}
}
