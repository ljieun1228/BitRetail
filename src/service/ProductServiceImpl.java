package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAOImpl;
import dao.ProductDAOImpl;
import domain.CustomerDTO;
import domain.ProductDTO;
import proxy.ImgProxy;
import proxy.Proxy;

public class ProductServiceImpl implements ProductService{

	private static ProductServiceImpl instance = new ProductServiceImpl();
	private ProductServiceImpl() {dao = ProductDAOImpl.getInstance();}
	public static ProductServiceImpl getInstance() {return instance;}
	
	ProductDAOImpl dao;
	
	@Override
	public void registProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProductDTO> bringProductList(Proxy pxy) {
		return dao.selectProductList(pxy);
	}

	@Override
	public ProductDTO retrieveProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDTO retrieveProductOne(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countProducts(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean existProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void modifyProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}


}
