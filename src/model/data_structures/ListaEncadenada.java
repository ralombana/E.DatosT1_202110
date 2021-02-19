package model.data_structures;

public class ListaEncadenada<T extends Comparable<T>>implements ILista<T> {

	
	private Nodo inicio;
	
	private int elementos;
	
	public ListaEncadenada() 
	{
		inicio = null;
		elementos = 0;
	}
	
	@Override
	public int darTamano() 
	{
		return elementos;
	}

	@Override
	public T darElemento(int i) {
		Nodo ans = inicio;
		for(int j = 0; j <= i; j ++)
		{
			if(j == i)
			{
				return (T) ans.getValor();
			}
			else
			{
				ans = ans.getSiguiente();
			}
		}
		return null;
	}

	@Override
	public void agregar(T dato) 
	{		
		Nodo nuevo = new Nodo(inicio, dato);
		inicio = nuevo;
		elementos++;
	}

	@Override
	public T buscar(T dato) 
	{	
		Nodo ans = inicio;
		for(int i = 0; i < elementos; i++)
		{
			if(dato.compareTo((T) ans.getValor()) == 0)
			{
				return (T) ans.getValor();
			}
			else
			{
				ans = ans.getSiguiente();
			}
		}
		return null;
	}

	@Override
	public T eliminar(T dato) 
	{
		if(inicio.getValor().compareTo(dato) == 0)
		{
			elementos--;
			Nodo temp = inicio;
			inicio = temp.getSiguiente();
			temp.setSiguiente(null);
			return (T) temp.getValor();
		}
		Nodo ans = inicio;
		Nodo ant = null;
		for(int i = 0; i < elementos; i++)
		{
			if(dato.compareTo((T) ans.getValor()) == 0)
			{
				elementos--;
				if(ans.getSiguiente() != null)
				{
					Nodo temp = ans;
					ant.setSiguiente(temp.getSiguiente());
					temp.setSiguiente(null);
					
					return (T) temp.getValor(); 
				}
				else
				{
					ant.setSiguiente(null);
					return (T) ans.getValor();
				}
			}
			else
			{
				ant = ans;
				ans = ans.getSiguiente();
			}
		}
		return null;
	}

}
