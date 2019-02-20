//DB에 값 두개 empno랑 name 
package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class ListCommand extends Command {
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);

		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		System.out.println("======> 4번 ListCommand");
		System.out.println("cmd"+request.getParameter("cmd"));
		System.out.println("page"+request.getParameter("page"));
		System.out.println("page_num"+request.getParameter("page_num"));		
		System.out.println("page_size"+request.getParameter("page_size"));
		
		PageProxy pagePxy = new PageProxy();
		Pagination page = new Pagination();
		page.carryOut(request);
		pagePxy.carryOut(page);
		List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(pagePxy);
	    request.setAttribute("list", list);
	    request.setAttribute("pagination", page);
	}
}
