package es.studium.Carrera;

public class CarreraJinetes
{
	private static int distanciaCarrera;

	private int numJinetes;

	//public Jinete camello;
	public static  int posicionCabeza=0;


	public static int getPosicionCabeza()
	{
		return posicionCabeza;
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
	public int getNumJinetes()
	{
		return numJinetes;
	}
	public void setNumJinetes(int numJinetes)
	{
		this.numJinetes = numJinetes;
	}



}
