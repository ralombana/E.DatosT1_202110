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
	public int size() 
	{
		return elementos;
	}

	@Override
	public T getElement(int i) {
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
	public void addFirst(T dato) 
	{
		Nodo nuevo = new Nodo(inicio, dato, null);
		if(inicio != null)
		{
			inicio.setPasado(nuevo);
		}
		inicio = nuevo;
		elementos++;
		
	}

	@Override
	public void addLast(T dato) 
	{
		Nodo ans = inicio;
		for(int i = 0; i < elementos; i++)
		{
			ans = ans.getSiguiente();
		}
		Nodo n = new Nodo(null, dato, ans);
		ans.setSiguiente(n);
	}

	@Override
	public void insertElement(T element, int pos) 
	{
		
	}

	@Override
	public T removeFirst() {
		elementos--;
		Nodo temp = inicio;
		inicio = temp.getSiguiente();
		temp.setSiguiente(null);
		return (T) temp.getValor();
	}

	@Override
	public T removeLast() 
	{
		Nodo ans = inicio;
		for(int i = 0; i < elementos; i++)
		{
			ans = ans.getSiguiente();
		}
		ans.getPasado().setSiguiente(null);
		ans.setPasado(null);
		return (T) ans.getValor();
	}

	@Override
	public T deleteElement(int pos) 
	{
		if(pos == 0)
		{
			return removeFirst();
		}
		Nodo ans = inicio;
		for(int i = 0; i < elementos; i++)
		{
			if(i == pos)
			{
				elementos--;
				if(ans.getSiguiente() != null)
				{
					Nodo temp = ans;
					temp.getPasado().setSiguiente(temp.getSiguiente());
					temp.setSiguiente(null);
					temp.getSiguiente().setPasado(temp.getPasado());
					temp.setPasado(null);			
					return (T) temp.getValor(); 
				}
				else
				{
					return removeLast();
				}
			}
			else
			{
				ans = ans.getSiguiente();
			}
		}
		return null;
	}

	@Override
	public T firstElement() {
		return (T) inicio.getValor();
	}

	@Override
	public T lastElement() {
		// TODO Auto-generated method stub
		Nodo ans = inicio;
		for(int i = 0; i < elementos-1; i++)
		{
			ans = ans.getSiguiente();
		}
		return (T) ans.getValor();
	}

	@Override
	public boolean isEmpty() {
		if(elementos == 0)
			return true;
		else
			return false;
	}

	@Override
	public int isPresent(T element) 
	{
		Nodo ans = inicio;
		for(int i = 0; i < elementos; i++)
		{
			if(element.compareTo((T) ans.getValor()) == 0)
			{
				return i;
			}
			else
			{
				ans = ans.getSiguiente();
			}
		}
		return -1;
	}

	@Override
	public void exchange(int pos1, int pos2) 
	{
		if(pos1 >= elementos || pos2 >= elementos || pos1 == pos2)
		{
			return;
		}
		
		Nodo n1 = null;
		Nodo n2 = null;
		Nodo ans = inicio;
		for(int i = 0; i < elementos; i++)
		{
			if(i == pos1)
			{
				n1 = ans;
			}
			else if(i == pos2)
			{
				n2 = ans;
			}
			if(n1 != null && n2 != null)
				break;
			ans = ans.getSiguiente();
		}
		
		Nodo temp = n2;
		n2.setSiguiente(n1.getSiguiente());
		n2.setPasado(n1.getPasado());
		n1.setSiguiente(temp.getSiguiente());
		n1.setPasado(temp.getPasado());
	}

	@Override
	public void changeInfo(int pos, T elem) 
	{
		Nodo ans = inicio;
		for(int i = 0; i < elementos; i++)
		{
			if(i == pos)
			{
				ans.setValor(elem);
			}
			ans = ans.getSiguiente();
		}
	}

}
