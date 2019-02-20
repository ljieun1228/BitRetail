package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.ImgProxy;
import proxy.Proxy;

public class CustomerServiceImpl implements CustomerService{

	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl() {dao = CustomerDAOImpl.getInstance();}
	public static CustomerServiceImpl getInstance() {return instance;}
	
	CustomerDAOImpl dao;

	@Override
	public void registCustomer(CustomerDTO cus) {
		dao.insertCustomer(cus);
		
	}

	@Override
	public List<CustomerDTO> bringCustomerList(Proxy pxy) {
		return dao.selectCustomerList(pxy);
	}

	@Override
	public List<CustomerDTO> retrieveEmployees(CustomerDTO cust) {
		return dao.selectCustomers(cust);
	}

	@Override
	public CustomerDTO retrieveCustomerOne(CustomerDTO cust){
		return dao.selectCustomerOne(cust);
	}
	
	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cust) {
		return dao.selectCustomer(cust);
	}
	
	@Override
	public int countCustomers(Proxy pxy) {
		return dao.countCustomer(pxy);
	}

	@Override
	public boolean existCustomer(CustomerDTO cus) {
		return dao.existsCustomerID(cus);
	}
	
	@Override
	public void modifyCustomer(CustomerDTO cus) {
		dao.updateCustomer(cus);
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
	}
	
	@Override
	public Map<String, Object> retrievePhone(Proxy pxy) {
		 return dao.selectPhone(pxy);
	}
	
	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		return dao.selectProfile(pxy);
		
	}

}
