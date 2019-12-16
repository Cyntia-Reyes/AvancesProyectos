package Implementacion;

import java.util.HashMap;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import Clase.Animacion;

//import javax.swing.JFrame;

import Clase.Enemigos;
import Clase.Enemigos2;
import Clase.Item;
import Clase.Jugador;

import Clase.JugadorAnimado;
import Clase.Tile;
import Clase.Fondo;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;




public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	
	private int puntuacion = 0;
	//private Jugador jugador;
	//private Item items;
	private JugadorAnimado jugadoranimado;
	//private Jugador fondo;
    private Fondo fondo;
	private Fondo fondo1;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static boolean accion;
	public static boolean saltando=false;
	public static boolean sube=false;
	public static boolean baja=false;
	//public static boolean accion;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	public static boolean fin;
	
	private ArrayList<Item> items;
	int randomx,randomy,randomyy;
	int randomxV,randomyV,randomyyV;
	
	private ArrayList<Enemigos> enemigos;
	private ArrayList<Enemigos2> enemigos2;
	
	//private ArrayList<Image> imagenes;
	
	
	private ArrayList<Tile> tiles;
	
	private int[][] mapa = {
			{0,0,0,0,0,0,0,0,0,0,0,0,9,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,7,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,8,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,7,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,8,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,7,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,8,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
		
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,7,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,7,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,8,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,7,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,12,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,12,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,8,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,8,0,15,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,12,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,12,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,12,2,1,1,1},
			{0,0,0,0,0,7,0,0,0,7,0,0,12,2,1,1,1},
			{0,0,0,0,0,2,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,8,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,7,13,13,13,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,0,0,2,0,0,0,2,1,1,1},
			{0,0,0,0,0,8,0,0,0,8,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,15,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,15,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,14,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,14,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,14,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,14,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,14,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
		
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,7,0,0,0,15,2,1,1,1},
			{0,0,0,0,0,0,0,0,2,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,2,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,2,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,2,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,7,0,0,2,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,12,2,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,12,2,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,2,0,12,2,0,0,0,15,2,1,1,1},
			{0,0,0,0,0,8,0,0,8,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,7,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,7,13,13,2,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,0,8,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,2,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,12,2,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,12,2,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,12,8,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,14,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,14,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,14,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5,5},
			
			{0,0,0,0,0,0,0,0,0,0,0,0,4,18,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,7,0,0,0,0,0,19,2,1,1,1,1},
			{0,0,0,0,0,2,0,0,0,0,0,19,2,1,1,1,1},
			{0,0,0,0,0,2,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,2,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,8,0,0,7,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,0,0,0,2,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,7,0,0,8,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,2,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,2,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,2,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,8,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,3,1,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,7,0,0,19,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,19,2,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,3,1,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,2,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,8,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,7,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,8,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},

			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,0,6,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5},
			{0,0,0,0,0,0,0,0,0,14,0,0,0,0,6,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,5,5},
			{0,0,0,0,0,0,0,0,0,0,0,14,0,0,6,5,5},
			
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},			
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,1},
			
			
			
			
			
			
			
			
			
	};
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		cargarImagenes();
		ventana.setTitle("EL GUARDIAN DEL PLANETA TIERRA");
		root = new Group();
		escena = new Scene(root,1000,500);
		gestionarEventos();
		canvas  = new Canvas(1000,500);
	//imagenes = new HashMap<String,Image>();	
		
		graficos = canvas.getGraphicsContext2D();
		ventana.setScene(escena);
		root.getChildren().add(canvas);
		cicloJuego();	
		ventana.show();
		
	/*	ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  while (!jueguito.juegoFinalizado) {
	            jueguito.repaint();
	            try {
	                Thread.sleep(15);
	            } catch (InterruptedException ex) {
	                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        jueguito.repaint();*/
	
	
	
		
	}
	
	public void inicializarComponentes() {
		items= new ArrayList<Item>();
		enemigos= new ArrayList<Enemigos>();
	
		imagenes = new HashMap<String,Image>();
	
		
		fondo = new Fondo(0,0,5,"fondo");
		enemigos=new ArrayList<Enemigos>();
		for (int z=0;z<30;z++) {
			randomyyV=(int)(Math.random()*3+1);
			randomxV=(int)(Math.random()*26000+3000);
			if (randomyyV==1)
				randomyV=200;
			if (randomyyV==2)
				randomyV=150;
			if (randomyyV==3)
				randomyV=270;
			enemigos.add(new Enemigos(randomxV, randomyV,z, z, 4, "mover", null));
		}
		
		enemigos2=new ArrayList<Enemigos2>();
		for (int z=0;z<30;z++) {
			randomyyV=(int)(Math.random()*3+1);
			randomxV=(int)(Math.random()*26000+3000);
			if (randomyyV==1)
				randomyV=240;
			if (randomyyV==2)
				randomyV=270;
			if (randomyyV==3)
				randomyV=100;
			enemigos2.add(new Enemigos2(randomxV, randomyV, 4, "enemigo3", z, z,"mover", z, z, z, z, z, false, null));
		}
		
		
	//	fondo1 = new Fondo((int)imagenes.get("fondo").getWidth(),0,5,"fondo1");
		
	
		
		//jugadoranimado = new JugadorAnimado(10,345,0, 0, "personaje",1, null, "descanso", 0, false, false, false, 0);
		
		jugadoranimado = new JugadorAnimado(10,360,0, 0, "personaje",1, null, "correr", 0, false, false, false, 0);
		//jugadoranimado = new JugadorAnimado(10,360,0, 0, "personaje",1, null, "saltar", 0, false, false, false, 0);
	    //enemigos = new Enemigos(720,200,0, 0, 1, null, "enemigos");
		
		//enemigos = new Enemigos(50,500,"3",1, "enemigos");
		
		//items = new Item(10,360,0, "item1",null, "monedas");
		
		items.add(new Item(250,200,0,"item"));
		items.add(new Item(300,200,0,"item"));
		items.add(new Item(350,200,0,"item"));
		
		items.add(new Item(500,200,0,"item"));
		items.add(new Item(550,200,0,"item"));
		items.add(new Item(600,200,0,"item"));
		
		items.add(new Item(750,200,0,"item"));
		items.add(new Item(800,200,0,"item"));
		items.add(new Item(850,200,0,"item"));
		
		items.add(new Item(1370,150,0,"item"));
		items.add(new Item(1420,150,0,"item"));
		items.add(new Item(1470,150,0,"item"));
		
		items.add(new Item(1620,150,0,"item"));
		items.add(new Item(1670,150,0,"item"));
		items.add(new Item(1720,150,0,"item"));
		
		
		
		
		items.add(new Item(1370,270,0,"item"));
		items.add(new Item(1420,270,0,"item"));
		items.add(new Item(1470,270,0,"item"));
		items.add(new Item(1520,270,0,"item"));
		items.add(new Item(1570,270,0,"item"));
		items.add(new Item(1620,270,0,"item"));
		
		

		items.add(new Item(2020,240,0,"item"));
		items.add(new Item(2070,240,0,"item"));
		items.add(new Item(2120,240,0,"item"));
		items.add(new Item(2170,240,0,"item"));
		items.add(new Item(2220,240,0,"item"));
		
		items.add(new Item(2020,100,0,"item"));
		items.add(new Item(2070,100,0,"item"));
		items.add(new Item(2120,100,0,"item"));
		items.add(new Item(2170,100,0,"item"));
		items.add(new Item(2270,100,0,"item"));
		
		items.add(new Item(2320,100,0,"item"));
		items.add(new Item(2370,100,0,"item"));
		items.add(new Item(2420,100,0,"item"));
		
		
		
		items.add(new Item(2750,330,0,"item"));
		items.add(new Item(2805,230,0,"item"));
		
		items.add(new Item(2875,330,0,"item"));
		items.add(new Item(2950,230,0,"item"));
		
		items.add(new Item(3005,330,0,"item"));
		items.add(new Item(3085,230,0,"item"));
		
		items.add(new Item(3135,330,0,"item"));
		items.add(new Item(3230,230,0,"item"));
		
		items.add(new Item(3260,330,0,"item"));
		items.add(new Item(3365,230,0,"item"));
		
		items.add(new Item(3390,330,0,"item"));


		/*
		items.add(new Item(1620,150,0,"item"));
		items.add(new Item(1670,150,0,"item"));
		items.add(new Item(1720,150,0,"item"));	
		items.add(new Item(1670,150,0,"item"));
		items.add(new Item(1720,150,0,"item"));
		items.add(new Item(1620,150,0,"item"));
		items.add(new Item(1670,150,0,"item"));
		items.add(new Item(1720,150,0,"item"));
		*/
		
		
	//	enemigos.add(new Enemigos(900,300,0, 0,0, "3", null));

		
		/*item = new Item(120,200,0,0,0, "item");
		item2 = new Item(170,200,0,0,0,"item");
		item3 = new Item(220,200,0,0,0,"item");
		
		item4 = new Item(420,200,0,0,0,"item");
		item5 = new Item(470,200,0,0,0,"item");
		item6 = new Item(520,200,0,0,0,"item");
		
		item7= new Item(720,200,0,0,0,"item");
		item8 = new Item(770,200,0,0,0,"item");
		item9 = new Item(820,200,0,0,0,"item");*/
		cargarImagenes();
		cargarTiles();
		
		
	
		
	}
	
	public void cargarImagenes() {
		
		
		
		imagenes.put("personaje", new Image("personaje.png"));
		imagenes.put("54", new Image("54.png"));
		imagenes.put("enemigo3", new Image("enemigo3.png"));
		imagenes.put("enemigo", new Image("enemigo.png"));
		imagenes.put("fondo",new Image("fondo.jpg"));
		
		imagenes.put("item", new Image("item.png"));
		imagenes.put("item1", new Image("item1.png"));
	}
	
	public void pintar() {
		graficos.setFill(Color.WHITE);
		graficos.fillRect(0, 0, 1000, 500);
		graficos.setFill(Color.BLACK);
		graficos.fillText("Puntuacion: " + puntuacion, 10, 10);
	//	items.pintar(graficos);
		fondo.pintar(graficos);
		//fondo1.pintar(graficos);
		
		//jugador.pintar(graficos);
		jugadoranimado.pintar(graficos);
		//enemigos.pintar(graficos);
		//enemigos.pintar(graficos);
		///Pintar tiles
			for (int i=0;i<tiles.size();i++)
				tiles.get(i).pintar(graficos);
				
				
			for (int i=0; i<items.size();i++)
				items.get(i).pintar(graficos);
			
	
		    for(int i=0; i<enemigos.size(); i++)
		   	enemigos.get(i).pintar(graficos);
		    
		    for(int i=0; i<enemigos2.size(); i++)
			   	enemigos2.get(i).pintar(graficos);
				//(graficos.setFont(new Font(30));
				//graficos.fillText(String.valueOf(jugador.getPuntuacion()), 10d, 30d);
	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*33, j*33, "54",0));
		
			}
		}

				
			}
	
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT": //derecha
							derecha=true;
							JugadorAnimado.animacionActual="correr";
							break;
						case "LEFT": //derecha
							izquierda=true;
						break;
						case "UP":
							arriba=true;
							JugadorAnimado.animacionActual="saltar";
							//jugadoranimado= new JugadorAnimado(10,360,0, 0, "personaje",1, null, "saltar", 0, false, false, false, 0);
							if(JugadorAnimado.y!=50)
								JugadorAnimado.y-=50;
							
							break;
						case "DOWN":
							JugadorAnimado.animacionActual="correr";
							if(JugadorAnimado.y!=-50)
								JugadorAnimado.y+=50;
							abajo=true;
							break;
						case "SPACE":
						
							
							//jugadoranimado = new JugadorAnimado(10,360,0, 0, "personaje",1, null, "correr", 0, false, false, false, 0);

							jugadoranimado.setVelocidad(10);
							jugadoranimado.setIndiceImagen("personaje");
							Enemigos.setVelocidad(8);
							//	Enemigos2.setVelocidad(8);
								
								Animacion.setDuracion(0.05);
							
							break;
					
							
					}
			}			
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					JugadorAnimado.animacionActual="correr";
					
					Animacion.setDuracion(0.1);
					break;
				case "LEFT": //derecha
					izquierda=false;
				break;
				case "UP":
					arriba=false;
				  
					
					break;
				case "DOWN":
					abajo=false;
				break;
				case "SPACE":
					//saltando = false;
					
					jugadoranimado.setVelocidad(1);
					jugadoranimado.setIndiceImagen("personaje");
					Enemigos.setVelocidad(4);
					//Enemigos2.setVelocidad(4);
					
					Animacion.setDuracion(0.1);
					
					
					//jugadoranimado = new JugadorAnimado(10,360,0, 0, "personaje",1, null, "correr", 0, false, false, false, 0);
					break;
				
			}
				
				
			}
			
		});
		
	

	
		
	}
	
		
	
	

	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				if(!Juego.fin==true) {
					pintar();
					actualizar(t);
					}else {
					
				}
					//Alert mensaje= new Alert(null);
				}	
				
				
			
			
		};
		animationTimer.start(); //Inicia el ciclo
	}

	public void actualizar(double t) {
		jugadoranimado.mover();
        //enemigos.actualizarAnimacion(t);
		jugadoranimado.actualizarAnimacion(t);
		
		
		for (int i=0; i<items.size();i++) {
			if  (jugadoranimado.verificarColisiones(items.get(i)))
				items.remove(items.get(i));
			
		}
		
		for (int i=0; i<items.size();i++)
			items.get(i).mover();	
		
		
		


		 for (int i=0; i<tiles.size();i++) {
			if (jugadoranimado.verificarColisiones(tiles.get(i)))
				tiles.remove(tiles.get(i));
			
		}
		
		
		 	for (int i=0; i<tiles.size();i++)
		 		tiles.get(i).mover();
	
	
	
	
	
		
	
	
	}
	
	
		/*	private void cambiarFondos() {
				if (fondo1.getX() <= 0) {
					fondo.setX((int)imagenes.get("fondo1").getWidth()+fondo1.getX());
				}
		
				if (fondo.getX() <= 0) {
					fondo1.setX((int)imagenes.get("fondo").getWidth()+fondo.getX());
				}
		*/
	

	

	
		public void actualizar() {
			fondo.mover();
			//fondo1.mover();
			//cambiarFondos();
			
			/*for (int i=0; i<items.size();i++) {
				if (jugadoranimado.verificarColisiones(items.get(i)))
					items.remove(items.get(i));
				
			}
			
			for (int i=0; i<items.size();i++)
				items.get(i).mover();
			*/
		
			for (int i=0; i<enemigos.size();i++) {
				if (jugadoranimado.verificarColisiones(enemigos.get(i)))
					enemigos.remove(enemigos.get(i));
			
			 
			 for (int i=0; i<enemigos.size();i++)
			 		enemigos.get(i).mover();
			
			
			}
		}
		}
			


		