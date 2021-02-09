package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDTO;
import com.repository.MemberDAO;

/**
 * Servlet implementation class Join
 */
@WebServlet("/Join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");


		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO(member_id, member_pw);
		int cnt = dao.join(dto);
		

		if (cnt > 0) {
			System.out.println("회원가입성공!");
			HttpSession session = request.getSession();
			session.setAttribute("member_id", member_id);
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("회원가입실패!");
			response.sendRedirect("join_success.jsp");
		}

	}
}
