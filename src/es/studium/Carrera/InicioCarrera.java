package es.studium.Carrera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InicioCarrera
{

	public static void main(String[] args) throws InterruptedException
	{
		int distancia=0;
		int camellos=0;
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		
		try
		{
			CarreraJinetes carrera = new CarreraJinetes();
			
			
			System.out.println("Escribe el número de jinetes de la carrera");
			camellos = Integer.parseInt(teclado.readLine());
			System.out.println("Escribe el tamaño de la carrera");
			distancia = Integer.parseInt(teclado.readLine());
			carrera.setDistanciaCarrera(distancia);
			carrera.setNumJinetes(camellos);
			System.out.println(camellos);
			for (int i=0; i<carrera.getNumJinetes();i++) {
				
				Jinete j = new Jinete("Camello "+ (i+1));
				
				j.start();
//				if (j.avanceTrayecto(j) < CarreraJinetes.distanciaCarrera){
//					
//					System.out.println(j.getName()+ "fff");
//					
//				}
					
							}
						
			teclado.close();
		}catch(NumberFormatException n) {
			
			System.err.println("Debes seleccionar almenos dos corredores ");
			
			}
		catch (IOException e) {
		
			e.getStackTrace();
			
		}
	}
}
