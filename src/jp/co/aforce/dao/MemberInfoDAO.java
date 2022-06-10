package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.MemberInfo;

public class MemberInfoDAO extends DAO {

	public int reference(MemberInfo memberInfo) throws Exception{
		List<MemberInfo> list = new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"SELECT * FROM Member_Info WHERE "
			+ "last_name=? AND first_name=? AND sex=? AND"
			+ " birth_year=? AND birth_month=? AND birth_day=? AND"
			+ " job=? AND phone_number=? AND mail_address=?" );
		st.setString(1, memberInfo.getLast_name());
		st.setString(2, memberInfo.getFirst_name());
		st.setString(3, memberInfo.getSex());
		st.setInt(4, memberInfo.getBirth_year());
		st.setInt(5, memberInfo.getBirth_month());
		st.setInt(6, memberInfo.getBirth_day());
		st.setString(7, memberInfo.getJob());
		st.setString(8, memberInfo.getPhone_number());
		st.setString(9, memberInfo.getMail_address());
		ResultSet rs=st.executeQuery();

		int line=0;

		while(rs.next()) {

			MemberInfo mi = new MemberInfo();
			mi.setMember_id(rs.getString("member_id"));
			mi.setLast_name(rs.getString("last_name"));
			mi.setFirst_name(rs.getString("first_name"));
			mi.setSex(rs.getString("sex"));
			mi.setBirth_year(rs.getInt("birth_year"));
			mi.setBirth_month(rs.getInt("birth_month"));
			mi.setBirth_day(rs.getInt("birth_day"));
			mi.setJob(rs.getString("job"));
			mi.setPhone_number(rs.getString("phone_number"));
			mi.setMail_address(rs.getString("mail_address"));
			list.add(mi);

			if(list.isEmpty()) {
				line=0;
			} else {
				line++;
			}
		}

		st.close();
		con.close();

		return line;

	}

	public int register(MemberInfo memberInfo) throws Exception{

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"INSERT INTO Member_Info values(?,?,?,?,?,?,?,?,?,?)");
		st.setString(1, memberInfo.getMember_id());
		st.setString(2, memberInfo.getLast_name());
		st.setString(3, memberInfo.getFirst_name());
		st.setString(4, memberInfo.getSex());
		st.setInt(5, memberInfo.getBirth_year());
		st.setInt(6, memberInfo.getBirth_month());
		st.setInt(7, memberInfo.getBirth_day());
		st.setString(8, memberInfo.getJob());
		st.setString(9, memberInfo.getPhone_number());
		st.setString(10, memberInfo.getMail_address());
		int line=st.executeUpdate();

		return line;
	}


	public List<MemberInfo> search(MemberInfo memberInfo) throws Exception{

		List<MemberInfo> list = new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"SELECT * FROM Member_Info WHERE member_id = ?");
		st.setString(1, memberInfo.getMember_id());
		ResultSet rs=st.executeQuery();

		while(rs.next()) {
			MemberInfo mi = new MemberInfo();
			mi.setMember_id(rs.getString("member_id"));
			mi.setLast_name(rs.getString("last_name"));
			mi.setFirst_name(rs.getString("first_name"));
			mi.setSex(rs.getString("sex"));
			mi.setBirth_year(rs.getInt("birth_year"));
			mi.setBirth_month(rs.getInt("birth_month"));
			mi.setBirth_day(rs.getInt("birth_day"));
			mi.setJob(rs.getString("job"));
			mi.setPhone_number(rs.getString("phone_number"));
			mi.setMail_address(rs.getString("mail_address"));

			list.add(mi);
		}

		st.close();
		con.close();

		return list;

	}


	public int update(MemberInfo memberInfo) throws Exception{

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"UPDATE Member_Info SET"
			+ " last_name=?, first_name=?, sex=?,"
			+ " birth_year=?, birth_month=?, birth_day=?,"
			+ " job=?, phone_number=?, mail_address=?"
			+ " WHERE member_id=?");

		st.setString(1, memberInfo.getLast_name());
		st.setString(2, memberInfo.getFirst_name());
		st.setString(3, memberInfo.getSex());
		st.setInt(4, memberInfo.getBirth_year());
		st.setInt(5, memberInfo.getBirth_month());
		st.setInt(6, memberInfo.getBirth_day());
		st.setString(7, memberInfo.getJob());
		st.setString(8, memberInfo.getPhone_number());
		st.setString(9, memberInfo.getMail_address());
		st.setString(10,memberInfo.getMember_id());

		int line=st.executeUpdate();

		st.close();
		con.close();

		return line;

	}


	public int delete(MemberInfo memberInfo) throws Exception{

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"DELETE FROM Member_Info WHERE member_id=?");
		st.setString(1, memberInfo.getMember_id());

		int line=st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

}
