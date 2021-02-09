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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");

		MemberDTO dto = new MemberDTO(member_id, member_pw);
		MemberDAO dao = new MemberDAO();
		MemberDTO info = dao.login(dto);

		if (info != null) {
			System.out.println("로그인 성공!");
			HttpSession session = request.getSession();
			session.setAttribute("info", info);

		} else {
			System.out.println("로그인 실패");
		}

	}

}
