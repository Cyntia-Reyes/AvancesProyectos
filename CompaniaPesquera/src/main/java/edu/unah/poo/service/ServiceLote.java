package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.IdLote;
import edu.unah.poo.model.Lote;
import edu.unah.poo.repository.RepositoryLote;

@Service
public class ServiceLote {

	@Autowired 
	RepositoryLote repositoryLote;
	
	public void crearLote(Lote lote) {
		this.repositoryLote.save(lote);
	} 

	public List<Lote> obtenerLote(){
		return this.repositoryLote.findAll();
	}
	
	public Lote verLote(IdLote idLote) {
		//return this.repositoryLote.findById(id);
		return this.repositoryLote.getOne(idLote);
	}
	
	public Lote verLote(int idLote) {
		return this.repositoryLote.findById(idLote);
	}
	
}