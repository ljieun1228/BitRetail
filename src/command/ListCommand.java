//DB에 값 두개 empno랑 name 
package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;

public class ListCommand extends Command {
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);

		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		System.out.println("======> 4번 ListCommand");
		
		PageProxy pagePxy = new PageProxy();
		Pagination page = new Pagination();
		page.carryOut(request);
		pagePxy.carryOut(page);
		String flag = request.getParameter("cmd").toUpperCase();
		
		List<?> list = new ArrayList<>();
		
		switch (Action.valueOf(flag)) {
		
		case CUST_LIST :
			 System.out.println("CUST_LIST 진입");
			 list = CustomerServiceImpl.getInstance().bringCustomerList(pagePxy);
			break;
			
		case CATE_LIST :
			 System.out.println("CATE_LIST 진입");
			 list = CategoryServiceImpl.getInstance().bringCategoryList(pagePxy);
			 System.out.println("list 열어보자"+list.toString());
			break;

		default:
			break;
		}
	    request.setAttribute("list", list);
	    request.setAttribute("pagination", page);
	}
}
