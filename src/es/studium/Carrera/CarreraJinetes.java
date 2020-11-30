package es.studium.Carrera;

public class CarreraJinetes
{
	private static int distanciaCarrera;

	public static int numJinetes;

	//public Jinete camello;
	public static  int posicionCabeza=0;


	public int getPosicionCabeza()
	{
		return posicionCabeza;
	}
	public void setPosicionCabeza(int posCamello) {
		posicionCabeza = posCamello;
	}
	public synchronized static void setPosicionCabeza(int posCamello[])
	{
		for (int i = 0; i < posCamello.length; i++)
		{

			CarreraJinetes.posicionCabeza = posCamello[i];
		}

	}
	public static boolean finCarrera = false;




	public int getDistanciaCarrera()
	{
		return distanciaCarrera;
	}
	public void setDistanciaCarrera(int distanciaCarrera)
	{

		CarreraJinetes.distanciaCarrera = distanciaCarrera;

	}
	public static int getNumJinetes()
	{
		return numJinetes;
	}
	public static void setNumJinetes(int num)
	{
		numJinetes = num;
	}



}
