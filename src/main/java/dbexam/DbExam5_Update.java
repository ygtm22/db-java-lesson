package dbexam;

import enitity.Product;
import util.DbUtil;

public class DbExam5_Update {
    public static void main(String[] args) {
    	ProductDao dao = new ProductDao(DbUtil.getConnection());
    	
    	Product product = new Product(101, "シャープペンシル", 70);
    	
    	System.out.println("更新前");
    	Product beforeProduct = dao.fintdByProductId(product.getProductId());
    	printProduct(beforeProduct);
    	
    	dao.update(product);
    	
    	System.out.println("更新後");
    	Product afterProduct = dao.fintdByProductId(product.getProductId());
    	printProduct(afterProduct);
    }

	private static void printProduct(Product product) {
		System.out.println("product_id:" + product.getProductId() + ", product_name:" + product.getProductName() + ", price:" + product.getPrice());
	}
}