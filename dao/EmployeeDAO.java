package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bean;

public class EmployeeDAO {

	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://fukushima-pc/BusSystem";
	private final String DB_USER = "teamc";
	private final String DB_PASS = "coconutMySQL";

	public List<Bean> findAll() {
		List<Bean> empList = new ArrayList<Bean>();

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "SELECT resarve, name, tel, dating, drive, route, seanum FROM customer";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			//結果票に格納されたレコードの内容
			//Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int resarve = rs.getInt("resarve");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				int dating = rs.getInt("dating");
				String drive = rs.getString("drive");
				String route = rs.getString("route");
				String seanum = rs.getString("seanum");
				Bean employeeBean = new Bean(resarve, name, tel, dating, drive, route, seanum);
				empList.add(employeeBean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}

	public Bean select(int resarve) {

		List<Bean> empList = new ArrayList<Bean>();
		Bean bean = new Bean();

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文を準備
			String sql = "SELECT resarve, name, tel, dating, drive, route, seanum FROM customer WHERE resarve = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1, resarve);

			ResultSet rs = pStmt.executeQuery();

			//INSERT文の中の「?」に使用する値をセットし、SQLを組み立て
			while (rs.next()) {
				int getresarve = rs.getInt("resarve");
				String getname = rs.getString("name");
				String gettel = rs.getString("tel");
				int getdating = rs.getInt("dating");
				String getdrive = rs.getString("drive");
				String getroute = rs.getString("route");
				String getseanum = rs.getString("seanum");
				bean = new Bean(getresarve, getname, gettel, getdating, getdrive, getroute, getseanum);
				empList.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bean;
	}

	/**
	 * insert()メソッド<br>
	 * ID, NAME, AGE の3つをEmployeeデーブルにINSERT(追加)します。
	 * @param employeeBean
	 * @return boolean (成功時 : True / 失敗時 : False)
	 */
	public boolean insert(Bean employeeBean) {

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//INSERT文を準備
			String sql = "INSERT INTO customer(resarve, name, tel, dating, drive, route, seanum) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文の中の「?」に使用する値をセットし、SQLを組み立て
			pStmt.setInt(1, employeeBean.getResarve());
			pStmt.setString(2, employeeBean.getName());
			pStmt.setString(3, employeeBean.getTel());
			pStmt.setInt(4, employeeBean.getDating());
			pStmt.setString(5, employeeBean.getDrive());
			pStmt.setString(6, employeeBean.getRoute());
			pStmt.setString(7, employeeBean.getSeanum());

			//INSERT文を実行し、実行結果をresultに格納
			int result = pStmt.executeUpdate();

			//成功すると1が戻るので、1ではないときには失敗
			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			System.out.println("!! レコードは追加(INSERT)されませんでした。");
			e.printStackTrace();
			return false;

		}

		System.out.println("!! レコードは正常に追加(INSERT)されました。");
		return true;
	}

	/**
	 * update()メソッド
	 * 主キーのIDをもとに、NAME, AGEの2つをUPDATE(更新)します。
	 * @param employee
	 * @return boolean (成功時 ： True / 失敗時 : False)
	 */
	public boolean update(Bean employeeBean) {

		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//UPDATE文を準備
			String sql = "UPDATE customer SET name = ?, tel = ?, dating = ?, drive = ?, route = ?, seanum = ? WHERE resarve = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//UPDATE文の中の「 ? 」に使用する値をセットし、SQLを組み立て
			pStmt.setString(1, employeeBean.getName());
			pStmt.setString(2, employeeBean.getTel());
			pStmt.setInt(3, employeeBean.getDating());
			pStmt.setString(4, employeeBean.getDrive());
			pStmt.setString(5, employeeBean.getRoute());
			pStmt.setString(6, employeeBean.getSeanum());
			pStmt.setInt(7, employeeBean.getResarve());

			//INSERT文を実行し、実行結果をresultに格納
			int result = pStmt.executeUpdate();

			//成功すると1が戻るので、1ではないときは失敗
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("!! レコードは更新(UPDATE)されませんでした。");
			e.printStackTrace();
			return false;
		}
		System.out.println("!! レコードは正常に更新(UPDATE)されました。");
		return true;
	}

	/**
	 * delete()メソッド<br>
	 * 主キーのIDをもとにレコードを取得DELETE(削除)します。<br>
	 * @param employeeBean
	 * @return boolean (成功時 : True / 失敗時 : False)
	 */

	public boolean delete(Bean employeeBean) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//UPDATE文を準備
			String sql = "DELETE FROM customer WHERE resarve = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			
			
			
			
			
			
			

			//UPDATE文の中の「 ? 」に使用する値をセットし、SQLを組み立て
			pStmt.setInt(1, employeeBean.getResarve());
			

			//INSERT文を実行し、実行結果をresultに格納
			int result = pStmt.executeUpdate();

			//成功すると1が戻るので、1ではないときには失敗
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("!! レコードは削除(DELETE)されていません");
			e.printStackTrace();
			return false;

		}
		System.out.println("!! レコードは正常に削除(DELETE)されました。");
		return true;
	}

	public boolean deleteAll(Bean employeeBean) {
		//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//UPDATE文を準備
			String sql = "DELETE * FROM customer";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文を実行し、実行結果をresultに格納
			int result = pStmt.executeUpdate();

			//成功すると1が戻るので、1ではないときには失敗
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("!! レコードは全件削除(DELETE*)されていません");
			e.printStackTrace();
			return false;

		}
		System.out.println("!! レコードは正常に全件削除(DELETE*)されました。");
		return true;
	}
}