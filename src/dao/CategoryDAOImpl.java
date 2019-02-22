package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CategoryDAOImpl implements CategoryDAO {
	
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	Connection conn;
	private CategoryDAOImpl() {		
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
		}
	public static CategoryDAOImpl getInstance() {return instance;}

	
	
	@Override
	public void insertCategory(CategoryDTO Cate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryDTO> selectCategoryList(Proxy pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		try {
				String sql = CategorySQL.CATE_LIST.toString();
				Pagination page = new Pagination();
				page = ((PageProxy) pxy).getPage();
				PreparedStatement stmt = conn.prepareStatement(sql);
/*				stmt.setString(1, String.valueOf(page.getStartRow()));
				stmt.setString(2, String.valueOf(page.getEndRow()));*/
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
				CategoryDTO cate = new CategoryDTO();
				cate.setCategoryId(rs.getString("CATEGORY_ID"));
				cate.setCategoryName(rs.getString("CATEGORY_NAME"));
				cate.setDescription(rs.getString("DESCRIPTION"));
				list.add(cate);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return list;
	}

	@Override
	public List<CategoryDTO> selectCategorys(CategoryDTO Cate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO selectCategory(CategoryDTO Cate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO selectCategoryOne(CategoryDTO Cate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCategory(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCategoryID(CategoryDTO Cate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCategory(CategoryDTO Cate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(CategoryDTO Cate) {
		// TODO Auto-generated method stub
		
	}

}
