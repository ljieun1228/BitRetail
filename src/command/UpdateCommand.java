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
		

		/*String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String postalCode = request.getParameter("postal_code");
		String password = request.getParameter("password");
		
		phone = (phone.equals(""))?cus.getPhone():request.getParameter("phone");
		city = (city.equals(""))?cus.getCity():request.getParameter("city");
		address = (address.equals(""))?cus.getAddress():request.getParameter("address");
		postalCode = (postalCode.equals(""))?cus.getPostalCode():request.getParameter("postalCode");
		password = (password.equals(""))?cus.getCustomerPw():request.getParameter("password");

		cus.setPhone(phone); 
		cus.setCity(city); 
		cus.setAddress(address); 
		cus.setPostalCode(postalCode); 
		cus.setCustomerPw(password);*/

		System.out.println("수정하려는 회원의 정보 "+cus.toString());
		
		CustomerServiceImpl.getInstance().modifyCustomer(cus);
		request.setAttribute("cus", cus);
	}
}