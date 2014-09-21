/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.reviewselpresenterproducer.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.authenticate.entity.User;
import sg.edu.nus.iss.phoenix.core.controller.FCUtilities;
import sg.edu.nus.iss.phoenix.reviewselpresenterproducer.delegate.ReviewSelectPresenterProducerDelegate;

/**
 *
 * @author sudarsan
 */
@WebServlet("/PresenterProducerController/*")
public class ReviewSelectPresenterProducerController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{ 
        if (FCUtilities.stripPath(req.getPathInfo()).equalsIgnoreCase("selectpresenter") ) {
			ReviewSelectPresenterProducerDelegate rsppd = new ReviewSelectPresenterProducerDelegate();
			List<User> users = rsppd.getAllPresenters();
			RequestDispatcher rd;
			req.setAttribute("users", users);
                        req.setAttribute("role", "presenter");
			rd = getServletContext().getRequestDispatcher("/pages/selectpresenterproducer.jsp");;
			 
				
		    rd.forward(req, resp);
		} else {
			 ReviewSelectPresenterProducerDelegate rsppd = new ReviewSelectPresenterProducerDelegate();
			List<User> users = rsppd.getAllProducers();
			RequestDispatcher rd;
			req.setAttribute("users", users);
                        req.setAttribute("role", "producer");
			rd = getServletContext().getRequestDispatcher("/pages/selectpresenterproducer.jsp");;
			 
				
		    rd.forward(req, resp);
		}//To change body of generated methods, choose Tools | Templates.
    }catch(Exception e)
    {
        e.printStackTrace();
    }
    
    }
    
}
