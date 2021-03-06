//DB에 값 두개 empno랑 name 
package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		System.out.println("======6 ExistCommand =======");
		HttpSession session = request.getSession();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			
			emp.setEmployeeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployees(emp);
			
			if(exist) {
				System.out.println("사원 접근허용 exist:" + exist);
				
			    Proxy paging  = new Pagination();
			    paging.carryOut(request);
			    
			    Proxy pagePxy = new PageProxy();
			    pagePxy.carryOut(paging);
				
				List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(pagePxy);
				
				System.out.println("총 고객의 수 :" + list.size());
				System.out.println("가장 최근에 가입한 고객명 :" + list.get(0).getCustomerName());
				
				request.setAttribute("list", list);
				request.setAttribute("pagination", paging);
				
			}else {
				System.out.println(":::접근불가:::");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}	
			break;

		case SIGNIN :
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerId(request.getParameter("custId"));
			cus.setCustomerPw(request.getParameter("custPw"));
			cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
			if(cus != null) {
				System.out.println("로그인성공");
				session.setAttribute("customer", cus);
			}else {
				System.out.println("로그인실패");
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
			break;
			
		default:
			break;
		}
	}
}