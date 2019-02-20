package service;

import java.util.List;

import domain.ShipperDTO;

public class ShipperServiceImpl implements ShipperService{

	private static ShipperServiceImpl instance = new ShipperServiceImpl();
	private ShipperServiceImpl() {dao = ShipperServiceImpl.getInstance();}
	public static ShipperServiceImpl getInstance() {return instance;}

	ShipperServiceImpl dao;
	
	@Override
	public void registShipper(ShipperDTO shipper) {		
	}

	@Override
	public List<ShipperDTO> bringShippers(String searchWord) {
		return dao.bringShippers(searchWord);
	}

	@Override
	public List<ShipperDTO> retrieveEmployees(String searchWord) {
		return dao.retrieveEmployees(searchWord);
	}

	@Override
	public ShipperDTO retrieveShipper(String searchWord) {
		return dao.retrieveShipper(searchWord);
	}

	@Override
	public int countShipper() {
		return dao.countShipper();
	}

	@Override
	public boolean existShipper(String searchWord) {
		return dao.existShipper(searchWord);
	}

	@Override
	public void modifyShipper(ShipperDTO shipper) {		
	}

	@Override
	public void removeShipper(ShipperDTO shipper) {		
	}

}
