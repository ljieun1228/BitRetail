//생성순서 : 5. 리시버 입국장 부하
//입국장~~ 정보를 받아준다. 
package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.Proxy;
import proxy.RequestProxy;
import proxy.ResponseProxy;

public class Receiver {
	public static Command cmd = new Command();

	public static void init(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("======> 2번 Receiver");
		RequestProxy req = new RequestProxy();
		ResponseProxy resp = new ResponseProxy();
		Map<String, Proxy> pxy = new HashMap<>();
		req.carryOut(request);
		resp.carryOut(response);
		pxy.put("req", req);
		pxy.put("resp", resp);
		cmd = Commander.order(pxy);
	}
}
