/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author mnava
 */
public class ServicioDTO {
	public Servicio servicio;
	public ArrayList<TipoServicio> listaTipoServicios;

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public ArrayList<TipoServicio> getListaTipoServicios() {
		return listaTipoServicios;
	}

	public void setListaTipoServicios(ArrayList<TipoServicio> listaTipoServicios) {
		this.listaTipoServicios = listaTipoServicios;
	}
}
