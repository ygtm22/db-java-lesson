package dbexam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enitity.Product;
import util.ParamUtil;

public class ProductDao{
	 //private Connection connection;
//	 private ProductDao productDao;

	private static final String SQL_SELECT_ALL = "SELECT *  FROM products ORDER BY product_id";
	private static final String SQL_SELECT = "SELECT * FROM products WHERE ";

	
	Connection con;
	
	public ProductDao(Connection con) {
		this.con = con;
	}
	 
	 public List<Product> findAll() {
	        List<Product> list = new ArrayList<Product>();

	        try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	            	list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	 
	 public List<Product> find(Product p) {
	        ArrayList<String> stList = new ArrayList<>();
	        ArrayList<Object> obList = new ArrayList<>();
	        
	        String productName = null;
	        Integer price = null;
	        
	        if (p != null) {
	        	productName = p.getProductName();
	        	price = p.getPrice();
	        }
	        
	        if (ParamUtil.isNullOrEmpty(productName) && price == null) {
	        	return findAll();
	        }
	        
	        if (!ParamUtil.isNullOrEmpty(productName)) {
	        	stList.add("product_name = ?");
	        	obList.add(productName);
	        }
	        
	        if (price != null) {
	        	stList.add("price = ?");
	        	obList.add(price);
	        }
	        
	        String string = String.join(" AND ", stList.toArray(new String[] {}));
	        System.out.println(string);
	        
	        List<Product> list = new ArrayList<>();
	        
	        String sql = SQL_SELECT + string;
	        System.out.println(sql);

	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
				/*
				 * stmt.setString(1, productName); stmt.setInt(2, price);
				 */
	            
	        	for (int i = 0; i < obList.size(); i++) {
	        		stmt.setObject(i + 1, obList.get(i));
	        	}
	        	
	        	ResultSet rs = stmt.executeQuery();
	        	
	            while (rs.next()) {
	            	list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
	            }
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }

	        return list;
	    }
}