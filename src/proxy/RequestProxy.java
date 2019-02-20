package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class RequestProxy implements Proxy {
	private HttpServletRequest request;
	
	@Override
	public void carryOut(Object o) {
		System.out.println("======> 3번 carryOut");
		if ((HttpServletRequest) o != null) {
			System.out.println("o가 널이 아님");
			setRequest((HttpServletRequest)o);
		} else {
			System.out.println("o가 널임");

		}
	}
	
}
