package jp.co.aforce.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Register
 */
@WebServlet(urlPatterns = { "/jp/co/aforce/register/register" })
public class Register extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Page.header(out);

		try {

			//1. 入力された情報の会員がすでに存在しないかチェックする。

			//1.1 DAOの宣言
			MemberInfoDAO dao = new MemberInfoDAO();

			//1.2 会員情報を取得する
			MemberInfo mi = new MemberInfo();
			int line = dao.reference(mi);

			//1.3 既に登録されていないかチェック
			if (line > 0) {
				request.getRequestDispatcher("/views/register-error1.jsp").forward(request, response);
			}

			//2.会員情報を登録する。

			String last_name = request.getParameter("last_name");
			String first_name = request.getParameter("first_name");
			String sex = request.getParameter("sex");
			int birth_year = Integer.parseInt(request.getParameter("birth_year"));
			int birth_month = Integer.parseInt(request.getParameter("birth_month"));
			int birth_day = Integer.parseInt(request.getParameter("birth_day"));
			String job = request.getParameter("job");
			String phone_number = request.getParameter("phone_number");
			String mail_address = request.getParameter("mail_address");

			//2.1 会員番号を採番する。
			//2.1.1 現在日付を取得する
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
			String dateFormatted = df.format(date);

			//2.1.2 取得した現在日付の先頭にAを付与して会員番号を作成。
			String member_id = "A" + dateFormatted;

			//2.2 情報をDBに登録
			mi.setMember_id(member_id);
			mi.setLast_name(last_name);
			mi.setFirst_name(first_name);
			mi.setSex(sex);
			mi.setBirth_year(birth_year);
			mi.setBirth_month(birth_month);
			mi.setBirth_day(birth_day);
			mi.setJob(job);
			mi.setPhone_number(phone_number);
			mi.setMail_address(mail_address);

			line = dao.register(mi);

			//2.3 登録されたことを確認
			if (line > 0) {
				request.getRequestDispatcher("/views/register-out.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/register-error2.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Page.footer(out);
	}

}
