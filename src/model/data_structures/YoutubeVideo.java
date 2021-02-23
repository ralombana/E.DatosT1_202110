package model.data_structures;

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

}
