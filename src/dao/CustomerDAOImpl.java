package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import domain.ImgDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.ImgProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerDAOImpl implements CustomerDAO {

	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	Connection conn;
	public CustomerDAOImpl() {
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
		
	}
	public static CustomerDAOImpl getInstance() {return instance;}

	@Override
	public void insertCustomer(CustomerDTO cus) {
		try {
			String sql = CustomerSQL.SIGNUP.toString();
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println("입력될 sql" + sql);
			stmt.setString(1, cus.getCustomerId());
			stmt.setString(2, cus.getCustomerName());
			stmt.setString(3, cus.getCustomerPw());
			stmt.setString(4, cus.getAddress());
			stmt.setString(5, cus.getCity());
			stmt.setString(6, cus.getPostalCode());
			stmt.setString(7, cus.getSsn());
			stmt.setString(8, cus.getGender());
			stmt.setString(9, cus.getPhone());

			int rs = stmt.executeUpdate();
			System.out.println((rs == 1) ? "입력성공" : "입력 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerDTO> selectCustomerList(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = CustomerSQL.LIST.toString();
			System.out.println(":::입력된 쿼리값:::" + sql);
			Pagination page = ((PageProxy) pxy).getPage();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, String.valueOf(page.getStartRow()));
			stmt.setString(2, String.valueOf(page.getEndRow()));
			ResultSet rs = stmt.executeQuery();
			CustomerDTO cus = null;
			while (rs.next()) {
				cus = new CustomerDTO();
				cus.setRnum(rs.getString("RNUM"));
				cus.setAddress(rs.getString("ADDRESS"));
				cus.setCity(rs.getString("CITY"));
				cus.setCustomerId(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setCustomerPw(rs.getString("CUST_PW"));
				cus.setPhone(rs.getString("PHONE"));
				cus.setPhoto(rs.getString("PHOTO"));
				cus.setPostalCode(rs.getString("POSTAL_CODE"));
				cus.setSsn(rs.getString("SSN"));
				list.add(cus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(CustomerDTO cus) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, String.valueOf(cus.getCustomerId()));
			System.out.println(":::입력된 쿼리값:::" + sql);
			ResultSet rs = stmt.executeQuery();
			CustomerDTO cust = null;
			while (rs.next()) {
				cust = new CustomerDTO();
				cust.setRnum(rs.getString("RNUM"));
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setCity(rs.getString("CITY"));
				cust.setCustomerId(rs.getString("CUSTOMER_ID"));
				cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cust.setCustomerPw(rs.getString("CUST_PW"));
				cust.setPhone(rs.getString("PHONE"));
				cust.setPhoto(rs.getString("PHOTO"));
				cust.setPostalCode(rs.getString("POSTAL_CODE"));
				cust.setSsn(rs.getString("SSN"));
				list.add(cust);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CustomerDTO selectCustomerOne(CustomerDTO cus) {
		CustomerDTO temp = null;
		try {
			String sql = CustomerSQL.DETAIL.toString();
			System.out.println(":::입력된 쿼리값:::" + sql);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, String.valueOf(cus.getCustomerId()));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				temp = new CustomerDTO();
				temp.setCustomerId(rs.getString("CUSTOMER_ID"));
				temp.setCustomerName(rs.getString("CUSTOMER_NAME"));
				temp.setCustomerPw(rs.getString("CUST_PW"));
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setCity(rs.getString("CITY"));
				temp.setPostalCode(rs.getString("POSTAL_CODE"));
				temp.setSsn(rs.getString("SSN"));
				temp.setPhone(rs.getString("PHONE"));
				temp.setPhoto(rs.getString("PHOTO"));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	@Override
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO temp = null;
		try {
			String sql = (cus.getCustomerPw() == null) ?CustomerSQL.DETAIL.toString() : CustomerSQL.SIGNIN.toString() ;				
			System.out.println(":::입력된 쿼리값:::" + sql);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cus.getCustomerId());
			if(cus.getCustomerPw() != null) {
				stmt.setString(2, cus.getCustomerPw());
			}
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				temp = new CustomerDTO();
				temp.setCustomerId(rs.getString("CUSTOMER_ID"));
				temp.setCustomerPw(rs.getString("CUST_PW"));
				temp.setCustomerName(rs.getString("CUSTOMER_NAME"));
				temp.setPhoto(rs.getString("PHOTO"));
				temp.setSsn(rs.getString("SSN"));
				temp.setCity(rs.getString("CITY"));
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setPostalCode(rs.getString("POSTAL_CODE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int countCustomer(Proxy pxy) {
		int count = 0;
		try {
			String sql = CustomerSQL.ROW_COUNT.toString();
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
	public boolean existsCustomerID(CustomerDTO cus) {
		boolean exist = false;
		try {
			String sql = "";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "");
			stmt.setString(2, "");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exist;
	}

	@Override
	public void updateCustomer(CustomerDTO cus) {
		try {
			String sql = CustomerSQL.UPDATE.toString();
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println("입력될 sql" + sql);
			stmt.setString(1, cus.getPhone());
			stmt.setString(2, cus.getCity());
			stmt.setString(3, cus.getAddress());
			stmt.setString(4, cus.getPostalCode());
			stmt.setString(5, cus.getCustomerPw());
			stmt.setString(6, cus.getCustomerId());
			int rs = stmt.executeUpdate();
			System.out.println((rs == 1) ? "입력성공" : "입력 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomerDTO cus) {
		String sql = CustomerSQL.CUST_DELETE.toString();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cus.getCustomerId());
			int rs = stmt.executeUpdate();
			System.out.println((rs == 1) ? "삭제 성공" : "삭제 실패");	
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}

	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			String sql = CustomerSQL.PHONE.toString();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			CustomerDTO cus = null; //딥카피
			while (rs.next()) {
				cus = new CustomerDTO();//딥카피
				String entry = rs.getString("CUSTOMER_ID");
				cus.setCustomerId(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setPhone(rs.getString("PHONE"));

				map.put(entry,cus);
				// 이터레이터 패턴
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> selectProfile(Proxy pxy) {
		Map<String, Object> map = new HashMap<>();
		CustomerDTO cust = new CustomerDTO();
		ImgDTO img = new ImgDTO();
		try {
			ImgProxy ipxy = (ImgProxy)pxy;
		
			ImageDAOImpl.getInstance().insertImage(ipxy.getImg());
			//이미지 테이블에 인서트 해줌. 
			
			String lastSeq  = ImageDAOImpl.getInstance().lastImageSeq(ipxy.getImg());
			//가장 마지막에 넣은 시퀀스 값을 가져옴.
			
			String sql = CustomerSQL.UPDATE_PROFILE_IMG.toString();
			String customerID = ipxy.getImg().getOwner();
			// 커스터머 photo에 시퀀스값을 넣어줌.
			System.out.println("customerID"+customerID);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lastSeq );
			ps.setString(2, customerID);	
			ps.executeUpdate();
		
			img.setImgSeq(lastSeq);
			img = ImageDAOImpl.getInstance().selectImage(img);
			
			cust.setCustomerId(customerID);
			cust = selectCustomer(cust);
			
			map.put("img",img);
			map.put("cust",cust);
			
			System.out.println("이미지정보: "+img.toString());
			System.out.println("회원정보: " + cust.toString());

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}

