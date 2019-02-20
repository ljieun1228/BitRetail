package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import domain.ImgDTO;
import enums.CustomerSQL;
import enums.ImageSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO {

	private static ImageDAOImpl instance = new ImageDAOImpl();
	
	Connection conn;
	private ImageDAOImpl() {
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
	}
	public static ImageDAOImpl getInstance() {return instance;}
	
	
	
	@Override
	public void insertImage(ImgDTO img) {
		try {
			String sql = ImageSQL.IMG_ADD.toString();
			System.out.println("포토 인서트 쿼리 실행!!");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, img.getImgName());
			stmt.setString(2, img.getImgExtention());
			stmt.setString(3, img.getOwner());
			int rs = stmt.executeUpdate();
			System.out.println((rs == 1) ? "입력성공" : "입력 실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<ImgDTO> selectimageList(Proxy proxy) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ImgDTO> selectimages(Proxy proxy) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ImgDTO selectImage(ImgDTO img) {
		ImgDTO temp = null;
		try {
			String sql = ImageSQL.SELECT_ONE_IMG.toString();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, img.getImgSeq());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				temp = new ImgDTO();
				temp.setImgExtention(rs.getString("IMG_EXTENTION"));
				temp.setOwner(rs.getString("OWNER"));
				temp.setImgName(rs.getString("IMG_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	@Override
	public String lastImageSeq(ImgDTO img) {
		String seq = "";
		try {
			String sql =  ImageSQL.IMG_LAST_SEQ.toString();
					
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				seq = rs.getString("IMG_SEQ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seq;
	}
	@Override
	public int countImage(Proxy proxy) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateImage(ImgDTO img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteImage(ImgDTO img) {
		// TODO Auto-generated method stub
		
	}

	
}
