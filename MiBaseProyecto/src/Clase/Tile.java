package Clase;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;



public class Tile {
	private int x;
	private int y;
	//Parametros dentro de la imagen principal
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private String indiceImagen;
	private int velocidad;
	private int invertir=1;
	private boolean capturado;
	public Tile(int x, int y, int anchoImagen, int altoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super();
		this.x = x;
		this.y = y;
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}
	
	public Tile(int tipoTile,int x, int y, String indiceImagen, int velocidad){
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		//this.invertir = invertir;
		switch(tipoTile){
			case 1:
				//TIERRA
				this.altoImagen = 33;
				this.anchoImagen =33;
				this.xImagen =62;
				this.yImagen =278;
			break;
			case 2:
				//BORDE ARRIBA MONTE
				this.altoImagen = 33;
				this.anchoImagen =33;
				this.xImagen = 62;
				this.yImagen = 238;
			break;
			case 3:
				//BORDE IZQUIERDA MONTE
				this.altoImagen = 33;
				this.anchoImagen =33;
				this.xImagen = 216;
				this.yImagen =239;
						;
			break;
			case 4:
				//BORDE DERECHA MONTE
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 255;
				this.yImagen = 240;
			break;
			case 5:
				//CUADRO DE AGUA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 372;
				this.yImagen = 123;
			break;
			case 6:
				//BORDE ARRIBA DE AGUA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 373;
				this.yImagen = 84;
			break;
			case 7:
				//BORDE DE PLATAFORMA IZQUIERDA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 178;
				this.yImagen = 238;
			break;
			case 8:
				//BORDE DE PLATAFORMA DERECHA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 178;
				this.yImagen = 276;
			break;
			case 9:
				//FLECHA DERECHA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 565;
				this.yImagen = 394;
			break;
			case 10:
				//ARBUSTOS
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 604;
				this.yImagen = 129;
				break;
			case 11:
				//CUADRO BORDE DERECHA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 216;
				this.yImagen = 277;
			break;
			case 12:
				//BLOQUE DE MADERA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 449;
				this.yImagen = 316;
			break;
			case 13:
				//ESCALERA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 372;
				this.yImagen = 204;
			break;
			case 14:
				//CUADRO CON CARA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 324;
				this.yImagen = 1166;
			break;
			case 15:
				//TRONCO
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 810;
				this.yImagen = 381;
			break;
			
			case 16:
				//MADERA
				this.altoImagen = 33;
				this.anchoImagen = 14;
				this.xImagen = 1012;
				this.yImagen = 369;
			break;
			case 17:
				//MADERA
				this.altoImagen = 33;
				this.anchoImagen = 18;
				this.xImagen = 294;
				this.yImagen = 277;
			break;
			
			case 18:
				//BORDE MONTE IZQUIERDA
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 256;
				this.yImagen = 278;
			break;
			case 19:
				//CAJA CON DOBLE X
				this.altoImagen = 33;
				this.anchoImagen = 33;
				this.xImagen = 411;
				this.yImagen = 317;
			break;
		}
		this.x = x;
		this.y = y;
		this.indiceImagen = indiceImagen;
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
	public int getAltoImagen() {
		return altoImagen;
	}
	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}
	public int getAnchoImagen() {
		return anchoImagen;
	}
	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
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
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public void pintar(GraphicsContext graficos) {
			graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x--, this.y,
				this.anchoImagen, this.altoImagen
			);
			/*
			
			  graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x + (invertir==-1?70:0), this.y,
				this.anchoImagen*invertir, this.altoImagen
			);
		*/
	}
	public void mover(){
		/*	f (Juego.accion) {
				this.velocidad = 20;
				this.indiceImagen = "Guardian0";
			}else {
				this.velocidad = 10;
				this.indiceImagen = "Guardian0";
			}*/
		/*	if (this.x>=1500)
				this.x = -100;
			
			if (Juego.izquierda)
				this.x+=velocidad;
			
			if (Juego.izquierda)
				this.x-=velocidad;
			
			if (Juego.arriba)
				this.y-=velocidad;
			
			if (Juego.abajo)
				this.y+=velocidad;
			*/
	        
	
	
}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, altoImagen);
	
	}
	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}


/*
if (condicion)
	verdadero
else 
	falso
	
	
condicion?verdadero:falso;*/
