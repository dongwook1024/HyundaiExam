package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.MemberDao;
import org.study.model.Member;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.getRequestDispatcher("/WEB-INF/views/registerForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			
		String id = request.getParameter("id");
		
		String name = request.getParameter("name");
		
		String pw = request.getParameter("pw");
		
		String dob = request.getParameter("dob");
		
		String email = request.getParameter("email");
		
		Member member = new Member();
		
		member.setId(id);
		
		member.setName(name);
		
		member.setDob(java.sql.Date.valueOf(dob));
		
		member.setEmail(email);
		
		MemberDao dao = new MemberDao();
		
		if (dao.insertMember(member)) {
			
			response.sendRedirect(request.getContextPath() + "/list");
		} else {
			
			request.setAttribute("error", "회원등록이 실패하였습니다");
			
			request.getRequestDispatcher("/WEB-INF/views/registerForm.jsp").forward(request, response);
		}
	}
}
