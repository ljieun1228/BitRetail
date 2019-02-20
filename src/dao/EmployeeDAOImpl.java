package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {dao = EmployeeDAOImpl.getInstance();}
	public static EmployeeDAOImpl getInstance() {return instance;}

	EmployeeDAOImpl dao;

	@Override
	public void insertEmployee(EmployeeDTO emp) {
		try {
			String sql = EmployeeSQL.REGISTER.toString();
			Connection conn = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getManager());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthDate());
			pstmt.setString(4, emp.getPhoto());
			pstmt.setString(5, emp.getNotes());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1)?"입력성공":"입력 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//prepareStatement동적 sql문 전달 재사용에 용이함 . 
	
	@Override
	public List<EmployeeDTO> selectEmployeeList() {
		List<EmployeeDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement pstmt = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, "");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}

	@Override
	public List<EmployeeDTO> selectEmployees(String searchWord) {
		List<EmployeeDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement prs = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			prs.setString(1, "");
			ResultSet rs = prs.executeQuery();
			while (rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public EmployeeDTO selectEmployee(EmployeeDTO emp) {
		EmployeeDTO emp1 = new EmployeeDTO();
		String sql = "";
		try {
			PreparedStatement stmt = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			stmt.setString(1, "");
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp1;
	}

	@Override
	public int countEmployees() {
		int res = 0;
		try {
			String sql = "";
			PreparedStatement psmt = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean existsEmployees(EmployeeDTO emp) {
		boolean ok = false;
		try {
					String sql = EmployeeSQL.ACCESS.toString();
					PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
					System.out.println(":::입력받은 ID :::" + emp.getEmployeeId());
					System.out.println(":::입력받은 이름 :::" + emp.getName());
					ps.setString(1, emp.getEmployeeId());
					ps.setString(2, emp.getName());
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
							ok = true;
					}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dao 내부 접근여부" + ok);
		return ok;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
				ps.setString(1, "");
			int rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {		
		try {
			String sql = "";
			PreparedStatement stmt = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			stmt.setString(1, "");
			int rs = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}