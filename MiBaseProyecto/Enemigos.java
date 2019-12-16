package Clase;

import java.util.HashMap;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigos {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	private String indiceImagen;
	private boolean capturado;
	private HashMap<String, Animacion> animaciones;
	private String animacionActual;
	private int puntuacion = 0;
	
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	
	
	

	/*public Enemigos(int x, int y, String i,int velocidad, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.indiceImagen = i;
		this.velocidad= velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}*/

	
	


	public Enemigos(int x, int y, int ancho, int alto, int velocidad, String indiceImagen, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.indiceImagen = indiceImagen;
		this.animacionActual = animacionActual;
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

	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	public void mover(){
		if (this.x>=1100)
			this.x = -100;
	/*	if (Juego.izquierda)
			this.x+=velocidad;
		
		if (Juego.izquierda)
			this.x-=velocidad;
		
		if (Juego.arriba)
			this.y-=velocidad;
		
		if (Juego.abajo)
			this.y+=velocidad;
	}*/
	}
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x--, this.y,
				this.anchoImagen, this.altoImagen
				);
				
	//	graficos.strokeRect(this.x, this.y, this.ancho, this.alto);
	
	/*	if (this.capturado)
			return;
		
		
		graficos.drawImage(Juego.imagenes.get(indiceImagen), x--, y);
		
	*/
	}
	public Rectangle obtenerRectangulo() {
		
		return new Rectangle(this.x+5, this.y, this.anchoImagen, this.altoImagen);
	}
		public boolean isCapturado() {
			return capturado;
		}

		public void setCapturado(boolean capturado) {
			this.capturado = capturado;
		}
	
	public void inicializarAnimaciones() {
		animaciones = new HashMap<String, Animacion>();
		Rectangle coordenadasenemigos[]= {
				new Rectangle(71, 249, 71,60),
				new Rectangle(144,249, 76,62),
				new Rectangle(221,247, 69,65),
				new Rectangle(292,248, 67,61),
				new Rectangle(362,249, 64,61),
				new Rectangle(427,249, 69,59),
				new Rectangle(495,247, 71,64),
				new Rectangle(567,249, 75,66),
				new Rectangle(643,249, 72,68),
				new Rectangle(716,248, 71,63)
			
			
	
		};
		Animacion animacionenemigos = new Animacion("enemigos",coordenadasenemigos,0.08);
		animaciones.put("enemigos",animacionenemigos);
	}


	
	}



