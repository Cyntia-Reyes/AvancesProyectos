package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.IdLote;
import edu.unah.poo.model.Lote;

public interface RepositoryLote extends JpaRepository<Lote,IdLote> {
	public Lote findById(int id);
	//public Lote findById(IdLote idLote);
	//public Lote getOne(IdLote idLote);
}
