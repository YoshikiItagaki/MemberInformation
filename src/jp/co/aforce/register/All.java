
package jp.co.aforce.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class All
 */
@WebServlet(urlPatterns= {"/jp/co/aforce/register/all"})
public class All extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	Page.header(out);

	try {
		InitialContext ic = new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/member_information");
		Connection con=ds.getConnection();

		PreparedStatement st=con.prepareStatement("select * from Member_Info");
		ResultSet rs=st.executeQuery();

		while(rs.next()) {
			out.println(rs.getString("last_name"));
			out.println(rs.getString("member_id"));
		}

		st.close();
		con.close();
	} catch(Exception e) {
		e.printStackTrace();
	}

	Page.footer(out);


	}


}
