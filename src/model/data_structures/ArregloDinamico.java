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
public class ArregloDinamico<T extends Comparable<T>> implements ILista<T> {
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
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int size() {
		return tamanoAct;
	}

	public T getElement(int i) 
	{
		// TODO implementar
		return elementos[i];
	}

	@Override
	public void addFirst(T dato) 
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct-1; i++)
			{
				elementos[i] = copia[i];
				if(i >= 0)
				{
					elementos[i+1] = copia[i];
				}
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[0] = dato;
		tamanoAct++;
	}

	@Override
	public void addLast(T dato) 
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct-1; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	@Override
	public void insertElement(T element, int pos) 
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct-1; i++)
			{
				elementos[i] = copia[i];
				if(i >= pos)
				{
					elementos[i+1] = copia[i];
				}
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[pos] = element;
		tamanoAct++;
	}

	@Override
	public T removeFirst() 
	{
		return deleteElement(0);
	}

	@Override
	public T removeLast() {
		T rta = elementos[tamanoAct-1];
		elementos[tamanoAct-1] = null;
		tamanoAct--;
		return rta;
	}

	@Override
	public T deleteElement(int pos) 
	{
		if(pos >= tamanoAct)
		{
			return null;
		}
		T rta = elementos[pos];
		for(int i = pos; i < tamanoAct-1; i++)
		{
			elementos[i] = elementos[i+1];
		}
		tamanoAct--;
		return rta;
	}

	@Override
	public T firstElement() {
		return elementos[0];
	}

	@Override
	public T lastElement() 
	{	
		return elementos[tamanoAct-1];
	}

	@Override
	public boolean isEmpty() 
	{
		if(tamanoAct == 0)
			return true;
		else
			return false;
	}

	@Override
	public int isPresent(T element) 
	{
		for(int i = 0; i < tamanoAct; i++)
		{
			if(element.compareTo(elementos[i]) == 0)
				return i;
		}
		return -1;
	}

	@Override
	public void exchange(int pos1, int pos2) 
	{
		T temp = elementos[pos2];
		elementos[pos2] = elementos[pos1];
		elementos[pos1] = temp;
	}

	@Override
	public void changeInfo(int pos, T elem) 
	{
		if(pos >= tamanoAct)
			return;
		elementos[pos] = elem;
	}

}
