package es.studium.Carrera;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jinete extends Thread
{
	CarreraJinetes carrera = new CarreraJinetes();

	private String nombre;
	private int i = 0;
	//private int trayectoRecorrido = 0;
	int distanciaCarrera = carrera.getDistanciaCarrera();
	int avance=0;
	int lanzamiento=0;
	public int quedan = 0;
	int tam = carrera.getNumJinetes();
	public static ArrayList<Jinete> camell;


	//int restante = 0;

	public Jinete (String name) {

		this.nombre = name;
	}

	
	
	public void run() {
		
//		listadoJinetes(camell);
//		for (Jinete jinete : camell)
//		{
//			System.out.println(jinete);
//		}
		System.out.println("Comienza el camello "+ nombre);
		avance = carrera.getDistanciaCarrera() - posicionActual(lanzamiento);		
		while(!CarreraJinetes.finCarrera) {
			lanzamiento = lanzarBola();			
			progresoCarrera(lanzamiento); 			
		}
	}

	public synchronized void progresoCarrera(int lanzamiento) {	
		
//		Jinete pos = new Jinete(camell);
		
		carrera.setDistanciaCarrera(avance);
		if (carrera.getDistanciaCarrera()>=lanzamiento) {
			System.out.println(nombre + " avanza "+ lanzamiento 
					+" metros, se encuentra a "+ (avance -=posicionActual(lanzamiento))  
					+ " metros del final " + nombre + " esta a "+ carrera.posicionCabeza);
		} else {
			System.out.println(nombre + " avanza "+ lanzamiento 
					+" metros, se encuentra a "+ fijarCero(avance -=posicionActual(lanzamiento))  
					+ " metros del final " + nombre + " esta a "+ carrera.posicionCabeza);
			CarreraJinetes.finCarrera = true;
			System.out.println("Fin de carrera, ha ganado el "+ nombre) ;

			System.exit(1);
		}

	}
	private synchronized int posicionActual(int lanzamiento) {

		int posicion = 0;
		if (carrera.getDistanciaCarrera() >= 0) {
			posicion +=lanzamiento;

		}else {
			System.out.println("Fin");
		}
		return posicion;

	}
	public int restanDelFinal(int metros, int lanzamiento) {


		metros -= lanzamiento;
		return metros;

	}
	
//	public ArrayList<Jinete> listadoJinetes(ArrayList<Jinete> cam){
//
//		
//		for (int i = 0; i < cam.size(); i++)
//		{
//			cam = new ArrayList<Jinete>(i);
//			
//			cam.add(this);
//		}
//		camell = cam;
//		return camell;
//	}
	//	public void comprobarPosicion(int posicion)	{
	//		
	//		for (int i = 0; i <tam; i++)
	//		{
	//			
	//			
	//		}
	//	}
//	public String firstPosition(Jinete[] pos) {
//		String nombre="";
//
//		for (int i = 0; i < camell.length; i++)
//		{
//			if (pos[i]!=pos[i+1]) {
//				System.out.println(pos[i].toString());
//			}else {
//				System.out.println(pos[i+1].toString());
//			}
//		}
//
//		return nombre;

//	}
	//	public int avanceTrayecto(Jinete o)
	//	{
	//		int resultado=0;		
	//
	//		if(distanciaCarrera<=trayectoRecorrido) {
	//			resultado = distanciaCarrera - trayectoRecorrido;
	//		}else {
	//			resultado = 0;
	//		}
	//
	//		return resultado;
	//	}
	
//	//Gracias a este método he conseguido aislar la posicion del que va el primero
//		public int primeraPosicion() {
//			int primero=0;
//		
//			//Bucle que recorre todo el listado de Jinetes
//			for (int i = 0; i < ListadoJinetes.length; i++)
//			{
//				//Mediante esta condición conseguimos capturar el número del Jinete que ha avanzado más.
//				if (ListadoJinetes[i] > primero) {
//					//capturamos el número del Jinete más avanzado
//					primero = ListadoJinetes[i];
//				}
//			}
//			//devolvemos el número del que va en primera posición 
//			return primero;
//			
//		}
	public synchronized int lanzarBola () {
		int resultado = 0;
		Random aleatorio = new Random();
		long sleep = 1 + aleatorio.nextInt(100)*(aleatorio.nextInt(10)+1);
		int lanzamiento = 1 + aleatorio.nextInt(100);
		if(lanzamiento <= 30) {
			resultado = 0;
			try
			{
				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (lanzamiento <= 70) {
			resultado = 1;
			try
			{

				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (lanzamiento <= 90) {
			resultado = 2;
			try
			{

				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else {
			resultado = 3;
			try
			{

				Thread.sleep(sleep);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//restante = restante - resultado;
		}

		return resultado;
	}
	//	public int restante ( int lanz) {
	//
	//		distanciaCarrera -= lanz;
	//
	//		return distanciaCarrera;
	//	}
	public String getJinete()
	{
		return nombre;
	}
	public void setJinete(String jinete)
	{
		nombre = jinete;
	}



	public static int fijarCero(int negativo) {
		if (negativo<=0) {
			return 0;
		}
		else {
			return negativo;
		}
	}
	

}
