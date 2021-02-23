package view;

import model.data_structures.ArregloDinamico;
import model.data_structures.ListaEncadenada;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar a un arreglo dinámico");
			System.out.println("2. Cargar a una lista encadenada");
			System.out.println("7. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
}
