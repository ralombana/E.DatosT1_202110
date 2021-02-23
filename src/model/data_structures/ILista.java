package model.data_structures;

public interface ILista <T extends Comparable<T>>
{

	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return
	 */
	int size( );
	
	T getElement( int i );

	void addFirst(T dato );
	
	void addLast(T dato );
	
	void insertElement(T element, int pos);

	T removeFirst( );
	
	T removeLast( );
	
	T deleteElement( int pos);
	
	T firstElement( );
	
	T lastElement();
	
	boolean isEmpty( );
	
	int isPresent (T element);
	
	void exchange (int pos1, int pos2);
	
	void changeInfo (int pos, T elem);
}
