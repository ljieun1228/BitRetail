package dao;

import java.util.List;

import domain.ShipperDTO;

public interface ShipperDAO {

	public void registShipper(ShipperDTO Shipper);
	public List<ShipperDTO> bringShippers(String searchWord);
	public List<ShipperDTO> retrieveEmployees(String searchWord);
	public ShipperDTO retrieveShipper(String searchWord);
	public int countShipper();
	public boolean existShipper(String searchWord);
	public void modifyShipper(ShipperDTO Shipper);
	public void removeShipper(ShipperDTO Shipper);
}
