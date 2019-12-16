package Clase;

import java.util.HashMap;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigos2 {
	private int x;
	private int y;
	private  int velocidad;
	private String indiceImagen;
	private int ancho;
	private int alto;
	private String animacionActual;
	private int puntuacion = 0;
    private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;

	private boolean capturado;
	private HashMap<String, Animacion> animaciones;

	
	

		
		public Enemigos2(int x, int y, int velocidad, String indiceImagen, int ancho, int alto, String animacionActual,
			int puntuacion, int xImagen, int yImagen, int anchoImagen, int altoImagen, boolean capturado,
			HashMap<String, Animacion> animaciones) {
		super();
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.indiceImagen = indiceImagen;
		this.ancho = ancho;
		this.alto = alto;
		this.animacionActual = animacionActual;
		this.puntuacion = puntuacion;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.anchoImagen = anchoImagen;
		this.altoImagen = altoImagen;
		this.capturado = capturado;
		this.animaciones = animaciones;
	



		inicializarAnimaciones();
		
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



		public int getVelocidad() {
			return velocidad;
		}



		public static void setVelocidad(int velocidad) {
			
		}



		public String getIndiceImagen() {
			return indiceImagen;
		}



		public void setIndiceImagen(String indiceImagen) {
			this.indiceImagen = indiceImagen;
		}



		public int getAncho() {
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



		public String getAnimacionActual() {
			return animacionActual;
		}



		public void setAnimacionActual(String animacionActual) {
			this.animacionActual = animacionActual;
		}



		public int getPuntuacion() {
			return puntuacion;
		}



		public void setPuntuacion(int puntuacion) {
			this.puntuacion = puntuacion;
		}



		public int getxImagen() {
			return xImagen;
		}



		public void setxImagen(int xImagen) {
			this.xImagen = xImagen;
		}



		public int getyImagen() {
			return yImagen;
		}



		public void setyImagen(int yImagen) {
			this.yImagen = yImagen;
		}



		public int getAnchoImagen() {
			return anchoImagen;
		}



		public void setAnchoImagen(int anchoImagen) {
			this.anchoImagen = anchoImagen;
		}



		public int getAltoImagen() {
			return altoImagen;
		}



		public void setAltoImagen(int altoImagen) {
			this.altoImagen = altoImagen;
		}



		public HashMap<String, Animacion> getAnimaciones() {
			return animaciones;
		}



		public void setAnimaciones(HashMap<String, Animacion> animaciones) {
			this.animaciones = animaciones;
		}



	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	public void inicializarAnimaciones() {
		animaciones = new HashMap<String, Animacion>();
		Rectangle coordenadasenemigos[]= {
				new Rectangle(304, 120, 72,65),
				new Rectangle(377,120, 70,64),
				new Rectangle(445,119, 67,65),
				new Rectangle(514,120, 63,64),
				new Rectangle(578,120, 47,63),
				new Rectangle(627,120, 54,63),
				new Rectangle(682,120, 53,66),
				new Rectangle(736,120, 57,66)
			
			
			
	
		};
		Animacion animacionenemigos = new Animacion("mover",coordenadasenemigos,0.1);
		animaciones.put("mover",animacionenemigos);
	}

	


	public void mover(){
		if (Juego.derecha)
			this.x-=velocidad;
	}
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x--, this.y,
				this.anchoImagen, this.altoImagen
				);
				
		graficos.strokeRect(this.x, this.y, this.ancho, this.alto);
	  //super.pintar2(graficos);

	}
	public Rectangle obtenerRectangulo() {
		
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
		public boolean isCapturado() {
			return capturado;
		}

		public void setCapturado(boolean capturado) {
			this.capturado = capturado;
		}
	
}
