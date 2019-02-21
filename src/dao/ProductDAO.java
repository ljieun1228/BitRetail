package dao;

import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import proxy.Proxy;

public interface ProductDAO {


	public void insertProduct(ProductDTO cus);
	
	public List<ProductDTO> selectProductList(Proxy pxy);
	public List<ProductDTO> selectProducts(ProductDTO product);
	public ProductDTO selectProduct(ProductDTO product);
	public ProductDTO selectProductOne(ProductDTO product);
	public Map<String, Object> selectProfile(Proxy pxy);

	public int countProduct(Proxy pxy);
	public boolean existsProductID(ProductDTO product);
	
	public void updateProduct(ProductDTO product);
	
	public void deleteProduct(ProductDTO product);
	
	
}
