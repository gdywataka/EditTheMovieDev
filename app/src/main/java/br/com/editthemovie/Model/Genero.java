package br.com.editthemovie.Model;
import java.util.List;


public class Genero {
	
	private int id;
	private String nome;
	private List<Video>videos;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	
	

}
