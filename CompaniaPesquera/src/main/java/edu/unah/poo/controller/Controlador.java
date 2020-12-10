package edu.unah.poo.controller;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.poo.model.Empleado;
import edu.unah.poo.model.Enlatado;
import edu.unah.poo.model.Factura;
import edu.unah.poo.model.IdLimpieza;
import edu.unah.poo.model.IdLote;
import edu.unah.poo.model.InventarioPeces;
import edu.unah.poo.model.Limpieza;
import edu.unah.poo.model.Lote;
import edu.unah.poo.model.Proveedor;
import edu.unah.poo.service.ServiceEmpleado;
import edu.unah.poo.service.ServiceEnlatado;
import edu.unah.poo.service.ServiceFactura;
import edu.unah.poo.service.ServiceInventarioPeces;
import edu.unah.poo.service.ServiceLimpieza;
import edu.unah.poo.service.ServiceLote;
import edu.unah.poo.service.ServiceProveedor;

@RestController
public class Controlador {
	
	@Autowired
	ServiceInventarioPeces serviceInventarioPeces;
	
	@Autowired
	ServiceLote serviceLote;
	
	@Autowired
	ServiceEmpleado serviceEmpleado;

	
	@Autowired
	ServiceProveedor serviceProveedor;
	
	@Autowired
	ServiceFactura serviceFactura;
	
	@Autowired
	ServiceLimpieza serviceLimpieza;
	
	@Autowired
	ServiceEnlatado serviceEnlatado;
	
	// ====================================================================
	// INVENTARIOPECES
	// ====================================================================

	@RequestMapping(value = "/inventariopeces/crearPeces", method = RequestMethod.GET)
	public InventarioPeces crearPeces(@RequestParam(name = "id") int idPez,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "color") String color,
			@RequestParam(name = "tipoPez") String tipoPez, @RequestParam(name = "tamanio") String tamanio,
			@RequestParam(name = "cantidad") int cantidad) {
		InventarioPeces pez = new InventarioPeces(idPez, nombre, color, tipoPez, tamanio, cantidad);
		this.serviceInventarioPeces.crearPeces(pez);
		return pez;

	}

	@RequestMapping(value = "/inventariopeces/eliminarPeces", method = RequestMethod.GET)
	public void eliminarPez(@RequestParam(name = "id") int idPez) {
		this.serviceInventarioPeces.eliminarPeces(idPez);
	}

	@RequestMapping(value = "/inventariopeces/verPeces", method = RequestMethod.GET)
	public InventarioPeces verPez(@RequestParam(name = "id") int idPez) {
		InventarioPeces pez = this.serviceInventarioPeces.verPeces(idPez);
		return pez;
	}
	
	@RequestMapping(value ="/inventariopeces/obtenerPeces",method=RequestMethod.GET)
	public List<InventarioPeces> obtenerPeces() {
		return this.serviceInventarioPeces.obtenerPeces();
	}
	
	
	// ====================================================================
	// PROVEEDOR
	// ====================================================================

	@RequestMapping(value = "/proveedor/crearProveedor", method = RequestMethod.GET)
	public Proveedor crearProveedor(@RequestParam(name = "id") int idProveedor,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "direccion") String direccion,
			@RequestParam(name = "telefono") String telefono, @RequestParam(name = "correo") String correo) {
		Proveedor proveedor = new Proveedor(idProveedor, nombre, direccion, telefono, correo);
		this.serviceProveedor.crearProveedor(proveedor);
		return proveedor;
	}
	@RequestMapping(value ="/proveedor/obtenerProveedor",method=RequestMethod.GET)
	public List<Proveedor> obtenerProveedor() {
		return this.serviceProveedor.obtenerProveedor();
	}
	@RequestMapping(value ="/proveedor/verProveedor",method=RequestMethod.GET)
	public Proveedor verProveedor(@RequestParam(name = "id") int idProveedor) {
		Proveedor proveedor= this.serviceProveedor.verProveedor(idProveedor);
		return proveedor;
	}

	// ====================================================================
	// LOTE
	// ====================================================================

	@RequestMapping(value = "/lote/crearLote", method = RequestMethod.GET)
	public Lote crearLote(@RequestParam(name = "id") int idLote, 
			@RequestParam(name = "idEmpleado") int idEmpleado,
			@RequestParam(name = "idProveedor") int idProveedor, 
			@RequestParam(name = "estado") String estado,
			@RequestParam(name = "tipoPescado") String tipoPescado,
			@RequestParam(name = "precioProducto") int precioProducto,
			@RequestParam(name = "indiceCalidad") int indiceCalidad,
			@RequestParam(name = "pesoProducto") String pesoProducto) {

		Empleado empleado = this.serviceEmpleado.verEmpleado(idEmpleado);
		Proveedor proveedor = this.serviceProveedor.verProveedor(idProveedor);
		Lote lote = new Lote(idLote, idEmpleado, idProveedor, estado, tipoPescado, precioProducto, indiceCalidad,
				pesoProducto, empleado, proveedor);
		this.serviceLote.crearLote(lote);
		return lote;
	}
	
	@RequestMapping(value ="/lote/obtenerLote",method=RequestMethod.GET)
	public List<Lote> obtenerLote() {
		return this.serviceLote.obtenerLote();
	}
	@RequestMapping(value ="/lote/verLote",method=RequestMethod.GET)
	public Lote verLote(@RequestParam(name = "idEmpleado") int idEmpleado,
						@RequestParam(name = "idProveedor") int idProveedor) {
		IdLote idLote= new IdLote(idEmpleado,idProveedor);
		return this.serviceLote.verLote(idLote);
		
	}
	
	

	// ====================================================================
	// EMPLEADO
	// ====================================================================

	@RequestMapping(value = "/empleado/crearEmpleado", method = RequestMethod.GET)
	public Empleado crearEmpleado(@RequestParam(name = "id") int idEmpleado,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "telefono") String telefono,
			@RequestParam(name = "direccion") String direccion,
			@RequestParam(name = "fechaContrato") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaContrato,
			@RequestParam(name = "fechaNacimiento") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaNacimiento,
			@RequestParam(name = "puesto") String puesto) {
		Empleado empleado = new Empleado(idEmpleado, nombre, telefono, direccion, fechaContrato, fechaNacimiento,
				puesto);
		this.serviceEmpleado.crearEmpleado(empleado);
		return empleado;
	}
	@RequestMapping(value ="/empleado/obtenerEmpleado",method=RequestMethod.GET)
	public List<Empleado> obtenerEmpleado() {
		return this.serviceEmpleado.obtenerEmpleado();
	}
	@RequestMapping(value ="/empleado/verEmpleado",method=RequestMethod.GET)
	public Empleado verEmpleado(@RequestParam(name = "id") int idEmpleado) {
		Empleado empleado= this.serviceEmpleado.verEmpleado(idEmpleado);
		return empleado;
	}

	// ====================================================================
	// FACTURA
	// ====================================================================

	@RequestMapping(value = "/factura/crearFactura", method = RequestMethod.GET)
	public Factura crearFactura(@RequestParam(name = "id") int idFactura,
			@RequestParam(name = "idEmpleado") int idEmpleado, @RequestParam(name = "precio") int precio,
			@RequestParam(name = "cantidad") int cantidad, @RequestParam(name = "tipoProducto") String tipoProducto,
			@RequestParam(name = "fecha") @DateTimeFormat(iso = ISO.DATE) LocalDate fecha,
			@RequestParam(name = "lugar") String lugar) {

		Empleado empleado = this.serviceEmpleado.verEmpleado(idEmpleado);
		Factura factura = new Factura(idFactura, idEmpleado, precio, cantidad, tipoProducto, fecha, lugar, empleado);
		this.serviceFactura.crearFactura(factura);
		return factura;
	}
	@RequestMapping(value ="/factura/obtenerFactura",method=RequestMethod.GET)
	public List<Factura> obtenerFactura() {
		return this.serviceFactura.obtenerFactura();
	}
	@RequestMapping(value ="/factura/verFactura",method=RequestMethod.GET)
	public Factura verFactura(@RequestParam(name = "id") int idFactura) {
		Factura factura= this.serviceFactura.verFactura(idFactura);
		return factura;
	}


	// ====================================================================
	// LIMPIEZA NO LISTO AUN
	// ====================================================================

	@RequestMapping(value = "/limpieza/crearLimpieza", method = RequestMethod.GET)
	public Limpieza crearLimpieza(@RequestParam(name = "id") int idLimpieza,
			@RequestParam(name = "idEmpleado") int idEmpleado, 
			@RequestParam(name = "idLote") int idLote,
			@RequestParam(name = "numEnlatados") int numEnlatados,
			@RequestParam(name = "numEmpleados") int numEmpleados,
			@RequestParam(name = "horaFin") @DateTimeFormat(iso = ISO.TIME) LocalTime horaFin,
			@RequestParam(name = "horaInicio") @DateTimeFormat(iso = ISO.TIME) LocalTime horaInicio) {

		Empleado empleado = this.serviceEmpleado.verEmpleado(idEmpleado);
		Lote lote= this.serviceLote.verLote(idLote);
		Limpieza limpieza= new Limpieza(idLimpieza,idEmpleado,idLote,numEnlatados,numEmpleados,horaFin,horaInicio,
											empleado,lote);
		this.serviceLimpieza.crearLimpieza(limpieza);
		return limpieza;
		
		
		
	}
	@RequestMapping(value ="/limpieza/mostrarLimpieza",method=RequestMethod.GET)
	public List<Limpieza> mostrarLimpieza() {
		return this.serviceLimpieza.mostrarLimpieza();
	}
	@RequestMapping(value ="/limpieza/verLimpieza",method=RequestMethod.GET)
	public Limpieza verLimpieza(@RequestParam(name = "idEmpleado") int idEmpleado,
								@RequestParam(name = "idLote") int idLote) {
		IdLimpieza idLimpieza= new IdLimpieza(idEmpleado,idLote);
		return this.serviceLimpieza.verLimpieza(idLimpieza);
		
	}

	// ====================================================================
	// ENLATADO
	// ====================================================================
	@RequestMapping(value = "/enlatado/crearEnlatado", method = RequestMethod.GET)
	public Enlatado crearEnlatado(@RequestParam(name = "id") int idEnlatado,
			@RequestParam(name = "descripcion") String descripcion,
			@RequestParam(name = "precio") int precio,
			@RequestParam(name = "cantidadLatas") int cantidadLatas,
			@RequestParam(name = "tipoPescado") String tipoPescado) {
		Enlatado enlatado = new Enlatado(idEnlatado, descripcion, precio, cantidadLatas, tipoPescado);
		this.serviceEnlatado.crearEnlatado(enlatado);
		return enlatado;
	}
	@RequestMapping(value ="/enlatado/obtenerEnlatado",method=RequestMethod.GET)
	public List<Enlatado> obtenerEnlatado() {
		return this.serviceEnlatado.obtenerEnlatado();
	}
	@RequestMapping(value ="/enlatado/verEnlatado",method=RequestMethod.GET)
	public Enlatado verEnlatado(@RequestParam(name = "id") int idEnlatado) {
		Enlatado enlatado= this.serviceEnlatado.verEnlatado(idEnlatado);
		return enlatado;
	}

}