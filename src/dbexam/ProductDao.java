package dbexam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enitity.Product;

public class ProductDao{
	 //private Connection connection;
//	 private ProductDao productDao;
	
	private static final String SELECT_ALL = "SELECT product_id, product_name, price FROM products ORDER BY product_id";
	private static final String INSERT = "INSERT INTO products (product_name, price) VALUES (?, ?)";
	
	Connection con;
	
	public ProductDao(Connection con) {
		this.con = con;
	}

	public List<Product> findAll(){
		List<Product> list = new ArrayList<>();
		
		try (PreparedStatement stmt = con.prepareStatement(SELECT_ALL)) {
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	        list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void register(Product p) {
		try (PreparedStatement stmt = con.prepareStatement(INSERT)){
			stmt.setString(1, p.getProductName());
			stmt.setInt(2, p.getPrice());
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}