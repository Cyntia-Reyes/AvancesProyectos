package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.InventarioPeces;


public interface RepositoryInventarioPeces  extends JpaRepository<InventarioPeces,Integer>{
	public InventarioPeces findById(int id);
}
