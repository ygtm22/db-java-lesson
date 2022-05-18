package dbexam;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import java.util.List;

import enitity.Product;
import util.DbUtil;

public class DbExam5 {
    public static void main(String[] args) {
    	ProductDao dao = new ProductDao(DbUtil.getConnection());
    	
    	Product product = new Product(null, "ボールペン", 200);
    	
    	dao.register(product);
    	
    	List<Product> productList = dao.findAll();
    	
    	for (Product pd : productList) {
    		System.out.println("product_id:" + pd.getProductId() + ", product_name:" + pd.getProductName() + ", price:" + pd.getPrice());
    	}
    }
}