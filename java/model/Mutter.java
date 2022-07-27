package model;
import java.io.Serializable;

	

public class Mutter implements Serializable {
	
	private int id;
	private String username;
	private String text;
	private static int mojinum = 300;
	
	public Mutter() {}
	public Mutter(String username, String text) {
		this.username = username;
		this.text = text;
	}
	public Mutter(int id,String username, String text) {
		this.id = id;
		this.username = username;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	public int getMojinum() {
		return mojinum;
	}
	public void setMojinum(int mojinum) {
		Mutter.mojinum = mojinum;
	}
	public String getUsername() {
		return username;
	}
	public String getText() {
		return text;
	}
	
	
	
}
