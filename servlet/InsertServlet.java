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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//【テスト用】フォワード先を格納する変数
		String forwardPath = null;
		//【テスト用】URLの?action=の値に応じて遷移先を変更
		String action = (String) request.getParameter("action");
		//【テスト用】予約一覧画面へ飛ばす
		if (action != null && action.equals("list")) {
			forwardPath = "WEB-INF/jsp/Select.jsp";
		}

		//設定した画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//文字コードの指定
		request.setCharacterEncoding("UTF-8");

		// 値を保存する変数の宣言
		int Aresarve;
		String Aname;
		String Atel;
		int Adating;
		String Adrive;
		String Aroute;
		String Aseanum;

		// 変数に値を格納 int型への変換に失敗したら、エラーページに飛ばす。
		try {
			Aresarve = Integer.parseInt(request.getParameter("resarve"));
			Aname = request.getParameter("name");
			Atel = request.getParameter("tel");
			Adating = Integer.parseInt(request.getParameter("dating"));
			Adrive = request.getParameter("drive");
			Aroute = request.getParameter("route");
			Aseanum = request.getParameter("seanum");
		} catch (NumberFormatException e) {

			// エラーページ
//			response.sendRedirect("err.html");
			return;
		}

		// beanのコンストラクタを使って、値を格納する。
		Bean bean = new Bean(Aresarve, Aname, Atel, Adating, Adrive, Aroute, Aseanum);

		// Daoを使う準備
		EmployeeDAO Dao = new EmployeeDAO();

		// DaoのUpdateメソッドを使用(引数：bean)
		Dao.insert(bean);

		// 【テスト用】beanをスコープに保存
		request.setAttribute("bean", bean);

		// 【テスト用】beanにちゃんと格納できたか確認するページに飛ぶ。
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Insertcheck.jsp");
		dispatcher.forward(request, response);
	}

}
