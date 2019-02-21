package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();

		System.out.println("======6 DeleteCommand =======");
		
		String customerID = request.getParameter("customerId");
		
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerId(customerID);
		cus = CustomerServiceImpl.getInstance().retrieveCustomerOne(cus);
		
		CustomerServiceImpl.getInstance().removeCustomer(cus);
		
		super.setDomain("home");
		super.setPage("main");
		super.execute();
	
	}
}