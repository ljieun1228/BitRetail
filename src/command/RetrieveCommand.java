package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ImgDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ImageServiceImpl;

public class RetrieveCommand extends Command {
	public RetrieveCommand(Map<String, Proxy> pxy) {
		super(pxy);
		
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		System.out.println("======> 4번 RetrieveCommand");
		System.out.println("cmd"+request.getParameter("cmd"));
		System.out.println("page"+request.getParameter("page"));
		System.out.println("customerId"+request.getParameter("customerId"));		
		
		CustomerDTO cus = new CustomerDTO();
		ImgDTO img = new ImgDTO();
		cus.setCustomerId(request.getParameter("customerId"));
		cus = CustomerServiceImpl.getInstance().retrieveCustomerOne(cus);

	    request.setAttribute("cus", cus);
	    request.setAttribute("img", img);

	}
}