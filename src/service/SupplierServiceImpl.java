package service;

import java.util.List;

import domain.SupplierDTO;

public class SupplierServiceImpl implements SupplierService {
	
	private static SupplierServiceImpl instance = new SupplierServiceImpl();
	private SupplierServiceImpl() {dao = SupplierServiceImpl.getInstance();}
	public static SupplierServiceImpl getInstance() {return instance;}

	SupplierServiceImpl dao;
	
	@Override
	public void registSupplier(SupplierDTO Supplier) {		
	}

	@Override
	public List<SupplierDTO> bringSuppliers(String searchWord) {
		return dao.bringSuppliers(searchWord);
	}

	@Override
	public List<SupplierDTO> retrieveEmployees(String searchWord) {
		return dao.retrieveEmployees(searchWord);
	}

	@Override
	public SupplierDTO retrieveSupplier(String searchWord) {
		return dao.retrieveSupplier(searchWord);
	}

	@Override
	public int countSupplier() {
		return dao.countSupplier();
	}

	@Override
	public boolean existSupplier(String searchWord) {
		return dao.existSupplier(searchWord);
	}

	@Override
	public void modifySupplier(SupplierDTO Supplier) {
		
	}

	@Override
	public void removeSupplier(SupplierDTO Supplier) {
		
	}

	
}
