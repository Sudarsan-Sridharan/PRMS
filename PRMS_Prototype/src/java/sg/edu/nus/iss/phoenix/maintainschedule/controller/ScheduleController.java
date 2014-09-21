/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nus.iss.phoenix.maintainschedule.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nus.iss.phoenix.core.controller.FCUtilities;
import sg.edu.nus.iss.phoenix.maintainschedule.delegate.ScheduleDelegate;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.AnnualSchedule;
import sg.edu.nus.iss.phoenix.maintainschedule.entity.ProgramSlot;

/**
 *
 * @author sudarsan
 */
@WebServlet("/ScheduleController/*")
public class ScheduleController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public ScheduleController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processrequest(req, resp); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processrequest(req, resp); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(ScheduleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processrequest(HttpServletRequest request,
            HttpServletResponse response)throws ServletException,IOException, Exception
    {
        String selection = FCUtilities.stripPath(request.getPathInfo())
				.toLowerCase();
        try{
        switch(selection){
            
           
		case "load":
			ScheduleDelegate schdel = new ScheduleDelegate();
			ArrayList<ProgramSlot> data2 = schdel.findAllPS();
                        ArrayList<AnnualSchedule> annualSch = schdel.findAllAnnum();
			request.setAttribute("sch", data2);
                        request.setAttribute("yearList", annualSch);
			RequestDispatcher rd2 = request
					.getRequestDispatcher("/pages/crudschedule.jsp");
			rd2.forward(request, response);
			break;
                case "process":
                        ScheduleDelegate schdel1 = new ScheduleDelegate();
			ProgramSlot ps = new ProgramSlot();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date = formatter.parse(request.getParameter("dateOfProgram"));
			ps.setDateOfProgram(new java.sql.Date(date.getTime()));
			ps.setDuration(Time.valueOf(request.getParameter("duration")));
                        ps.setPresenter(request.getParameter("presenter"));
                        ps.setProducer(request.getParameter("producer"));
                        ps.setProgramName(request.getParameter("programName"));
			ps.setStartTime(Time.valueOf(request.getParameter("startTime")));
			String mod = (String) request.getParameter("mod");
			Logger.getLogger(getClass().getName()).log(Level.INFO,
					"Insert Flag: " + mod);
			if (mod.equalsIgnoreCase("false")) {
				schdel1.insertOrClonePS(ps);
			} else {
				schdel1.updatePS(ps);
			}
			ArrayList<ProgramSlot> data = schdel1.findAllPS();
			request.setAttribute("sch", data);
			RequestDispatcher rd = request
					.getRequestDispatcher("/pages/crudschedule.jsp");
			rd.forward(request, response);
			break;
                case "delete":
                        ScheduleDelegate schdel2 = new ScheduleDelegate();
			ProgramSlot ps2 = new ProgramSlot();
                        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date date3 = formatter1.parse(request.getParameter("dateOfProgram"));
			ps2.setDateOfProgram(new java.sql.Date(date3.getTime()));
			ps2.setDuration(Time.valueOf(request.getParameter("duration")));
                        ps2.setStartTime(Time.valueOf(request.getParameter("startTime")));
                        schdel2.deletePS(ps2);
                        ArrayList<ProgramSlot> data5 = schdel2.findAllPS();
			request.setAttribute("sch", data5);
			RequestDispatcher rd3 = request
					.getRequestDispatcher("/pages/crudschedule.jsp");
			rd3.forward(request, response);
                default:
                    ScheduleDelegate schdel4 = new ScheduleDelegate();
			ArrayList<ProgramSlot> data4 = schdel4.findAllPS();
			request.setAttribute("sch", data4);
			RequestDispatcher rd4 = request
					.getRequestDispatcher("/pages/crudschedule.jsp");
			rd4.forward(request, response);
			break;
        }
        }catch(ParseException pe)
        {
            pe.printStackTrace();
        }
    }
}
