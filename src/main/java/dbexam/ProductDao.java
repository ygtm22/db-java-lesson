package dbexam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enitity.Product;

public class ProductDao{
	 //private Connection connection;
//	 private ProductDao productDao;
	
	private static final String SQL_SELECT_PRODUCT_ID = "SELECT * FROM Products WHERE product_id = ?";

	
	Connection con;
	
	public ProductDao(Connection con) {
		this.con = con;
	}
	
	 public Product findByProductId(Integer productId) {
	        try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_PRODUCT_ID)) {
	            stmt.setInt(1, productId);

	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
	            } else {
	                return null;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return null;
	    }
}