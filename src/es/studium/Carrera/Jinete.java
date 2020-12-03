package es.studium.Carrera;

import java.util.ArrayList;
import java.util.Random;

public class Jinete extends Thread
{
	static CarreraJinetes carrera = new CarreraJinetes();

	private int nombre, metros;
//	private int i = 0;
	//private int trayectoRecorrido = 0;
//	int distanciaCarrera = carrera.getDistanciaCarrera();
	int avance=0;
	int lanzamiento=0;
	int posicion = 0;
	int ganador, segundo, tercero = 0;
//	int posicionFinal =0;
//	public int quedan = 0;
//	static int tam = carrera.getNumJinetes();
	public static int listaCamellos[] = new int[carrera.getNumJinetes()];
	public static int podio[] = new int[3];

	//int restante = 0;

	public Jinete (int name) {

		this.nombre = name;
	}

	
	
	public void run() {
				
		System.out.println("Comienza el camello "+ nombre);
		avance = carrera.getDistanciaCarrera() - posicionActual(lanzamiento);
//		primeraPosicion();
		while(!CarreraJinetes.finCarrera) {
		
			lanzamiento = lanzarBola();			
			progresoCarrera(lanzamiento); 			
		}
	}

	public synchronized void progresoCarrera(int lanzamiento) {	
		
//		Jinete pos = new Jinete(camell);
		
		carrera.setDistanciaCarrera(avance);
//		System.out.println("posicionActual--->"+(avance -posicionActual(lanzamiento)));
		listaCamellos[(nombre - 1)] = avanceCamello(lanzamiento);
		
		if (carrera.getDistanciaCarrera()>lanzamiento) {			
		
			System.out.println("Camello "+nombre + " avanza "+ lanzamiento 
					+" metros, se encuentra a "+ (avance -=posicionActual(lanzamiento))  
					+ " metros del final " +" y a avanzado "+ avanceCamello(lanzamiento)+" metros");
			
		} else if (carrera.getDistanciaCarrera()==lanzamiento) {
				CarreraJinetes.finCarrera=true;
				System.out.println("Camello "+nombre + " avanza "+ lanzamiento 
						+" metros, se encuentra a "+ (avance -=posicionActual(lanzamiento))  
						+ " metros del final " +" y a avanzado "+ avanceCamello(lanzamiento)+" metros");
				ganador = avanceCamello(lanzamiento);
				System.out.println();
				System.out.println("%%%%%%%%%%  FIN DE CARRERA  %%%%%%%%%%%");
				System.out.println();
				System.out.println("¡¡¡ Ha ganado el Camello "+ nombre + " !!!");
				
				System.out.println();
				System.out.println("%%%%%%%%%%    PODIO FINAL   %%%%%%%%%%%");
				ordenarPosiciones(listaCamellos);
				for (int i = 0; i < listaCamellos.length; i++)
				{
					System.out.println((i+1)+"º puesto para Camello "+ listaCamellos[i]);
				}
				System.out.println();
				
				
				
				System.exit(1);
			
		}

	}
	
	
	public static void ordenarPosiciones(int actual[]) {
		int cuentaIntercambios = 0;
		
		for (boolean ordenado = false; !ordenado;){
			//Mientras no se cumpla la condición anterior seguirá dando vueltas hasta que se ordene
			for (int i = 0; i < actual.length - 1; i++)
			{
				if (actual[i] < actual[i+1]) {
					//Intercambiamos los valores
					int variableAuxiliar = actual[i];
					actual[i] = actual [i + 1];
					actual[i +1] = variableAuxiliar;
					//Ahora le indicamos que se ha producido un cambio
					cuentaIntercambios++;
				}
				
			}
			//Con esta condición comprobamos si no hay intercambios, lo que significa que está ordenado
			if(cuentaIntercambios == 0) {
				ordenado = true;
			}
			//Inicializamos de nuevo esta variable para que empieze de nuevo a contar
			cuentaIntercambios = 0;
		}
		
	}
	
//	public static int[] posicionFinal(int[] arreglo)
//    {
//      int auxiliar;
//      int[] arregloOrdenado;
//      for(int i = 2; i < arreglo.length; i++)
//      {
//        for(int j = 0;j < arreglo.length-i;j++)
//        {
//          if(arreglo[j] > arreglo[j+1])
//          {
//            auxiliar = arreglo[j];
//            arreglo[j] = arreglo[j+1];
//            arreglo[j+1] = auxiliar;
//          }   
//        }
//      }
//      arregloOrdenado = arreglo;
//      return arregloOrdenado;
//    }
//	 
	public int[] posicionFinal(int[] actual) {
		
		int [] posicionFinal = new int[actual.length];
		
		for (int i = 0; i < posicionFinal.length; i++)
		{
			posicionFinal[i] = i+1;
			
		}
//		for (int i = 0; i < posicionFinal.length; i++)
//		{
//			System.out.println("Contenido posiciones posicionFinal["+i+"]"+posicionFinal[i]);
//		}
		
		return posicionFinal;
		

	}
	private int posicionActual(int lanzamiento) {
	int lugar = 0;
		if (carrera.getDistanciaCarrera() >=0) {
			lugar +=lanzamiento;
		}
		return lugar;

	}

	public int avanceCamello(int tirada) {
		
		int variablePosicion = getMetros();
		int avanceJinete = variablePosicion + tirada;
		setMetros(avanceJinete);
		return avanceJinete;
	}
	
	
	
	//Gracias a este método he conseguido aislar la posicion del que va el primero
		public int primeraPosicion() {
			int primero=0;
		
			//Bucle que recorre todo el listado de Jinetes
			for (int i = 0; i < listaCamellos.length; i++)
			{
				//Mediante esta condición conseguimos capturar el número del Jinete que ha avanzado más.
				if (listaCamellos[i] > primero) {
					//capturamos el número del Jinete más avanzado
					primero = listaCamellos[i+1];
				}
			}
			//devolvemos el número del que va en primera posición 
			return primero;
			
		}
	public int lanzarBola () {
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
	public int getJinete()
	{
		return nombre;
	}
	public void setJinete(int jinete)
	{
		nombre = jinete;
	}



	public int getNombre()
	{
		return nombre;
	}



	public void setNombre(int nombre)
	{
		this.nombre = nombre;
	}



	public int getMetros()
	{
		return metros;
	}



	public void setMetros(int metros)
	{
		this.metros = metros;
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
