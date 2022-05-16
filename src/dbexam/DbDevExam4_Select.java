package dbexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDevExam4_Select {
    public static void main(String[] args) {
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		String sql = "SELECT product_id, product_name, price FROM products ORDER BY product_id ";
    		
    		try (Connection con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");
                 PreparedStatement stmt = con.prepareStatement(sql)) {
    			
    			ResultSet rs = stmt.executeQuery();
    			
    			while (rs.next()) {
    				int productId = rs.getInt("product_id");
    				String productName = rs.getString("product_name");
    				int price = rs.getInt("price");
    				
    				System.out.println("product_id:" + productId + "product_name:" + productName + "price:" + price);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
}