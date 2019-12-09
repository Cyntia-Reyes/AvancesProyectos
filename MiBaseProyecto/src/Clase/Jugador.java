package Clase;

import java.util.ArrayList;
import java.util.HashMap;

import Implementacion.Juego;
import 	Clase.Item;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Jugador {
	private int x;
	private int y;
	private String indiceImagen;
	private int velocidad;
	//private HashMap<String,ArrayList<Rectangle>> animaciones;
	//private int puntuacion = 0;
	//private int ancho;
	//private int alto;
	//private int vidas=2;
	
	public Jugador(int x, int y, String indiceImagen, int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		//this.ancho = (int)Juego.imagenes.get(this.indiceImagen).getWidth();
		//this.alto = (int)Juego.imagenes.get(this.indiceImagen).getHeight();
	
	
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	public void mover(){
		/*if (Juego.accion) {
			this.velocidad = 20;
			this.indiceImagen = "Guardian";
		}else {
			this.velocidad = 10;
			this.indiceImagen = "Guardian";
		}
		
		
		if (Juego.derecha)
			x+=velocidad;
		
		if (Juego.izquierda)
			x-=velocidad;
		
		if (Juego.arriba)
			y-=velocidad;
		
		if (Juego.abajo)
			y+=velocidad;
		
		if (x>=500)
			x=-120;
		
		if (y>=500)
			y=-120;
		
	}*/
	
		if (this.x>=1100)
			this.x = -100;
		if (Juego.derecha)
			this.x+=velocidad;
		
		if (Juego.izquierda)
			this.x-=velocidad;
		
		if (Juego.arriba)
			this.y-=velocidad;
		
		if (Juego.abajo)
			this.y+=velocidad;
	}
	
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(this.indiceImagen), this.x, this.y);
		//graficos.drawImage(Juego.imagenes.get(indiceImagen), x, y);
		//graficos.strokeRect(this.x+20, this.y, this.ancho-30, this.alto);
	}
	
	
	/*public void crearAnimaciones() {
		animaciones = new HashMap<String, ArrayList<Rectangle>>();
		ArrayList<Rectangle> animacionIdle = new ArrayList<Rectangle>();
		animacionIdle.add(new Rectangle(0,0,100,100));
		animacionIdle.add(new Rectangle(0,100,100,100));
		
		animaciones.put("idle",animacionIdle);
		
		*/
		
	
	public void inicializarAnimaciones() {
	}
	
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x+20, this.y, this.ancho-30, this.alto);
	}
	
	public void agregarPuntuacion(int puntuacion) {
		this.puntuacion+=puntuacion;
	}
	
	/*public boolean verificarColisiones(Item item) {
		if (obtenerRectangulo().intersects(item.obtenerRectangulo().getBoundsInLocal()) && !item.isCapturado()) {
			item.setCapturado(true);
			
			 //if (item instanceof Vida)
				//agregarVida();
			//else if (item instanceof Moneda)
				//agregarPuntuacion();
			
			
			agregarPuntuacion(1);
			System.out.println("Colisionaron");
			
			return true;
		}
		
		return false;
	}*/

	}



