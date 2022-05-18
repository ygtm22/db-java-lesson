package dbexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbDevExam4_Delete {
    public static void main(String[] args) {
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		String sql = "DELETE FROM products WHERE product_name = ?";
    		
    		try (Connection con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");
                 PreparedStatement stmt = con.prepareStatement(sql)) {
    			stmt.setString(1, "ボールペン");
    			
    			stmt.executeUpdate();
    				
    			System.out.println("削除しました");
    			
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
}