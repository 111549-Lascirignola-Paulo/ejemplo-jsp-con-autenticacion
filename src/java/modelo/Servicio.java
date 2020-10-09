/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mnava
 */
public class Servicio {
	private int id;
	private TipoServicio tipo;
	private String descripcion;
	private double costo;	

	public Servicio(int id, TipoServicio tipo, String descripcion, double costo) {
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.costo = costo;
	}

	public Servicio(TipoServicio tipo, String descripcion, double costo) {
		this(-1, tipo, descripcion, costo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoServicio getTipo() {
		return tipo;
	}

	public void setTipo(TipoServicio tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Servicio{" + "id=" + id + ", tipo=" + tipo + ", descripcion=" + descripcion + ", costo=" + costo + '}';
	}
}
