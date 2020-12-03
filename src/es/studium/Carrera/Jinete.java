package es.studium.Carrera;

import java.util.Random;

public class Jinete extends Thread {
	static CarreraJinetes carrera = new CarreraJinetes();

	private int nombre, metros;
	int distanciaRestante = carrera.getDistanciaCarrera();
	int lanzamiento;
	public static int listaPodio[] = { 0, 0, 0 };

	public Jinete(int name) {

		this.nombre = name;
	}

	public void run() {

		System.out.println("Comienza el camello " + nombre);
		while (!CarreraJinetes.finCarrera && distanciaRestante > 0) {

			lanzamiento = lanzarBola();
			progresoCarrera(lanzamiento);
		}
	}

	public synchronized void progresoCarrera(int lanzamiento) {

		if (distanciaRestante > lanzamiento) {

			distanciaRestante -= lanzamiento;

			System.out.println("Camello " + nombre + " avanza " + lanzamiento + " metros, se encuentra a "
					+ distanciaRestante + " metros del final ");

		} else if (distanciaRestante <= lanzamiento) {

			System.out.println();

			distanciaRestante = 0;

			System.out.println("Camello " + nombre + " avanza " + lanzamiento + " metros, llega a la meta");

			if (listaPodio[0] == 0) {

				listaPodio[0] = nombre;
			} else if (listaPodio[1] == 0) {

				listaPodio[1] = nombre;
			} else if (listaPodio[2] == 0) {

				listaPodio[2] = nombre;
			}

			if (listaPodio[2] != 0 || (carrera.getNumJinetes() < 3 && listaPodio[1] != 0)) {

				mensajeFinCarrera(listaPodio);
				carrera.finCarrera = true;

				System.exit(1);
			}

			System.out.println();
		}

	}

	private void mensajeFinCarrera(int[] listaPodio) {
		System.out.println();
		System.out.println("%%%%%%%%%%  FIN DE CARRERA  %%%%%%%%%%%");
		System.out.println();

		System.out.println("¡¡¡ Primera posición para el Camello " + listaPodio[0] + "!!!");
		System.out.println("¡¡¡ Segunda posición para el Camello " + listaPodio[1] + "!!!");
		if (listaPodio[2] != 0) {
			System.out.println("¡¡¡ Tercera posición para el Camello " + listaPodio[2] + "!!!");
		}

		System.out.println();
		System.out.println("%%%%%%%%%%    PODIO FINAL   %%%%%%%%%%%");
	}

	public int lanzarBola() {
		int resultado = 0;
		Random aleatorio = new Random();
		long sleep = 1 + aleatorio.nextInt(1000) * (aleatorio.nextInt(10) + 1);
		int lanzamiento = 1 + aleatorio.nextInt(100);
		if (lanzamiento <= 30) {
			resultado = 0;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if (lanzamiento <= 70) {
			resultado = 1;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if (lanzamiento <= 90) {
			resultado = 2;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} else {
			resultado = 3;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}

		return resultado;
	}

	public int getJinete() {
		return nombre;
	}

	public void setJinete(int jinete) {
		nombre = jinete;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getMetros() {
		return metros;
	}

	public void setMetros(int metros) {
		this.metros = metros;
	}

}
