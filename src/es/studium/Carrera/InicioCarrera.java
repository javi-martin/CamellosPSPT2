package es.studium.Carrera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InicioCarrera {
	public static CarreraJinetes carrera;

	public static void main(String[] args) throws InterruptedException {
		int distancia = 0;
		int camellos = 0;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		try {

			carrera = new CarreraJinetes();

			System.out.println("Escribe el n�mero de jinetes de la carrera");
			camellos = Integer.parseInt(teclado.readLine());
			System.out.println("Escribe el tama�o de la carrera");
			distancia = Integer.parseInt(teclado.readLine());
			carrera.setDistanciaCarrera(distancia);
			carrera.setNumJinetes(camellos);
			System.out.println("N�mero de participantes " + camellos);
			System.out.println();
			for (int i = 0; i < CarreraJinetes.getNumJinetes(); i++) {

				Jinete hiloJinete = new Jinete((i + 1));

				hiloJinete.start();

			}

			teclado.close();
		} catch (NumberFormatException n) {

			System.err.println("Debes seleccionar almenos dos corredores ");

		} catch (IOException e) {

			e.getStackTrace();

		}
	}
}
