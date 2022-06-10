package jp.co.aforce.delete;

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
 * Servlet implementation class Delete
 */
@WebServlet(urlPatterns = { "/jp/co/aforce/delete/delete" })
public class Delete extends HttpServlet {

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

			list = dao.search(mi);


			//1.3 DBに存在するかをチェック
			if(list.size()==0) {
				request.getRequestDispatcher("/views/delete-error.jsp").forward(request, response);
			}

			//2. 会員情報を削除

			int line = dao.delete(mi);

			if (line > 0) {
				request.getRequestDispatcher("/views/delete-out.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/delete-error.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
