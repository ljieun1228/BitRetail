package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

@WebServlet("/product.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductServiceImpl pService = ProductServiceImpl.getInstance(); 
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("======> 1번 productController");		
		Receiver.init(request, response);
		Carrier.forward(request, response);
	}
}