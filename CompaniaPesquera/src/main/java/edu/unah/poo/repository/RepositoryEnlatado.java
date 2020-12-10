package edu.unah.poo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.poo.model.Enlatado;

public interface RepositoryEnlatado extends JpaRepository<Enlatado,Integer> {
	public Enlatado findById(int id);
}
