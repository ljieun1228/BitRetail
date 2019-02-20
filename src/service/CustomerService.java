package service;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.ImgProxy;
import proxy.Proxy;

public interface CustomerService {

	public void registCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(Proxy pxy);//플레이스홀더 역할..
	public List<CustomerDTO> retrieveEmployees(CustomerDTO cust);
	public CustomerDTO retrieveCustomer(CustomerDTO cust);
	public CustomerDTO retrieveCustomerOne(CustomerDTO cust);
	public int countCustomers(Proxy pxy);
	public boolean existCustomer(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
	public Map<String,Object> retrievePhone(Proxy pxy);
	
	public Map<String, Object> fileUpload(Proxy pxy);
	
	//정석 예제 11-32 구현
}
