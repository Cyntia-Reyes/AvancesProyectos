package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Factura;

public interface RepositoryFactura  extends JpaRepository<Factura,Integer>{
	//public Factura getOne(IdFactura idFactura);
	public Factura findById(int id);
}
