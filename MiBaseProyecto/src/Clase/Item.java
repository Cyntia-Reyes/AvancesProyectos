package Clase;

import java.util.HashMap;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	private String indiceImagen;
	private boolean capturado;
	


	//private HashMap<String, Animacion> animaciones;
	//private String animacionActual;
	
/*	public Item(int x, int y, int velocidad, String indiceImagen) {
		super();
		this.x = x;
		this.y = y;
		this.velocidad=velocidad;
		this.ancho =ancho;//(int)Juego.imagenes.get(this.indiceImagen).getWidth();
		this.alto =alto;//(int)Juego.imagenes.get(this.indiceImagen).getHeight();
		this.indiceImagen = indiceImagen;
		*/
	
	public Item(int x, int y, int velocidad, String indiceImagen) {
		super();
		this.x = x;
		this.y = y;
		//this.ancho = ancho;
		//this.alto= alto;
		this.velocidad = velocidad;
		this.indiceImagen = indiceImagen;
		//this.animaciones = animaciones;
		//this.animacionActual = animacionActual;
		//inicializarAnimaciones();
	
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	/*public void inicializarAnimaciones() {
		animaciones = new HashMap<String, Animacion>();
		Rectangle coordenadasMonedas[]= {
				
				new Rectangle(0, 0, 20,21),
				new Rectangle(20,0, 17,21),
				new Rectangle(3,21, 14,22),
				new Rectangle(19,21, 13,22),
				new Rectangle(32,21, 18,22)
			
	
		};
		
		
		Animacion animacionMonedas = new Animacion("monedas",coordenadasMonedas,0.07);
		animaciones.put("monedas",animacionMonedas);
	}*/
	/*public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getVelocidad() {
		return velocidad;
	}
*/
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}

	public void mover() {
		
	}
	public void pintar(GraphicsContext graficos) {
	if (this.capturado)
			return;
		
		graficos.strokeRect(this.x--, this.y, this.ancho, this.alto);
		graficos.drawImage(Juego.imagenes.get(indiceImagen), x, y);
	
	/*
	graficos.drawImage(
			Juego.imagenes.get(this.indiceImagen), 
			this.xImagen, this.yImagen, 
			this.anchoImagen, this.altoImagen,
			this.x--, this.y,
			this.anchoImagen, this.altoImagen
	);*/
	}

	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 18, 18);
	
	}
	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}


	}
