package service;

import java.util.List;

import domain.SupplierDTO;

public interface SupplierService {

	public void registSupplier(SupplierDTO Supplier);
	public List<SupplierDTO> bringSuppliers(String searchWord);
	public List<SupplierDTO> retrieveEmployees(String searchWord);
	public SupplierDTO retrieveSupplier(String searchWord);
	public int countSupplier();
	public boolean existSupplier(String searchWord);
	public void modifySupplier(SupplierDTO Supplier);
	public void removeSupplier(SupplierDTO Supplier);
}
