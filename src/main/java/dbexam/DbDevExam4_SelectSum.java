package dbexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDevExam4_SelectSum {
    public static void main(String[] args) {
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		String sql = "SELECT sum(price) AS price_sum FROM products";
    		
    		try (Connection con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");
                 PreparedStatement stmt = con.prepareStatement(sql)) {
    			
    			ResultSet rs = stmt.executeQuery();
    			
    			while (rs.next()) {
    				int priceSum = rs.getInt("price_sum");
    				
    				System.out.println("合計金額:" + priceSum);
    			}
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
}