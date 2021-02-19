package model.data_structures;

public class Nodo<T extends Comparable<T>>
{
	private Nodo siguiente;
	
	private T valor;
	
	public Nodo(Nodo pNodo, T pValor) 
	{
		// TODO Auto-generated constructor stub
		siguiente = pNodo;
		valor = pValor;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
	
}
