package br.com.android.defesa.model;

public class Moradia {
	
	private int id;
	private Double x;
	private Double y;
	
	public Moradia(){
		
	}
	
	
	public Moradia(int id,Double x, Double y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	
	
	

}
