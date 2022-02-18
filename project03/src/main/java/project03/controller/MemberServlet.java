package project03.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project03.DAO.memberDAO;
import project03.VO.MemberVo;

@WebServlet("/MemberList")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
	
		memberDAO m_dao = new memberDAO();
		List<MemberVo>list =m_dao.member_list();
		
		

		String data="<html>";
		data+="<style>";
		data+="table{width:100%; border-top:1px solid #444444; border-collapse:collapse;}";
		data+="th,td{border-bottom:1px solid #444444; padding:10px}";
		data+="</style>";
		data+="<body>";
		data+="<table>";
		data+="<tr>";
		data+="<td>시퀀스</td>";
		data+="<td>이름</td>";
		data+="<td>아이디</td>";
		data+="<td>패스워드</td>";
		data+="<td>이메일</td>";
		data+="<td>핸드폰</td>";
		data+="<td>등록일</td>";
		data+="<td>수정일</td>";
		data+="</tr>";
		for(int i=0; i<list.size(); i++) {
			MemberVo memverVo=(MemberVo)list.get(i);
			data+="<tr>";
			data+="<td>"+memverVo.getM_idx()+"</td>";
			data+="<td>"+memverVo.getM_name()+"</td>";
			data+="<td>"+memverVo.getM_id()+"</td>";
			data+="<td>"+memverVo.getM_pw()+"</td>";
			data+="<td>"+memverVo.getM_email()+"</td>";
			data+="<td>"+memverVo.getM_phone()+"</td>";
			data+="<td>"+memverVo.getM_rgstDate()+"</td>";
			data+="<td>"+memverVo.getM_mdfyDate()+"</td>";
			data+="</tr>";
		}
		data+="</table>";
		data+="</body>";
		data+="</html>";
		
		
		out.print(data);
		


}}
