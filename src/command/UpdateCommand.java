package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();

		System.out.println("======6 UpdateCommand =======");
		
		String customerID = request.getParameter("id");
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerId(customerID);
		cus = CustomerServiceImpl.getInstance().retrieveCustomerOne(cus);
		
		System.out.println("수정하기전 회원의 정보: "+cus.toString());
		
		if(!request.getParameter("city").equals(""))
			cus.setCity(request.getParameter("city"));
		if(!request.getParameter("address").equals(""))
			cus.setAddress(request.getParameter("address"));
		if(!request.getParameter("postal_code").equals(""))
			cus.setPostalCode(request.getParameter("postal_code"));
		if(!request.getParameter("password").equals(""))
			cus.setCustomerPw(request.getParameter("password"));
		if(!request.getParameter("phone").equals(""))
			cus.setPhone(request.getParameter("phone"));
		
		System.out.println("수정하려는 회원의 정보 "+cus.toString());
		
		CustomerServiceImpl.getInstance().modifyCustomer(cus);
		request.setAttribute("cus", cus);
	}
}