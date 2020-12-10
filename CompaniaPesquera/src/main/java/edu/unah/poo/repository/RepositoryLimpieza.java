package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.IdLimpieza;
import edu.unah.poo.model.Limpieza;

public interface RepositoryLimpieza extends JpaRepository<Limpieza,IdLimpieza> {
	public Limpieza findById(int id);
	//public Limpieza getOne(IdLimpieza idLimpieza);
}
