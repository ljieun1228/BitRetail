package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();
	private  EmployeeServiceImpl() {dao = EmployeeDAOImpl.getInstance();}
	public static EmployeeServiceImpl getInstance() {return instance;}


	EmployeeDAOImpl dao;
	
	@Override
	public void registEmployee(EmployeeDTO emp) {
		dao.insertEmployee(emp);
	
	}

	@Override
	public List<EmployeeDTO> bringEmployeeList() {
		return dao.selectEmployeeList();
	}

	@Override
	public List<EmployeeDTO> retrieveEmployees(String searchWord) {
		return dao.selectEmployees(searchWord);
	}

	@Override
	public EmployeeDTO retrieveEmployee(EmployeeDTO emp) {		
		return dao.selectEmployee(emp);
	}

	@Override
	public int countEmployees() {
		return dao.countEmployees();
	}

	@Override
	public boolean existsEmployees(EmployeeDTO emp) {
		return dao.existsEmployees(emp);
	}

	@Override
	public void modifyEmployee(EmployeeDTO emp) {
		
	}

	@Override
	public void removeEmployee(EmployeeDTO emp) {
		
	}

}
