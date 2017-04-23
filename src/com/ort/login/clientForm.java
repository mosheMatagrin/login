package com.ort.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.scene.layout.region.Margins.Converter;


@WebServlet("/clientForm")
public class clientForm extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HashMap<String, String> error = new HashMap<String, String>();
		Client client = new Client();
		
		
		client.setNom(req.getParameter("nom"));
		client.setPrenom(req.getParameter("prenom"));
		client.setBirthDate(req.getParameter("birthDate"));
		client.setMail(req.getParameter("mail"));
		client.setMdp(req.getParameter("mdp"));
		String repete_mdp = req.getParameter("repete_mdp");
		
		if(!checkNotNull(client.getMail()))
			error.put("mail", "ce champ est obligatoire");
		
		if(!checkNotNull(client.getMdp()))
			error.put("mdp", "ce champ est obligatoire");
		
		if(!checkNotNull(repete_mdp))
			error.put("repete_mdp", "ce champ est obligatoire");
		
		if(!client.getMdp().contentEquals(repete_mdp))
			error.put("repete_mdp", "ce champ doit être identique au mdp");
		
		if(!error.isEmpty())
		{
			req.setAttribute("client", client);
			req.setAttribute("error", error);
			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}
		else
		{
			try {
			    Class.forName( "com.mysql.jdbc.Driver" );
			} catch ( ClassNotFoundException e ) {
			   
			}

			// connection
			String url = "jdbc:mysql://localhost:3306/myjeedb";
			String utilisateur = "appjee";
			String motDePasse = "appjee";
			Connection connection = null;
			try {
			    connection = DriverManager.getConnection(url, utilisateur, motDePasse);

			    Statement statement = connection.createStatement();
			    int status = statement.executeUpdate("INSERT INTO USER(FIRSTNAME,LASTNAME,BIRTHDAY,"
			    		+ "EMAIL,PASSWORD) VALUES('"+client.getNom()+"','"+client.getPrenom()+"',"
			    				+ "'"+client.getBirthDate()+"','"+client.getMail()+"','"+client.getMdp()+"'");
			    resp.getWriter().append(String.valueOf(status));
			}
			catch (SQLException e) {
			    // catch SQL exception
			}
			finally {
			    if (connection != null) {
			        try {
			            // close connection
			            connection .close();
			        } catch (SQLException ignore) {
			            // log exception
			        }
			    }
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
	private boolean checkNotNull(String arg0)
	{
		return (arg0 != "") && (arg0 != null);
	}

}
