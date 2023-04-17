package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Bean;

/**
 * Servlet implementation class Bus
 */
@WebServlet("/Bus")
public class Bus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = null;
		String action = request.getParameter("action");

		if (action.equals("insert")) {
			forwardPath = "WEB-INF/jsp/Insert.jsp";
			
			
			
		} else if (action.equals("update")) {
			forwardPath = "WEB-INF/jsp/Update.jsp";
			EmployeeDAO empDAO = new EmployeeDAO();
			int resarve = Integer.parseInt(request.getParameter("resarve"));
			Bean bean = new Bean();
			bean = empDAO.select(resarve);
			request.setAttribute("bean", bean);
			
			
		} else if (action.equals("list")) {
			forwardPath = "WEB-INF/jsp/Select.jsp";
		} else {
			forwardPath = "WEB-INF/jsp/Delete.jsp";
			EmployeeDAO empDAO = new EmployeeDAO();
			int resarve = Integer.parseInt(request.getParameter("resarve"));
			Bean bean = new Bean();
			bean = empDAO.select(resarve);
			request.setAttribute("bean", bean);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");

		int Bresarve;
		String Bname;
		String Btel;
		int Bdating;
		String Bdrive;
		String Broute;
		String Bseanum;

		Bresarve = Integer.parseInt(request.getParameter("resarve"));
		Bname = request.getParameter("name");
		Btel = request.getParameter("tel");
		Bdating = Integer.parseInt(request.getParameter("dating"));
		Bdrive = request.getParameter("drive");
		Broute = request.getParameter("route");
		Bseanum = request.getParameter("seaname");

		if (name.equals("update_form")) {
			Bean bean = new Bean(Bresarve, Bname, Btel, Bdating, Bdrive, Broute, Bseanum);
			EmployeeDAO Dao = new EmployeeDAO();
			Dao.update(bean);
		} else if (name.equals("mail_form")) {
			Bean bean = new Bean(Bresarve, Bname, Btel, Bdating, Bdrive, Broute, Bseanum);
			EmployeeDAO Dao = new EmployeeDAO();
			Dao.insert(bean);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Select.jsp");
		dispatcher.forward(request, response);
	}

}
