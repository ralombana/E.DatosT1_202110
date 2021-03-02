package model.data_structures;

import java.util.Comparator;
import java.util.Date;

public class YoutubeVideo implements Comparable<YoutubeVideo>
{

	private String id;
	private Date fecha;
	private String title;
	private String canal;
	private int vistas;
	private int likes;
	private int dislikes;
	
	
	public Date getTrending_date() 
	{
		return fecha;
	}

	public YoutubeVideo(String pId, Date pDate, String pTitle, String pCanal, int pVistas, int pLikes, int pDislikes) 
	{
		id = pId;
		fecha = pDate;
		title = pTitle;
		canal = pCanal;
		vistas = pVistas;
		likes = pLikes;
		dislikes = pDislikes;
	}

	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return "Id: " + id + " || fecha: " + fecha.toString() + " || titulo: " + title + " || canal: "
				+ canal + " || vistas: " + vistas + " || likes: " + likes + " || dislikes : " + dislikes;
	}

	@Override
	public int compareTo(YoutubeVideo o) 
	{
		return fecha.compareTo(o.getTrending_date());
	}

	public String getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getTitle() {
		return title;
	}

	public String getCanal() {
		return canal;
	}

	public int getVistas() {
		return vistas;
	}

	public int getLikes() {
		return likes;
	}

	public int getDislikes() {
		return dislikes;
	}
	
	
	/**
	 * Comparacion natural de acuerdo a algun atributo con identificacion unica
	 * @param otro
	 * @return valor 0 si this y otro son iguales
	 */
	public int compareTo1(YoutubeVideo otro) {
		int valor = 0;
		if (id.compareTo(otro.getId())==0) {
			valor = 0;
		}else if (id.compareTo(otro.getId())== -1) {
			valor = -1;
		}else {
			valor = 1;
		}
		
		return valor;
	
	}
	
	
	
	public static class ComparadorXLikes implements Comparator <YoutubeVideo>{
		
		
		
		
		
		 /** Comparador alterno de acuerdo al número de likes
         * @return valor 0 si video1 y video2 tiene los mismos likes.
           valor negativo si video1 tiene menos likes que video2.
           valor positivo si video1 tiene más likes que video2. */

		 
		public int compare (YoutubeVideo video1, YoutubeVideo video2) {
		int compara = 0;
		
		if (video1.getLikes() == video2.getLikes()) {
			compara = 0;
		}else if (video1.getLikes() > video2.getLikes()) {
			compara = 1;
		
		}else {
			compara = 1;
		}
		
			return compara;
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}



