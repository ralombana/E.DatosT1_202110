package model.utils;

import java.util.Comparator;

import model.data_structures.ILista;
import model.data_structures.YoutubeVideo;

public class Ordenamiento <T extends Comparable <T>> {

	
	public Ordenamiento() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	
	
	public void ordenarInsercion(ILista<T> lista, Comparator <T> criterio, boolean ascendente ) {
		for (int i = 1; i < lista.size(); i ++)
		{
			int posMayor = i;
			for (int j = i+1; j <= lista.size(); j++)
			{
				
		T elemento1 = lista.getElement(j);
		T elemento2 = lista.getElement(posMayor);
		
		int Comparacion = (ascendente?1:-1) * criterio.compare(lista.getElement(j), lista.getElement(posMayor));
		
	    if (Comparacion < 0)
				{
					posMayor = j;
				}	
			}		
			lista.exchange(posMayor, i);
		}
		
		
		
		
	

			
		}



	public void ordenarMergeSort(ILista<T> lista, Comparator <T> criterio, boolean ascendente ) {
		// TODO Auto-generated method stub
		
	}



	public void ordenarShell(ILista<T> lista, Comparator <T> criterio, boolean ascendente ) {
		// TODO Auto-generated method stub
		
	}



	public void ordenarQuick(ILista<T> lista, Comparator <T> criterio, boolean ascendente ) {
		// TODO Auto-generated method stub
		
	}
		
	}
	


