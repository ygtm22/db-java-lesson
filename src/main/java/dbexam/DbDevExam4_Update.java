package dbexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbDevExam4_Update {
    public static void main(String[] args) {
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		String sql = "UPDATE products SET price = ? WHERE product_id = ?";
    		
    		try (Connection con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");
                 PreparedStatement stmt = con.prepareStatement(sql)) {
    			stmt.setInt(1, 101);
    			stmt.setInt(2, 60);
    			
    			stmt.executeUpdate();
    				
    			System.out.println("登録しました");
    			
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
}