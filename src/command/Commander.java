//생성순서 : 4. user, has-a 관계  (사용하는 관계)

package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

public class Commander {

	public static Command order(Map<String,Proxy> pxy) {
		System.out.println("======> 5번 Commander ");
		
		Command cmd = null;
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		
		case MOVE:
			cmd = new Command(pxy);
			System.out.println("커멘더 액션 MOVE" );
			break;
			
		case REGISTER: case SIGNUP:
			cmd = new CreateCommand(pxy);
			System.out.println("커멘더 액션 REGISTER, SIGNUP");
			break;
			
		case ACCESS: case SIGNIN:
			cmd = new ExistCommand(pxy);
			System.out.println("커멘더 액션 ACCESS, SIGNIN");
			break;	

		case  CUST_LIST: case CATE_LIST: 
			cmd = new ListCommand(pxy);
			System.out.println("커멘더 액션 PRODUCT_LIST");
			break;
			
		case CUST_RETRIEVE: 
			cmd = new RetrieveCommand(pxy);
			System.out.println("커멘더 액션 CUST_RETRIEVE");
			break;	
			
		case CUST_UPDATE: 
			cmd = new UpdateCommand(pxy);
			System.out.println("커멘더 액션 CUST_UPDATE");
			break;		
			
		case CUST_FILE_UPLOAD: 
			cmd = new FileCommand(pxy);
			System.out.println("커멘더 액션 CUS_FILE_UPLOAD");
			break;	
			
		case CUST_DELETE: 
			cmd = new DeleteCommand (pxy);
			System.out.println("커멘더 액션 CUST_DELETE");
			break;
		
	/*	case PRODUCT_LIST: 
			cmd = new ProductListCommand(pxy);
			System.out.println("커멘더 액션 PRODUCT_LIST");
			break;*/
			
		default:
			break;
		}
		System.out.println("커맨더 내 : "+ Receiver.cmd.getView());
		return cmd;
	}
}
