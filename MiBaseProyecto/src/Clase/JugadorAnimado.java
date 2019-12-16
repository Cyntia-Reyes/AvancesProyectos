package Clase;

import java.awt.event.KeyEvent;
import java.util.HashMap;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado {
	private int x;
	public static int y;
	private int x1;
	private int y1;
	private int ancho;
	private int alto;
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion> animaciones;
	public static String animacionActual;
	private int puntuacion = 0;
    boolean saltando=false;
    boolean sube=false;
    boolean baja=false;
	
	//Coordenadas para el fragmento de la imagen a pintar
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;

	//private EstadoSalto estadosalto;
	//private float alturasalto;
	//private float yoriginal;
	/*public JugadorAnimado(int x, int y,int x1, int y1, String indiceImagen, int velocidad, String animacionActual) {
		super();
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animacionActual = animacionActual;
		inicializarAnimaciones();
	}*/
	
	
	
	
	public JugadorAnimado(int x, int y, int x1, int y1, String indiceImagen, int velocidad,
			HashMap<String, Animacion> animaciones, String animacionActual, int puntuacion, boolean saltando,
			boolean sube, boolean baja, int altoImagen) {
		super();
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		//this.ancho= (int)Juego.imagenes.get(this.indiceImagen).getWidth();
		//this.alto= (int)Juego.imagenes.get(this.indiceImagen).getHeight();
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		this.animaciones = animaciones;
		this.animacionActual = animacionActual;
		this.puntuacion = puntuacion;
		this.saltando = saltando;
		this.sube = sube;
		this.baja = baja;
		this.altoImagen = altoImagen;
		inicializarAnimaciones();
		
		//jugadoranimado.setPosition(X,Y);
		//alturasalto= 0;
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
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY(int y1) {
		this.y1 = y1;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	//Obtener las coordenas del fragmento de la imagen a pintar
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
		/*switch(estadosalto) {
		case SUBIENDO;
		case BAJANDO;
		moverVerticalmente(tiles);
		break;
		}
		private void moverVerticalmente(Tile tiles) {
			float delta= Gdx.graphics.getDeltaTime()*200;
			switch(estadosalto) {
			case SUBIENDO:
			jugadoranimado.setY(jugadoranimado.getY()+delta);
			alturasalto += delta;
			if(alturasalto>=2*jugadoranimado.getHeight()) {
				estadosalto= estadosalto.BAJANDO;
			}
			break;
			case bajando:
				jugadoranimado.setY(jugadoranimado.getY()-delta);
				alturasalto -=delta;
				if(alturasalto<=0) {
					estadosalto = Estadosalto.EN_PISO;
					alturasalto = 0;
					jugadoranimado.setY(yoriginal);
			}
				break;
			}
			public enum Estadosalto{
				SUBIENDO,
				BAJANDO,
				EN_PISO
			}
			
			public void saltar() {
				if(estadosalto!=Estadosalto.SUBIENDO && estadosalto!=Estadosalto.BAJANDO) {
					estadosalto= Estadosalto.SUBIENDO;
					yoriginal=jugadoranimado.getY();
					alturasalto= 0;
				}*/
	
			/*	static boolean j=false;
				if(key == ' ' && j==false)
					J=true;
				if(j && jugadoranimado.y<maxheight)
					JugadorAnimado.y ++;
				if(jugadoranimado.y > maxheight)
					JugadorAnimado--;
				if(jugadoranimado.y< minheight)
					J= false;
							
			
			*/
		
	
	public void mover(){
	/*	f (Juego.accion) {
			this.velocidad = 20;
			this.indiceImagen = "Guardian0";
		}else {
			this.velocidad = 10;
			this.indiceImagen = "Guardian0";
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
		
        
        if(saltando)
        {
            if(y == 200)//el personaje esta en el suelo
                {sube=true;
                y=-5;
                baja=false;}
            if(y == 90)//el personale llego al limite del salto{
            	baja=true;
                y=5;
                sube=false;
                }
            
            
            if(sube)
                {
                    y = y + y1;
                }
            if(baja)
                {
                    
                    y = y + y1;
                    if(y == 200)
                    {
                        saltando=false;
                    }
                }
        }

	
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen,
				this.x, this.y,
				this.anchoImagen, this.altoImagen
		);
		//graficos.fillRect(this.x, this.y, this.anchoImagen, this.altoImagen);
		graficos.fillText("Puntuacion " + puntuacion, 920, 20);
	}
	
	public Rectangle obtenerRectangulo() {
		
		return new Rectangle(this.x+5, this.y, this.anchoImagen, this.altoImagen);
	}
	public void keyPressed(KeyEvent e) {
		
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                saltando=true;
            }
	}
	
	public void inicializarAnimaciones() {
			animaciones = new HashMap<String, Animacion>();
			Rectangle coordenadasCorrer[]= {
					
					new Rectangle(0, 328, 55,73),
					new Rectangle(70,328, 59,71),
					new Rectangle(145,328, 54,72),
					new Rectangle(218,328, 56,74),
					new Rectangle(286,328, 59,73),
					new Rectangle(361,328, 57,63),
					
					new Rectangle(440,328, 57,72),
					new Rectangle(520,328, 49,74),
					
					new Rectangle(591,329, 50,72),
					new Rectangle(663,328, 50,71),
					
					new Rectangle(736,328, 50,72),
					new Rectangle(804,328, 57,72)
					
			
					
					
					/*new Rectangle(10, 243, 51,68),
					new Rectangle(98,247, 37,64),
					new Rectangle(176,245, 38,67),
					new Rectangle(247,248, 41,62),
					new Rectangle(326,246, 43,65),
					new Rectangle(406,249, 47,60),
					new Rectangle(405,249, 41,63),
					new Rectangle(484,249, 44,62),
					new Rectangle(554,248, 47,63),
					new Rectangle(641,248, 40,61)*/
					
					
		
			
				
			};
			
			
			Animacion animacionCorrer = new Animacion("correr",coordenadasCorrer,0.07);
			animaciones.put("correr",animacionCorrer);
			
			Rectangle coordenadasDescanso[] = {
					new Rectangle(-2, -1, 66,91),
					new Rectangle(75,-1, 74,90),
					new Rectangle(139,-2, 70,90),
					new Rectangle(219,0, 66,88)
					
					
					
					
					/*new Rectangle(15, 166, 47,66),
					new Rectangle(94,166, 45,65),
					new Rectangle(175,168, 43,65),
					new Rectangle(408,169, 41,64)*/
					
		
			};
			Animacion animacionDescanso = new Animacion("descanso",coordenadasDescanso,0.2);
			animaciones.put("descanso",animacionDescanso);
			
			Rectangle coordenadasSaltar[] = {
					new Rectangle(7, 87, 56,81),
					new Rectangle(80,88, 49,88),
					new Rectangle(151,87, 58,80),
					new Rectangle(232,88, 49,80)
					
					
					
					
					/*new Rectangle(15, 166, 47,66),
					new Rectangle(94,166, 45,65),
					new Rectangle(175,168, 43,65),
					new Rectangle(408,169, 41,64)*/
					
		
			};
			Animacion animacionSaltar = new Animacion("saltar",coordenadasSaltar,0.2);
			animaciones.put("saltar",animacionSaltar);
	}
	
	
	public boolean verificarColisiones(Item items) {
		if (this.obtenerRectangulo().intersects(items.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!items.isCapturado())
					this.puntuacion++;
				items.setCapturado(true);	
				//agregarPuntuacion(1);
	
		}
		return false;
	}

	
	public boolean verificarColisiones(Enemigos enemigos) {
		if (this.obtenerRectangulo().intersects(enemigos.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!enemigos.isCapturado())
					Juego.fin=true;
				enemigos.setCapturado(true);
		}
               return false;
	
		}
	public boolean verificarColisiones(Enemigos2 enemigos2) {
		if (this.obtenerRectangulo().intersects(enemigos2.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!enemigos2.isCapturado())
					Juego.fin=true;
				enemigos2.setCapturado(true);
		}
               return false;
	
		}
	public boolean verificarColisiones(Tile tiles) {
		if (this.obtenerRectangulo().intersects(tiles.obtenerRectangulo().getBoundsInLocal())) {
				System.out.println("Estan colisionando");
				if (!tiles.isCapturado())
					
				tiles.setCapturado(true);
		}
               return false;
}
}
