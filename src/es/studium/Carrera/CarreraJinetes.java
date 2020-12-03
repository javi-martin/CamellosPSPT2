package es.studium.Carrera;

public class CarreraJinetes {
	private static int distanciaCarrera;

	public static int numJinetes;

	public static int posicionCabeza = 0;

	public static boolean finCarrera = false;

	public int getPosicionCabeza() {
		return posicionCabeza;
	}

	public void setPosicionCabeza(int posCamello) {
		posicionCabeza = posCamello;
	}

	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}

	public void setDistanciaCarrera(int distanciaCarrera) {

		CarreraJinetes.distanciaCarrera = distanciaCarrera;

	}

	public static int getNumJinetes() {
		return numJinetes;
	}

	public void setNumJinetes(int num) {
		numJinetes = num;
	}
}
