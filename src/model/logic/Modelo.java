package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.graalvm.compiler.graph.NodeList.SubList;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.ILista;
import model.data_structures.ListaEncadenada;
import model.data_structures.YoutubeVideo;
import model.utils.Ordenamiento;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArregloDinamico<YoutubeVideo> datos;
	
	private ListaEncadenada<YoutubeVideo> lista;
	private ILista subList;
	
	
	public void cargarArchivosLista()
	{
		lista = new ListaEncadenada<YoutubeVideo>();
		Reader in;
		try 
		{
			in = new FileReader("./data/videos-all.csv");
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			boolean first = true;
			for (CSVRecord record : records) 
			{
				if(first == false)
				{
					String id = record.get(0);
				    String date = record.get(1);
				    String title = record.get(2);
				    String canal = record.get(3);
				    String vistas = record.get(7);
				    String likes = record.get(8);
				    String dislikes = record.get(9);
				    
				    int view = Integer.parseInt(vistas);
				    int like = Integer.parseInt(likes);
				    int noLike = Integer.parseInt(dislikes);
				    
				    Date d = new SimpleDateFormat("YY.dd.MM").parse(date);
				    YoutubeVideo y = new YoutubeVideo(id, d, title, canal, view, like, noLike);
				    lista.addFirst(y);
				}
				else
					first = false;
			}
		} 
		catch (IOException | ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarArchivosArreglo()
	{
		datos = new ArregloDinamico<YoutubeVideo>(100);
		Reader in;
		try 
		{
			in = new FileReader("./data/videos-all.csv");
			Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
			boolean first = true;
			for (CSVRecord record : records) 
			{
				if(first == false)
				{
					String id = record.get(0);
				    String date = record.get(1);
				    String title = record.get(2);
				    String canal = record.get(3);
				    String vistas = record.get(7);
				    String likes = record.get(8);
				    String dislikes = record.get(9);
				    
				    int view = Integer.parseInt(vistas);
				    int like = Integer.parseInt(likes);
				    int noLike = Integer.parseInt(dislikes);
				    
				    Date d = new SimpleDateFormat("YY.dd.MM").parse(date);
				    YoutubeVideo y = new YoutubeVideo(id, d, title, canal, view, like, noLike);
				    datos.addLast(y);
				}
				else
					first = false;
			}
		} 
		catch (IOException | ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArregloDinamico<YoutubeVideo> darArreglo()
	{
		return datos;
	}
	
	public ListaEncadenada<YoutubeVideo> darLista()
	{
		return lista;
	}
	
	public void ordenarSubList(int tipoAlgoritmo) 
	{
		int option = tipoAlgoritmo;
		Ordenamiento<YoutubeVideo> ordenador = new Ordenamiento<YoutubeVideo>();
		Comparator<YoutubeVideo> criterio = new YoutubeVideo.ComparadorXLikes();
		
		switch (option) 
		{
		case 1:
			ordenador.ordenarInsercion(subList, criterio, true);
			System.out.println("Ordenado por inserción");
			break;
		case 2:
			ordenador.ordenarMergeSort(subList, criterio, true);
			System.out.println("Ordenado por Merge");
			break;
		
		case 3:			
			ordenador.ordenarShell(subList, criterio, true);
			System.out.println("Ordenado por Shell");
			break;
		case 4:
			ordenador.ordenarQuick(subList, criterio, true);
			System.out.println("Ordenado por Quick");
			break;
		default:
			System.out.println("--- Opición invalida ---");
			break;
		}
		
	}
	

}
