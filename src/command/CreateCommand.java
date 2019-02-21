package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		System.out.println("======> 4번 CreateCommand");
	
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		
		case SIGNUP:
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerId(request.getParameter("cusId"));
			cus.setCustomerPw(request.getParameter("cusPw"));
			cus.setCustomerName(request.getParameter("contactName"));
			cus.setAddress(request.getParameter("address"));
			cus.setCity(request.getParameter("city"));
			cus.setPostalCode(request.getParameter("pCode"));
			cus.setSsn(request.getParameter("ssn"));
			cus.setPhone(request.getParameter("phone"));
			cus.setGender(request.getParameter("gender"));
			CustomerServiceImpl.getInstance().registCustomer(cus);
			break;
			
		case REGISTER:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setManager(request.getParameter("manager"));
			emp.setName(request.getParameter("name"));
			emp.setBirthDate(request.getParameter("birth_date"));
			emp.setPhoto(request.getParameter("photo"));
			emp.setNotes(request.getParameter("desc"));
			EmployeeServiceImpl.getInstance().registEmployee(emp); //싱글톤 사용 			
			break;
			
		default:
			System.out.println("케이스가 디폴트"+Action.valueOf(request.getParameter("cmd").toUpperCase()));
			break;
		}
		

	}
}