/*package jp.co.aforce.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;
import jp.co.aforce.message.Messages;
import jp.co.aforce.tool.Page;

*//**
	* Servlet implementation class Search
	*//*
		@WebServlet(urlPatterns = { "/jp/co/aforce/search/search" })
		public class Search extends HttpServlet {

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			Page.header(out);

			try {
				String member_id = request.getParameter("member_id");

				MemberInfo mi = new MemberInfo();

				MemberInfoDAO dao=new MemberInfoDAO();
				Messages msg = new Messages();

				msg.message();



				int line = dao.search(mi);

				if (line > 0) {
					out.println(msg.message().get("202"));
				} else {
					out.println(msg.message().get("103"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			Page.footer(out);
		}

		}
		*/