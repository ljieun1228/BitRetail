//생성순서 : 5. 캐리어 출국장 부하
//출국장~~ 리시버에서 준거 그대로 ~~ 

package command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		System.out.println("======> Carrier");
		request.getRequestDispatcher(Receiver.cmd.getView())
		.forward(request, response);

	}
		
}
