package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.ImgProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class FileCommand extends Command {
	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();

		System.out.println("======6 FileCommand =======");

		//1. 업로드한 이미지를 insert 해야 한다.
		//2. customer안 photo에 대표 이미지를 방금 인서트한 이미지로 바꿔야 한다.
		//3. 단,default_photo.jpg 로 되어있는 것을 이미지의 seq값으로 바꾼다.
		//4. 이후 고객의 정보 , 이미지에서 seq에 따른 이미지 정보 두개를 가져온다.
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {

		case CUST_FILE_UPLOAD:
			System.out.println("::파일커맨드 파일업로드 진입::");
			ImgProxy ipxy = new ImgProxy();
			ipxy.carryOut(request);
			
			Map<String, Object> map = CustomerServiceImpl.getInstance().fileUpload(ipxy);						
			
			request.setAttribute("image", map.get("img"));
			request.setAttribute("cus", map.get("cust"));

			break;

		default:
			break;

		}
	}
}