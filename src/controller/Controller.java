package controller;

import java.util.Scanner;

import model.data_structures.ArregloDinamico;
import model.data_structures.ListaEncadenada;
import model.data_structures.YoutubeVideo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			long startTime;
			long endTime;
			long timeElapsed;
			switch(option){
				case 1:
					view.printMessage("--------- \nCargando datos...");
					startTime = System.nanoTime();
				    modelo.cargarArchivosArreglo();
			        endTime = System.nanoTime();			 
			        timeElapsed = endTime - startTime;
			        ArregloDinamico<YoutubeVideo> arr = modelo.darArreglo();
			        view.printMessage("Video inicial: " + arr.firstElement().toString());
			        view.printMessage("Video final: " + arr.lastElement().toString());
			        view.printMessage("Total de videos cargados: " + arr.size());
			        view.printMessage("Tiempo de la operación: " + (timeElapsed/1000000) + " ms");
					break;

				case 2:
					view.printMessage("--------- \nCargando datos...");
					startTime = System.nanoTime();
					modelo.cargarArchivosLista();					
					endTime = System.nanoTime();					 
			        timeElapsed = endTime - startTime;
			        ListaEncadenada<YoutubeVideo> lista = modelo.darLista();
			        view.printMessage("Video inicial: " + lista.lastElement().toString());
			        view.printMessage("Video final: " + lista.firstElement().toString());			        
			        view.printMessage("Total de videos cargados: " + lista.size());
			        view.printMessage("Tiempo de la operación: " + (timeElapsed/1000000) + " ms");
			        
					break;
				case 7: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
