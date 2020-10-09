/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestorDB;
import modelo.Servicio;
import modelo.TipoServicio;

/**
 *
 * @author mnava
 */
@WebServlet(name = "AltaServicioServlet", urlPatterns = {"/AltaServicioServlet"})
public class AltaServicioServlet extends HttpServlet {

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		GestorDB g = new GestorDB();	

		ArrayList<TipoServicio> tiposServicios = g.obtenerTiposServicio();

		request.setAttribute("lista", tiposServicios);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/altaServicio.jsp");
		rd.forward(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		GestorDB g = new GestorDB();

		String tipoId = request.getParameter("cboTipo");
		String descripcion = request.getParameter("txtDescripcion");
		Double costo = Double.parseDouble(request.getParameter("txtCosto"));
		
		TipoServicio tipo = g.obtenerTipoServicio(Integer.parseInt(tipoId));
		g.insertarServicio(new Servicio(tipo, descripcion, costo));


	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
