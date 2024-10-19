package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.beans.Autor;
import com.model.AutoresModel;

/**
 * Servlet implementation class AutorControllers
 */
public class AutorControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AutoresModel modelo = new AutoresModel();
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
		if(request.getParameter("op")==null) {
			listar(request,response);
			return;
		}
		String operacion = request.getParameter("op");
		switch (operacion) {
		case "listar":
			listar(request, response);
			break;
		case "nuevo":
			//nuevo(request,response);
		}
		
			
		}
	}
    public AutorControllers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listaAutores", modelo.ListarAutores());
			
			Iterator<Autor> it = modelo.ListarAutores().iterator();
			while(it.hasNext()) {
				Autor a = it.next();
				System.out.println(a.getId()+" "+a.getNombre()+" "+a.getPais());
			}
			request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
		}catch (ServletException | IOException ex) {
			Logger.getLogger(AutoresModel.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}

}
