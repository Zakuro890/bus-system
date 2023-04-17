package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		
	
	public DeleteServlet() {
		
	}
		//int resarve=1;
		
		//Bean bean=new Bean(resarve);
		//request.setAttribute("bean",bean);
		
		
		
		//RequestDispatcher dispatcher=request.getRequestDispatcher("Delete.jsp");
		//dispatcher.forward(request,response);
		
		//EmployeeDAO empDao=new EmployeeDAO();
		//empDao.delete(bean);
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int resarve=1;
		//String Name="a";
		//String Tel="1";
		//int Dating=1;
		//String Drive="1";
		//String Route="1";
		//String Seanum="1";
		
		//Bean bean=new Bean(resarve);
		//request.setAttribute("bean",bean);
		//request.getRequestDispatcher("/WEB-INF/jsp/Delete.jsp").forward(request, response);
		
	//}
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		       Bean b = (Bean)request.getAttribute("bean");
		
		        request.setAttribute("b",b);
		        
		        //EmployeeDAO empDao=new EmployeeDAO();
				//empDao.delete(b);
		
		
		//【テスト用】フォワード先を格納する変数
				//String forwardPath = null;
				//【テスト用】URLの?action=の値に応じて遷移先を変更
				//String action = (String) request.getParameter("action");
				//【テスト用】予約一覧画面へ飛ばす
				//if (action.equals("list")) {
					//forwardPath = "WEB-INF/jsp/Select.jsp";
				//}

				//設定した画面にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Delete.jsp");
				dispatcher.forward(request, response);
		
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Bean bean=new Bean(Resarve, Name, Tel, Dating, Drive, Route, Seanum);
		
		
		
		//Bean b = (Bean)request.getAttribute("bean");
		
		
		//request.setAttribute("b",b);
		//int Aresarve;
		//String Aname;
		//String Atel;
		//int Adating;
		//String Adrive;
		//String Aroute;
		//String Aseanum;

		// 変数に値を格納 int型への変換に失敗したら、エラーページに飛ばす。
	//	Aresarve = Integer.parseInt(request.getParameter("resarve"));
		//Aname = request.getParameter("name");
		//Atel = request.getParameter("tel");
		//Adating = Integer.parseInt(request.getParameter("dating"));
		//Adrive = request.getParameter("drive");
		//Aroute = request.getParameter("route");
		//Aseanum = request.getParameter("seanum");

		// beanのコンストラクタを使って、値を格納する。
		//Bean bean = new Bean(Aresarve, Aname, Atel, Adating, Adrive, Aroute, Aseanum);
		
		//request.setAttribute("bean", bean);
		
		//EmployeeDAO empDao=new EmployeeDAO();
		
		
		
	//	empDao.delete(bean);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/Delete_conf.jsp");
		dispatcher.forward(request,response);
		
	}
	

	
	}
