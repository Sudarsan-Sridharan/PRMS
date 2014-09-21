package sg.edu.nus.iss.phoenix.core.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PhoenixFrontController
 */
public class PhoenixFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private static final String ROUTEFILE = "route.properties";
        
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhoenixFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * Process requests from clients.
	 */
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String action = FCUtilities.stripPath(pathInfo);
		System.out.println("PATH" + pathInfo);
		System.out.println("ACTION" + action);
		String result = chooseUseCase(action);
                System.out.println(result);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(result);
		rd.forward(request, response);
	}

	private String chooseUseCase(String action)  {
//            String url="";
		switch (action) {
		case "login":
			return "/LoginController/login";
		case "searchrp":
			return "/ProcessController/search";
                case "setuprp":
			return "/ProcessController/process";
		case "crudrp":
			return "/CRUDRpController";
		case "loadrp":
			return "/ProcessController/load";	
		case "deleterp":
			return "/ProcessController/delete";
                case "setupschedule":
			return "/ScheduleController/process";
		case "crudschedule":
			return "/ScheduleController";
		case "loadschedule":
			return "/ScheduleController/load";
                case "deleteschedule":
			return "/ScheduleController/delete";
                case "selectpresenter":
			return "/PresenterProducerController/selectpresenter";
		case "selectproducer":
			return "/PresenterProducerController/selectproducer";
                case "logout":
			return "/ScheduleController/logout";
		default:
			return "/welcome.jsp";
		}
            //InputStream routing = this.getClass().getClassLoader().getResourceAsStream(ROUTEFILE);;
            
//            Properties props = new Properties();
//            try{
//            props.load(PhoenixFrontController.class.getClassLoader().getResourceAsStream(ROUTEFILE));
//        
//            Set keys = props.keySet();
//            Iterator it = keys.iterator();
//            while(it.hasNext())
//            {
//                String key = (String)it.next();
//                url = (String)props.get(key);
//            }
//            }catch(IOException e){
//                e.printStackTrace();
//            }
//            return url;
        }
}
