package dbexam;

import java.util.List;

import enitity.Product;
import util.DbUtil;

public class DbExam_Delete {
    public static void main(String[] args) {
    	ProductDao dao = new ProductDao(DbUtil.getConnection());
    	
    	String product_name = "ボールペン";
    	
    	dao.delete(product_name);
    	
    	List<Product> productList = dao.findAll();
    	
    	for (Product pd : productList) {
    		System.out.println("product_id:" + pd.getProductId() + ", product_name:" + pd.getProductName() + ", price:" + pd.getPrice());
    	}
    }
}