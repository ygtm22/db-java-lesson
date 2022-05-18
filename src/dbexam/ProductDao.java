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
	private static final String SELECT_WHERE_PRODUCT_ID = "SELECT product_id, product_name, price FROM products WHERE product_id = ?";
	private static final String UPDATE = "UPDATE products SET product_name = ?, price = ? WHERE product_id = ?";
	private static final String DELETE = "DELETE FROM products WHERE product_name = ?";

	
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
	
	public Product fintdByProductId(Integer productId) {
		 try (PreparedStatement stmt = con.prepareStatement(SELECT_WHERE_PRODUCT_ID)) {
		        stmt.setInt(1, productId);
		        ResultSet rs = stmt.executeQuery();

		        if (rs.next()) {
		            return new Product(rs.getInt("product_id"), rs.getString("product_name"),  rs.getInt("price"));
		        }
		    } catch (SQLException e) {
		       e.printStackTrace();
		    }

		    return null;
	}
	
	public void update(Product pu) {
		try (PreparedStatement stmt = con.prepareStatement(UPDATE)) {
	        stmt.setString(1, pu.getProductName());
	        stmt.setInt(2, pu.getPrice());
	        stmt.setInt(3, pu.getProductId());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void delete(String pd) {
		 try (PreparedStatement stmt = con.prepareStatement(DELETE)) {
		        stmt.setString(1, pd);

		        stmt.executeUpdate();
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
	}
}