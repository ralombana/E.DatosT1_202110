package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 * @param <T>
 * @param <T>
 *
 */
public class ArregloDinamico<T> implements IArregloDinamico<T> {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Object[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Object[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) 
	{
		// TODO implementar
		return elementos[i];
	}

	public T buscar(T dato) 
	{
		// TODO implementar
		
		T solucion = null;
		boolean encontro = false;

		for (int i = 0; i < tamanoAct && !encontro ; i++) {

			if (elementos[i].equals(dato)) {
				encontro = true;
				solucion = elementos[i];

			}
		}

		return solucion;
	}

	public T eliminar(T dato) 
	{
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		boolean encontro = false;
		T retorno = null;

		for (int i = 0; i <tamanoAct && !encontro; i++) {
			if ( elementos[i].equals((dato))) {
				encontro = true;
				retorno = elementos[i];
				elementos[i] = null;
				tamanoAct--;
			}
		}
		
		int j = 0;

		for(int i = 0; i <elementos.length; i++)
		{
			if(elementos[i] == null)
			{
				j++;	
				if(j >= elementos.length)
				{
					tamanoAct = i+1;
					elementos[elementos.length - 1] = null;
					break;
				}
			}			
			elementos[i] = elementos[j];
			j++;
			if(j >= elementos.length)
			{
				tamanoAct = i+1;
				elementos[elementos.length - 1] = null;
				break;
			}
		}

		return retorno;
	}

	@Override
	public void invertir() 
	{
		// TODO Auto-generated method stub
		int end = tamanoAct - 1;
		T[] arreglo = (T[]) new Object[tamanoAct];
		for(int i = 0; i < elementos.length; i++)
		{
			if(elementos[i] != null)
			{
				arreglo[end] = elementos[i];
				end--;
			}
		}		
		elementos = arreglo;
		tamanoMax = elementos.length;
	}

}
