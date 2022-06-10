package jp.co.aforce.update;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Update
 */
@WebServlet(urlPatterns = { "/jp/co/aforce/update/update" })
public class Update extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		try {
			List<MemberInfo> list = new ArrayList<>();

			//1. 入力された情報の会員が存在することを確認する

			//1.1 DAOの宣言
			MemberInfoDAO dao=new MemberInfoDAO();

			//1.2 会員情報を取得する
			MemberInfo mi = new MemberInfo();
			String member_id=request.getParameter("member_id");
			mi.setMember_id(member_id);


			//1.3 検索する
			list = dao.search(mi);
			request.setAttribute("list", list);
			


			//1.3 DBに存在するかをチェック
			if(list.size()>0) {
				request.getRequestDispatcher("/views/update.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/update-error1.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Page.footer(out);
	}



}
