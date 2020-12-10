package edu.unah.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.poo.model.Factura;
import edu.unah.poo.repository.RepositoryFactura;

@Service
public class ServiceFactura {

	@Autowired 
	RepositoryFactura repositoryFactura;
	
		//CREAR FACTURAS
		public void crearFactura(Factura factura) {
			this.repositoryFactura.save(factura);
		}
		
		//OBTENER FACTURA
		public List<Factura> obtenerFactura() {
			return this.repositoryFactura.findAll();
		}
		
		//MOSTRAR FACTURA
		public Factura verFactura(int id) {
			return this.repositoryFactura.findById(id);
		}
		
		//ELIMINAR Factura
		public void eliminarFactura(int id) {
			this.repositoryFactura.deleteById(id);
		}
		
		//MODIFICAR FACTURA
		public void modificarFactura(int id,int cantidad) {
			Factura f= verFactura(id);
			int cantidadNueva = f.getCantidad()+cantidad;
			f.setCantidad(cantidadNueva);
			this.repositoryFactura.save(f);
			
		}
}
