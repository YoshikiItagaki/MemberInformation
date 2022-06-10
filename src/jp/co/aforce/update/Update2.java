package jp.co.aforce.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Update2
 */
@WebServlet(urlPatterns = { "/jp/co/aforce/update/update2" })
public class Update2 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		try {

			//2.1 DAOの宣言
			MemberInfoDAO dao=new MemberInfoDAO();

			//2.2 会員情報を取得する
			MemberInfo mi = new MemberInfo();

			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String sex = request.getParameter("sex");
			int birth_year = Integer.parseInt(request.getParameter("birth_year"));
			int birth_month = Integer.parseInt(request.getParameter("birth_month"));
			int birth_day = Integer.parseInt(request.getParameter("birth_day"));
			String job = request.getParameter("job");
			String phone_number = request.getParameter("phone_number");
			String mail_address = request.getParameter("mail_address");
			String member_id = request.getParameter("member_id");

			mi.setLast_name(last_name);
			mi.setFirst_name(first_name);
			mi.setSex(sex);
			mi.setBirth_year(birth_year);
			mi.setBirth_month(birth_month);
			mi.setBirth_day(birth_day);
			mi.setJob(job);
			mi.setPhone_number(phone_number);
			mi.setMail_address(mail_address);
			mi.setMember_id(member_id);

			//2.3　会員情報を更新
			int line = dao.update(mi);

			if (line > 0) {
				request.getRequestDispatcher("/views/update-out.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/update-error2.jsp").forward(request, response);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
