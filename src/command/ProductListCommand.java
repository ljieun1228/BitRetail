//DB에 값 두개 empno랑 name 
package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ProductDTO;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

public class ProductListCommand extends Command {
	public ProductListCommand(Map<String,Proxy> pxy) {
		super(pxy);

		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		System.out.println("======> 4번 ProductListCommand");
		System.out.println("cmd"+request.getParameter("cmd"));
		System.out.println("page"+request.getParameter("page"));
		System.out.println("page_num"+request.getParameter("page_num"));		
		System.out.println("page_size"+request.getParameter("page_size"));
		
		PageProxy pagePxy = new PageProxy();
		Pagination page = new Pagination();
		page.carryOut(request);
		pagePxy.carryOut(page);
		List<ProductDTO> list = ProductServiceImpl.getInstance().bringProductList(pagePxy);
		System.out.println("리스트~~서비스"+list.toString());
		request.setAttribute("pro_list", list);
	    request.setAttribute("pagination", page);
	}
}
