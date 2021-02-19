package model.data_structures;

public class Nodo<T extends Comparable<T>>
{
	private Nodo siguiente;
	
	private Nodo pasado;
	
	private T valor;
	
	public Nodo(Nodo pNodo, T pValor, Nodo pNodo1) 
	{
		// TODO Auto-generated constructor stub
		siguiente = pNodo;
		pasado = pNodo1;
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

	public Nodo getPasado() {
		return pasado;
	}

	public void setPasado(Nodo pasado) {
		this.pasado = pasado;
	}
}
