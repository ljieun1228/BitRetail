package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.EmployeeDTO;

@WebServlet("/home.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("홈서블릿으로 들어옴");
		
		HttpSession session = request.getSession(); 
		session.setAttribute("ctx", request.getContextPath());
		session.setAttribute("css", session.getAttribute("ctx")+"/resources/css/");
		session.setAttribute("js", session.getAttribute("ctx")+"/resources/js/");
		session.setAttribute("img", session.getAttribute("ctx")+"/resources/img/");

		EmployeeDTO e = (EmployeeDTO) session.getAttribute("employee");
		if(e==null) {
			request.setAttribute("compo", "register");//홈메인로그인하면 네비바 바꾸도록 compo에 pre넣어줌
		}else {
			request.setAttribute("compo", "access");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/home/main.jsp");
		rd.forward(request, response);

	}
}
