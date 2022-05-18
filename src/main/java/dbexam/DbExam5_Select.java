package dbexam;

import enitity.Product;
import util.DbUtil;

public class DbExam5_Select {
    public static void main(String[] args) {
    	ProductDao dao = new ProductDao(DbUtil.getConnection());
    	
    	Integer productId = 102;
    	
    	Product product = dao.fintdByProductId(productId);
    	
    	System.out.println("product_id:" + product.getProductId() + ", product_name:" + product.getProductName() + ", price:" + product.getPrice());
    }
}