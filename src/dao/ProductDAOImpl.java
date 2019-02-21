package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import enums.CustomerSQL;
import enums.ProductSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class ProductDAOImpl implements ProductDAO {

	private static ProductDAOImpl instance = new ProductDAOImpl();
	Connection conn;
	public ProductDAOImpl() {
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
		
	}
	public static ProductDAOImpl getInstance() {return instance;}
	@Override
	public void insertProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List<ProductDTO> selectProductList(Proxy pxy) {
		List<ProductDTO> list = new ArrayList<>();
		try {
			String sql = ProductSQL.LIST.toString();
			System.out.println(":::입력된 쿼리값:::" + sql);
			Pagination page = ((PageProxy) pxy).getPage();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, String.valueOf(page.getStartRow()));
			stmt.setString(2, String.valueOf(page.getEndRow()));
			ResultSet rs = stmt.executeQuery();
			ProductDTO pro = null;
			while (rs.next()) {
				pro = new ProductDTO();
				pro.setRnum(rs.getString("RNUM"));
				pro.setProductId(rs.getString("PRODUCT_ID"));
				pro.setProductName(rs.getString("PRODUCT_NAME"));
				pro.setSupplierId(rs.getString("SUPPLIER_ID"));
				pro.setCategoryId(rs.getString("CATEGORY_ID"));
				pro.setUnit(rs.getString("UNIT"));
				pro.setPrice(rs.getString("PRICE"));
				list.add(pro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductDTO> selectProducts(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDTO selectProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDTO selectProductOne(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, Object> selectProfile(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countProduct(Proxy pxy) {
		int count = 0 ; 
		try {
			String sql = ProductSQL.ROW_COUNT.toString();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return count;
	}
	@Override
	public boolean existsProductID(ProductDTO product) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void updateProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		
	}

}

